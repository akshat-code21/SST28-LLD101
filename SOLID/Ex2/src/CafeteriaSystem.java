import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private int invoiceSeq = 1000;
    private final Saveable saveable;
    private final Printer printer;

    CafeteriaSystem(Saveable saveable,Printer printer){
        this.saveable = saveable;
        this.printer = printer;
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i);}

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        InvoiceFormatter invoiceFormatter = new InvoiceFormatter(++invoiceSeq);
        PricingService ps = new PricingService(menu,lines);
        double subtotal = ps.calculateSubTotal();
        invoiceFormatter.appendLineItems(ps.getList());

        TaxUtil taxUtil = new TaxUtil(customerType);
        double taxPct = taxUtil.getTaxPct();
        TaxingService ts = new TaxingService(subtotal,taxPct);
        double tax = ts.calculateTax();

        DiscountingService ds = new DiscountingService(customerType, subtotal, lines.size());
        double discount = ds.calculateDiscount();

        double total = subtotal + tax - discount;

        invoiceFormatter.setSubtotal(subtotal);
        invoiceFormatter.setTaxPct(taxPct);
        invoiceFormatter.setTax(tax);
        invoiceFormatter.setDiscount(discount);
        invoiceFormatter.setTotal(total);

        String printable = invoiceFormatter.getMatter();
        printer.printInvoice(printable);
        String invId = invoiceFormatter.getInvId();

        saveable.save(invId, printable);
        printer.printSavedInvoice(invId,saveable.countLines(invId));
    }
}
