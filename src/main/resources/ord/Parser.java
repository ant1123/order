package ord; /**
 * Created with IntelliJ IDEA.
 * User: AJ
 * Date: 13.12.13
 * Time: 21:29
 * To change this template use File | Settings | File Templates.
 */
import javax.xml.bind.*;
import java.io.*;
public class Parser {
    public static void marshall(OrderHistory obj) throws JAXBException
    {
      JAXBContext jc=JAXBContext.newInstance(OrderHistory.class);
       Marshaller m=jc.createMarshaller();
       m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        try{
         File fil=new File("orders.xml") ;
         FileOutputStream fio=new FileOutputStream(fil);
            m.marshal(obj,fio);
            fio.close();
        }
        catch(Exception e)  {
            System.out.println(e.getMessage());
        }
    }
    public static OrderHistory unmarshall() throws JAXBException
    {
        JAXBContext jc=JAXBContext.newInstance(OrderHistory.class);
        OrderHistory obj=null;
        Unmarshaller un=jc.createUnmarshaller();
        try{
            File fil=new File("orders.xml");
            System.out.println(fil.exists());
            FileInputStream ios= new FileInputStream(fil);
            obj=(OrderHistory) un.unmarshal(ios) ;
        }
        catch(Exception e)   {
            e.getMessage();
        }
        return obj;
    }
}
