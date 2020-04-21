<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>

<script type="text/javascript">
    function validate() {
    	if (document.forms["employee"]["id"].value == "") {
            alert("enter emp Id");
            document.forms["employee"]["id"].focus();
            return false;
      	 }
         if (document.forms["employee"]["firstName"].value == "") {
              alert("enter first name");
              document.forms["employee"]["firstName"].focus();
              return false;
         }
         if (document.forms["employee"]["lastName"].value == "") {
              alert("enter last name");
              document.forms["employee"]["lastName"].focus();
              return false;
         }
         if (document.forms["employee"]["email"].value == "") {
              alert("enter email");
              document.forms["employee"]["email"].focus();
              return false;
         }
   }
</script>
</head>
<body>
<h2 style="vertical-align: center; margin-left:23%;">Add Employee</h2>
  <form:form method="POST" modelAttribute="employee" action="edit/id" name="employee">
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
