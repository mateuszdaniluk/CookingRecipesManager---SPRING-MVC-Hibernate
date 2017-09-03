<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Recipe Form</title>


</head>

<body>

			<h2>Cooking Recipes Manager</h2>
	

	
		<h3>Recipe form</h3>
		<form:form action="saveRecipe" modelAttribute="recipe" method="POST">
		
			<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name"/></td>
					<tr>
					
					<tr>
						<td><label>Preparation:</label></td>
						<td><form:textarea path="preparation" rows="10" cols="50"/></td>
					<tr>
					
					<tr>
						<td><label>Cousine Type:</label></td>
					
						<td><form:select path="cousineType">
   						 <form:option value="" label="*** Select cousineType ***" />
   						 <form:options items="${cousine}" />
						</form:select>
						
						</td>
					<tr>
					
					<tr>
						<td><label>Meal Type:</label></td>
						<td><form:select path="mealType" >
   						 <form:option value="" label="*** Select mealType ***" />
   						 <form:options items="${meal}" />
						</form:select>
						
					<tr>

					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					<tr>
				</tbody>
			
			</table>
		
		
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