import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PricingService {
    private final Map<String, MenuItem> menu;
    private final List<OrderLine> lines;
    private double subTotal;
    private final List<LineItem> list;
    public PricingService(Map<String, MenuItem> menu, List<OrderLine> lines){
        this.menu = menu;
        this.lines = lines;
        this.subTotal = 0.0;
        list = new ArrayList<>();
    }
    public double calculateSubTotal(){
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subTotal += lineTotal;
            list.add(new LineItem(item.name, l.qty, lineTotal));
        }
        return subTotal;
    }
    public List<LineItem> getList(){
        return this.list;
    }
}
