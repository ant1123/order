package ord; /**
 * Created with IntelliJ IDEA.
 * User: AJ
 * Date: 13.12.13
 * Time: 21:24
 * To change this template use File | Settings | File Templates.
 */
import javax.xml.bind.annotation.*;
import java.util.*;
@XmlType
@XmlRootElement
public class OrderHistory {
 ArrayList<User> users;
 HashMap<String,Order> orders;

    public OrderHistory() {
        orders=new HashMap<String,Order>();
    }

    public OrderHistory( HashMap<String,Order> orders) {
        this.orders = orders;
    }

    public HashMap<String, Order> getOrders() {
        return orders;
    }

    public void setOrders(HashMap<String, Order> orders) {
        this.orders = orders;
    }
}
