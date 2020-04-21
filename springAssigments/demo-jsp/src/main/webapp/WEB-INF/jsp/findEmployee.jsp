<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="stag" %>
<!DOCTYPE html>
<html>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 60%;
}

td, th {
  border: 1px solid black;
  text-align: left;
  padding: 10px;
}
</style>
<body>
<h1 style="vertical-align: center; margin-left:23%;"> Employee Details </h1>
<table style="vertical-align: center; margin-left:20%;"">
       <tr>
       	   <th>Id</th>
           <th>First Name</th>
           <th>Last Name</th>
           <th>Email Id</th>

       </tr>
       <tr>
       		<td>${findEmp.id}</td>
           <td>${findEmp.firstName}</td>
           <td>${findEmp.lastName}</td>
           <td>${findEmp.email}</td>
           </tr>
      </table>
 </body>
 </html>