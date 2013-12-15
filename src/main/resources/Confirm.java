import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
 * Date: 14.12.13
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public class Confirm extends HttpServlet {

    public  String PERSISTENCE_UNIT_NAME="CashM" ;
    EntityManagerFactory factory;
    EntityManager em;
    private User getUserByName(String name)
    {
        if(em==null) return null;
        else
        return em.find(User.class, name);
    }
    public String hash(String passw){
        return ""+passw.hashCode();
    }
    @Override
    public void init(ServletConfig config) throws ServletException
    {
         factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
         em =factory.createEntityManager();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
        String name=request.getParameter("name");
        String passw=request.getParameter("passw");
        if((name!=null)&&(passw!=null))
        if((!name.equals(""))&&((!passw.equals(""))))
        {   User us=new User(name,passw) ;
           User us2=getUserByName(name);
         //   PrintWriter pw=response.getWriter()  ;


           if((us2!=null)&&(us2.getPassw().equals(hash(us.getPassw())))) {
               RequestDispatcher rd=request.getRequestDispatcher("/Checker");


              if( rd!=null) rd.forward(request,response);
            }
            else{

               request.setAttribute("exeption",new Exception("No such user!!"));
                RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
                rd.forward(request,response);
            }
        }
        }
        catch (Exception e){
            request.setAttribute("exeption",e);
            RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
            rd.forward(request,response);
        }
    }
    @Override
    public void destroy()
    {
    em.close();
    }


}