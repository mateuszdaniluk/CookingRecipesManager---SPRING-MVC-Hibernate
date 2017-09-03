<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
<title>Masterchef Recipes List</title>

</head>

<body>


	
			<h2>Cooking Recipes Manager</h2>
	
	Masterchef Recipes List
	<br><br>

The Masterchef data: 
<br>
Name: ${masterchef.fullName } 
<br>
Website: ${masterchef.website }
<br>
Cooking program: ${masterchef.cookingProgram } 
<br>
Restaurant: ${masterchef.restaurant }
<br>		
<br><br>
					
				
				</tr><% int i = 1; %>   <tr>
					
				<table id="myTable">
					<tr>
						<th>Num</th>
						<th>Cousine Type</th>
						<th>Meal Type</th>
						<th>Name</th>		
						<th>Action</th>
					
					
					</tr> <tr>
				
					<c:forEach var="tempList" items="${list }"  >
					
						<c:url var="detailsLink" value="/recipe/showDetails">
							<c:param name="recipeId" value="${tempList.id }"></c:param>
						</c:url>
					
						<c:url var="updateLink" value="/recipe/showFormForUpdate">
							<c:param name="recipeId" value="${tempList.id }"></c:param>
						</c:url>
						
						<c:url var="deleteLink" value="/recipe/deleteRecipe">
							<c:param name="recipeId" value="${tempList.id }"></c:param>
						</c:url>
						
						<tr> 
							<td> <%= i %> <% i++; %></td>
                       		<td> ${tempList.cousineType }</td>
							<td> ${tempList.mealType }</td>
							<td> ${tempList.name }</td>
							<td>
							
								<a href="${detailsLink}">Details</a>
								|

								<a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure You want to delete this object?'))) return false"
								>Delete</a>
							</td>
						</tr>
					
					</c:forEach>
					
				</table>
</tr>


<br>

<br>
<table>
					<tr>
						<th>Filtering script:</th>
					</tr>
					<tr> 
						<td><input type="text" id="myInput1" onkeyup="myFunction1()" placeholder="Searching for anything.."></td>
</table>


<br>
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


<script>
function myFunction1() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput1");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
	  for (j = 0; j < 5; j++) {
   		 td = tr[i].getElementsByTagName("td")[j];
    		if (td) {
     		 if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
      			  tr[i].style.display = "";
      				break;
     		 } else {
       			 tr[i].style.display = "none";
      	}
    	}       
  		}
  }
}
</script>
</body>

</html>