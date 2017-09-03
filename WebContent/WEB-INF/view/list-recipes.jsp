<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>

<html>
<head>
<title>List of Recipes</title>

</head>

<body>


			<h2>Cooking Recipes Manager</h2>
		<br>
		Recipes List
		<br>
		<br>
		
				<table id="myTable">
					<tr>
						<th>Num</th>
						<th>Name</th>	
						<th>Cousine Type</th>
						<th>Meal Type</th>							
						<th>Action</th>
					
					
					</tr><% int i = 1; %>   <tr>
					<!--  loop over and print our customers -->
					
					<c:forEach var="tempRecipe" items="${recipe }" >
					
						<c:url var="detailsLink" value="/recipe/showDetails">
							<c:param name="recipeId" value="${tempRecipe.id }"></c:param>
						</c:url>
					
						<!-- construct an update link with customer ID -->
						<c:url var="updateLink" value="/recipe/showFormForUpdate">
							<c:param name="recipeId" value="${tempRecipe.id }"></c:param>
						</c:url>
							<!-- construct an delete link with customer ID -->
						<c:url var="deleteLink" value="/recipe/deleteRecipe">
							<c:param name="recipeId" value="${tempRecipe.id }"></c:param>
						</c:url>
						
						<tr height="10px"> 
							<td><%= i %> <% i++; %></td>
                       		<td> ${tempRecipe.name }</td>
							<td> ${tempRecipe.cousineType }</td>
							<td> ${tempRecipe.mealType }</td>
							<td>
							
								<a href="${detailsLink}">Details</a>
								|
								<!-- display the update link -->
								<a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure You want to delete this object?'))) return false"
								>Delete</a>
							</td>
						</tr>
					
					
					</c:forEach>
					
					
				</table>

<br><br>

	<table>
					<tr>
						<th>Filtering script:</th>
					</tr>
					<tr> 
						<td><input type="text" id="myInput1" onkeyup="myFunction1()" placeholder="Searching for anything.."></td>
	</table>
<br><br>
<input type="button" value="Add recipe"
				onclick="window.location.href='showFormForAdd'; 
				return false;"
				class="add-button"
			/>

<br><br>
<div align="center">
<br><br>
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

