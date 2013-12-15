package ord; /**
 * Created with IntelliJ IDEA.
 * User: AJ
 * Date: 13.12.13
 * Time: 21:10
 * To change this template use File | Settings | File Templates.
 */
import javax.xml.bind.annotation.*;
@XmlType
public class Car {
    String model;
    String color;
    double price;

    public Car() {
    }

    public Car(String model, String color, double price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
