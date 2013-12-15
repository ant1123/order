<%--
  Created by IntelliJ IDEA.
  ord.User: AJ
  Date: 14.12.13
  Time: 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ord.*" %>
<%@page import="java.util.*"%>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<form name='data' action="Checker" method="post">
<%Order order=(Order) request.getAttribute("order");
    if((order!=null)&&(order.getCars()!=null)) {
Iterator it=order.getCars().iterator();
%>
    <table border="1">
        <tr><th>MODEL</th>
        <th>COLOR</th>
        <th>PRICE</th></tr>
 <%while (it.hasNext()){
 Car car=(Car)it.next();%>
   <tr><td>
       <%=car.getModel()%>
   </td>
       <td>
           <%=car.getColor()%>
       </td>
       <td>
           <%=car.getPrice()%>
       </td></tr>

        <%}%>
    </table>
    <%}%>
    <br>
    <table border='1'>
      <tr>
          <td>Model
          <select name="model" onchange="document.getElementById('price').value=(50000+5000*this.selectedIndex)">
              <option value="BMW">BMW</option>
              <option value="RENO">RENO</option>
              <option value="KIA">KIA</option>
          </select>
          </td>
          <td>Color
              <select name="color">
                  <option value="red">red</option>
                  <option value="blue">green</option>
                  <option value="green">blue</option>
              </select>
          </td>
        <tr><td colspan="2" align='center'>
              Price
           <input type="text" name="price"  id="price" style="width: 100px" readonly="true" value='50000'/>
          </td>
      </tr>
    </table>  <br>
            <input type="submit"  value='add' style="width: 200px"/>
</form>
<form name="log" action="index.jsp">
    <input type="submit" value="logout" style="width: 200px"/>
</form>
</body>
</html>