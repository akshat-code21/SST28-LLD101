public class StudentDiscountRule implements DiscountRule{
    private final double subtotal;
    StudentDiscountRule(double subtotal){
        this.subtotal = subtotal;
    }
    public double calculate(){
        if (subtotal >= 180.0) return 10.0;
        return 0.0;
    }
}
