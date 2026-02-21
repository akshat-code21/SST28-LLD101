public class TaxUtil {
    String customerType;
    TaxUtil(String customerType){
        this.customerType = customerType;
    }
    double getTaxPct(){
        TaxRule rule = null;
        if(customerType.equals("student"))
            rule = new StudentTaxRule();
        else if(customerType.equals("staff"))
            rule = new StaffTaxRule();

        if(rule == null)
            return 8.0;

        return rule.calculate();
    }
}
