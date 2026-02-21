import java.util.List;

public class InvoiceFormatter{
    private final StringBuilder out;
    private final int invoiceSeq;
    private double subtotal;
    private double taxPct;
    private double tax;
    private double discount;
    private double total;
    private final String invId;

    public InvoiceFormatter(int invoiceSeq) {
        out = new StringBuilder();
        this.invoiceSeq = invoiceSeq;
        this.invId = "INV-" + (invoiceSeq);
        out.append("Invoice# ").append(invId).append("\n");
    }

    public String getMatter(){
        out.append(String.format("Subtotal: %.2f\n", subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", taxPct, tax));
        out.append(String.format("Discount: -%.2f\n", discount));
        out.append(String.format("TOTAL: %.2f\n", total));
        return out.toString();
    }

    public void appendLineItems(List<LineItem> list){
        for(LineItem item : list) {
            out.append(String.format("- %s x%d = %.2f\n", item.getName(), item.getQty(), item.getLineTotal()));
        }
    }

    public String getInvId() {
        return invId;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTaxPct(double taxPct) {
        this.taxPct = taxPct;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
