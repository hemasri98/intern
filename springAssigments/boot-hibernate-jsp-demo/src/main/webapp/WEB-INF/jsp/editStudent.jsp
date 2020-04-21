<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>

<script type="text/javascript">
    function validate() {
    	if (document.forms["student"]["id"].value == "") {
            alert("enter stu Id");
            document.forms["student"]["id"].focus();
            return false;
      	 }
         if (document.forms["student"]["firstName"].value == "") {
              alert("enter first name");
              document.forms["student"]["firstName"].focus();
              return false;
         }
         if (document.forms["student"]["lastName"].value == "") {
              alert("enter last name");
              document.forms["student"]["lastName"].focus();
              return false;
         }
         if (document.forms["student"]["email"].value == "") {
              alert("enter email");
              document.forms["student"]["email"].focus();
              return false;
         }
   }
</script>
</head>
<body>
<h2 style="vertical-align: center; margin-left:23%;">Edit Student</h2>
  <form:form method="POST" modelAttribute="student" action="edit/id" name="student">
     <table style="vertical-align: center; margin-left:20%;">
 
        <tr>
            <td>Id :</td>
            <td><form:input path="id" id="id" /></td>
        </tr>
        <tr>
            <td>First Name :</td>
            <td><form:input path="firstName" id="firstName" /></td>
        </tr>
        <tr>
            <td>Last Name :</td>
            <td><form:input path="lastName" id="lastName"/></td>
        </tr>
        
        <tr>
            <td>Email Id :</td>
            <td><form:input path="email" id="email"/></td>
        </tr>
        <tr>
             <td colspan="2">
             <input type="submit" onclick="return validate();" value="Edit"></input>
         </td>
    </tr>
</table>
</form:form>

</body>
</html>
