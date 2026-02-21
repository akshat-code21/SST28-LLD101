public class LaundryAddOn implements AddOnChoice{
    public boolean isSameAddOn(AddOn addOn){
        return addOn == AddOn.LAUNDRY;
    }
    public Money getAddOnPrice(){
        return new Money(500.0);
    }
}
