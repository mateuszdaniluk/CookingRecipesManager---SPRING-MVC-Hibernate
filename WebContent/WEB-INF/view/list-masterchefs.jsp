<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
<title>List of Masterchefs</title>

</head>

<body>


			<h2>Cooking Recipes Manager</h2>
		
		<br>
		Masterchefs list
		
		
		<br><br>
		
			
		
				
				<table id="myTable">
					<tr>
						<th>Name</th>
						<th>Website</th>
						<th>Cooking Program</th>
						<th>Restaurant</th>
						<th>Action</th>
					
					</tr>
					
					
					
					<c:forEach var="tempMasterchef" items="${masterchef }" >
					
						<c:url var="showRecipes" value="/masterchef/showRecipes">
							<c:param name="masterchefId" value="${tempMasterchef.id }"></c:param>
						</c:url>
					
						
						<c:url var="updateLink" value="/masterchef/showFormForUpdate">
							<c:param name="masterchefId" value="${tempMasterchef.id }"></c:param>
						</c:url>
							
						<c:url var="deleteLink" value="/masterchef/deleteMasterchef">
							<c:param name="masterchefId" value="${tempMasterchef.id }"></c:param>
						</c:url>
						
						<tr> 
							<td> ${tempMasterchef.fullName }</td>
							<td> ${tempMasterchef.website }</td>
							<td> ${tempMasterchef.cookingProgram }</td>
							<td> ${tempMasterchef.restaurant }</td>
							<td>
							
								<a href="${showRecipes}">Show Recipes</a>
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
		
		<br> <br>
	
	<table>
					<tr>
						<th>Filtering script:</th>
					</tr>
					<tr> 
						<td><input type="text" id="myInput1" onkeyup="myFunction1()" placeholder="Searching for anything.."></td>
	</table>
	<br><br>
	<input type="button" value="Add masterchef"
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