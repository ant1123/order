import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
 import ord.*;
/**
 * Created with IntelliJ IDEA.
 * User: AJ
 * Date: 13.12.13
 * Time: 20:58
 * To change this template use File | Settings | File Templates.
 */
public class Checker extends HttpServlet {
    OrderHistory orh;
    String username;
    @Override
    public void init(ServletConfig config) throws ServletException
    {
         orh=null;
        try{
            orh= Parser.unmarshall();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        if(orh==null){
            orh=new OrderHistory();
            System.out.println("No order history");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
                username=request.getParameter("name");
                String path="order.jsp";
               Order ord=null;
        if(!orh.getOrders().isEmpty()) ord=orh.getOrders().get(username);
                request.setAttribute("order",ord);
                RequestDispatcher rd=request.getRequestDispatcher(path);
                rd.forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       String model=request.getParameter("model");
        String color=request.getParameter("color");
        String price=request.getParameter("price");
    //    PrintWriter pw=response.getWriter()  ;
       // pw.print("<html><body>");


      if((!model.equals(""))&&(!price.equals(""))&&(!color.equals(""))){
           try{
               Order ord=null;
               if((orh.getOrders().isEmpty())||(orh.getOrders().get(username)==null))
               orh.getOrders().put(username,new Order());
               ord=orh.getOrders().get(username);
               Car  car= new Car(model, color,
               Double.parseDouble(price));

               if(ord.getCars()!=null)ord.getCars().add(car);
               request.setAttribute("order",ord);
               RequestDispatcher rd=request.getRequestDispatcher("order.jsp");
               rd.forward(request,response);
           }
           catch(Exception e){
               request.setAttribute("exeption",e);
               RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
               rd.forward(request,response);
           }
        }
       // pw.print("</html></body>");
    }

    @Override
    public void destroy()
    {
        try{
            Parser.marshall(orh);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
