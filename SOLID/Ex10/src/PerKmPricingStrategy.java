public class PerKmPricingStrategy implements IPricingStrategy{
    private static final double BASE_FARE = 50.0;
    private static final double RATE_PER_KM = 20.0 / 3.0; // = 6.666... per km
    @Override
    public double calculateFare(double km) {
        double fare = BASE_FARE + km * RATE_PER_KM;
        return Math.round(fare * 100.0) / 100.0;
    }
}
