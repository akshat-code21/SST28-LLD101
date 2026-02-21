public class LineItem {
    private final String name;
    private final int qty;
    private final double lineTotal;
    public LineItem(String name,int qty,double lineTotal){
        this.name = name;
        this.qty = qty;
        this.lineTotal = lineTotal;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public double getLineTotal() {
        return lineTotal;
    }
}
