<!DOCTYPE html>

<html>
<head>

<title>Cooking Recipes Manager</title>
</head>
<body>
	<h2>
		<div align="center">
			Cooking Recipes Manager <br> Welcome!
		</div>

	</h2>
	<form:form name="submitForm" modelAttribute="masterchef" method="POST">
		<div align="center">
			<br>
			This is "Cooking recipes manager" application. 
			<br> 
			That's my first Spring MVC and Hibernate project.
			<br> 
			Next time I am gonna build something more complex.
			<br>
			<br>
			<br>
			Application does not support CSS, because I am still "newbie" coder
			<br>
			and I want to focus on back-end skills. That's my main goal right know. 
			<br> 
			With my few months expierience I trying to learn fundamental basics 
			<br>
			topics for my first job as a developer.
			<br> 
			<br>
			I am gonna learn HTML and CSS in the future...
			<br>
			Enough talking. Enjoy the app. ;)
		


		</div>
	</form:form>


	<div align="center">
		
		
		<br><br>
		

		<form action="${pageContext.request.contextPath}/recipe/list">
			<input type="submit" value="Recipes List!" />
		</form>

		<br>
		<form action="${pageContext.request.contextPath}/masterchef/list">
			<input type="submit" value="Favorite masterchef List!" />
		</form>
		<br>


	</div>

	<br>
	<br>
	<br>
	created by: Mateusz Daniluk
	<br>
	AD 2017


</body>
</html>