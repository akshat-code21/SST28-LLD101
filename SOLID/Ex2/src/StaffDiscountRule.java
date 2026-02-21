public class StaffDiscountRule implements DiscountRule{
    private final double distinctLines;
    StaffDiscountRule(double distinctLines){
        this.distinctLines = distinctLines;
    }
    public double calculate(){
        if (distinctLines >= 3) return 15.0;
        return 5.0;
    }
}
