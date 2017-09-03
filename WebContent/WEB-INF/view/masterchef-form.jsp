<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
<title>Masterchef form</title>

</head>

<body>
<h3>Masterchef form</h3>


<form:form action="saveMasterchef" modelAttribute="masterchef">

Name: <form:input path="fullName" />

<br><br>

Website: <form:input path="website" />

<br><br>

Cooking Program: <form:input path="cookingProgram" />

<br><br>

Restaurant: <form:input path="restaurant" />

<br><br>

<input type="submit" value="Save" class="save"/>

</form:form>

<br><br>
<div align="center">
<form>
  <input type="button" value="Go back!" onclick="history.back()">
  </input>
</form>
<br><br>

<form action="${pageContext.request.contextPath}">
    <input type="submit" value="Home site!" />
</form>
</div>
</body>

</html>