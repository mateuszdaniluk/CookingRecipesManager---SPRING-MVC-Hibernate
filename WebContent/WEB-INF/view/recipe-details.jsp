<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Recipe details</title>


</head>

<body>



			<h2>Cooking Recipes Manager</h2>
		<br><br>
		Recipe Details:
<br><br>

		<form:form action="saveRecipe" modelAttribute="recipe" method="POST">
		
			<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><label>Masterchef name:</label></td>
						<td>${recipe.author }</td>
						
					<tr>
					<tr>
						<td><label>Name:</label></td>
						<td>${recipe.name }</td>
						
					<tr>
		
					<tr>
						<td><label>Cousine Type:</label></td>
					
						<td>${recipe.cousineType }						</td>
					<tr>
					
					<tr>
						<td><label>Meal Type:</label></td>
						<td>${recipe.mealType }</td>
						
					<tr>
					
					
					<tr>
						<td><label>Preparation:</label></td>
						<td><output>${recipe.preparation }</output>  </td>
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