public class MessAddOn implements AddOnChoice{
    public boolean isSameAddOn(AddOn addOn){
        return addOn == AddOn.MESS;
    }
    public Money getAddOnPrice(){
        return new Money(1000.0);
    }
}
