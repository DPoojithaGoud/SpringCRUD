 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
  
<h1>Student List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>College</th><th>City</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="stu" items="${list}">   
   <tr>  
   <td>${stu.id}</td>  
   <td>${stu.name}</td>  
   <td>${stu.college}</td>  
   <td>${stu.city}</td>  
   <td><a href="editstu/${stu.id}">Edit</a></td>  
   <td><a href="deletestu/${stu.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="stuform">Register New Student</a>  
   