public class GymAddOn implements AddOnChoice{
    public boolean isSameAddOn(AddOn addOn){
        return addOn == AddOn.GYM;
    }
    public Money getAddOnPrice(){
        return new Money(300.0);
    }
}
