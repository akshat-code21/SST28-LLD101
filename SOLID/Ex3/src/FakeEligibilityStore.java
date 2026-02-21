public class FakeEligibilityStore implements Saveable{
    public void save(String roll, String status) {
        System.out.println("Saved evaluation for roll=" + roll);
    }
}
