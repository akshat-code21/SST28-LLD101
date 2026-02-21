public class TaxingService {
    private double taxAmt;
    private double subtotal;
    private double taxPct;
    public TaxingService(double subtotal,double taxPct){
        this.subtotal = subtotal;
        this.taxPct = taxPct;
    }
    double calculateTax(){
        taxAmt = subtotal * (taxPct / 100.0);
        return taxAmt;
    }
}
