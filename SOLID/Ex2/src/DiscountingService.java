public class DiscountingService {
    private final String customerType;
    private final double subtotal;
    private final int distinctLines;

    public DiscountingService(String customerType, double subtotal, int distinctLines) {
        this.customerType = customerType;
        this.subtotal = subtotal;
        this.distinctLines = distinctLines;
    }
    double calculateDiscount(){
        DiscountRule rule = null;
        if(customerType.equals("student"))
            rule = new StudentDiscountRule(subtotal);
        else if(customerType.equals("staff"))
            rule = new StaffDiscountRule(distinctLines);
        if(rule == null)
            return 0.0;
        return rule.calculate();
    }
}
