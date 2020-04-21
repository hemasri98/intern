<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Student</title>

<script type="text/javascript">
    function validate() {
    	if (document.forms["student"]["id"].value == "") {
            alert("enter stu Id");
            document.forms["student"]["id"].focus();
            return false;
      	 }
   }
</script>
</head>
<body>
<h2 style="vertical-align: center; margin-left:23%;">Enter id</h2>
  <form:form method="POST" modelAttribute="deleteStu" action="delete/id">
     <table style="vertical-align: center; margin-left:20%;">
 
       <tr>
            <td>Id :</td>
            <td><form:input path="id" id="id" /></td>
        </tr>
        
        <tr>
            <td >
             <input type="submit" onclick="return validate();" value="Delete"></input>
         </td>
    </tr>
</table>
</form:form>

</body>
</html>
