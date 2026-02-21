public class OutputPrinter implements Printer{

    public void printHeader(){
        System.out.println("=== Cafeteria Billing ===");
    }

    @Override
    public void printInvoice(String printable) {
        System.out.print(printable);
    }

    @Override
    public void printSavedInvoice(String invId, int lines) {
        System.out.println("Saved invoice: " + invId + " (lines=" + lines + ")");
    }
}
