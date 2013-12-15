package ord; /**
 * Created with IntelliJ IDEA.
 * User: AJ
 * Date: 13.12.13
 * Time: 21:15
 * To change this template use File | Settings | File Templates.
 */
import javax.xml.bind.annotation.*;
import java.util.*;
@XmlType
public class Order {
 ArrayList<Car> cars;

    public Order() {
        cars=new ArrayList<Car>();
    }

    public Order(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }


}
