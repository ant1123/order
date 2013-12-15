package ord; /**
 * Created with IntelliJ IDEA.
 * User: AJ
 * Date: 13.12.13
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;
@Entity
public class User {
    @Id
    String name;
    String passw;

    public User() {
    }

    public User(String name, String passw) {
        this.name = name;
        this.passw = passw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }
}
