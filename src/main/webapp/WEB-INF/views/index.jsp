<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!doctype html>
<html lang="fr">
<head>

<%@ include file="include.jsp"%>



</head>

<body>
	



	<div class="container">

		<%@ include file="navigation.jsp"%>

		<div class="row">


			<div
				class="col-lg-offset-1 col-sm-offset-1 col-lg-8 col-sm-7 col-lg-push-2 col-sm-push-3">
				<div class="thumbnail">
					<div class="caption">

						<div id="formEmp">
							<f:form modelAttribute="employeForm" action="saveEmp"
								method="post" enctype="multipart/form-data" class="form-horizontal">
								
								
								
							</f:form>
						</div>


					</div>
				</div>
			</div>



			<div class="col-lg-3 col-sm-4 col-lg-pull-9 col-sm-pull-8">
				<div class="thumbnail">
					<div class="caption">


						<div id="formrech">
							<f:form modelAttribute="employeForm" action="rechEmp"
								method="post" class="form-horizontal">
								
									<div class="form-group">
										<label class="control-label">Nom</label>
										<td><f:input path="codeEmploye" /></td>
										<td><f:errors path="codeEmploye" cssClass="errors"></f:errors></td>

									</div>
									
									<div class="form-group">
									<div class=" col-sm-offset-2 col-sm-10">
										<div><input class="btn btn-info" type="submit" value="Rechercher" /></div>
									</div>
									</div>
								
							</f:form>
						</div>



					</div>
				</div>
			</div>
		</div>

		<div id="" class="row">
			<h3>Table des Employes</h3>
			<table id="" class="table table-striped table-bordered ">
				<tr>
					<th style="display: none">ID</th>
					<th>civilite</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Phone</th>
					<th>Mobile</th>

					
					<th>Email</th>
					<th>Bureau</th>
					<th>Etage</th>
					<th>Batiment</th>

					<th>Direction</th>
					<th>Service</th>
					<th>Photo</th>
				</tr>
				<c:forEach items="${employes}" var="emp">
					<tr>
						<td style="display: none">${emp.idEmploye }</td>
						<td>${emp.civilite }</td>
						<td>${emp.nom }</td>
						<td>${emp.prenom }</td>
						<td>${emp.telephone }</td>
						<td>${emp.mobile }</td>

						
						<td>${emp.mail }</td>
						<td>${emp.bureau }</td>
						<td>${emp.etage }</td>
						<td>${emp.batiment }</td>


						<td>${emp.direction.nomDirection }</td>
						<td>${emp.service.nomService }</td>

						<td>${emp.photo }</td>
						<td><img src="photoEmp?idEmp=${emp.idEmploye }"></td>
						




					</tr>
				</c:forEach>
			</table>


		</div>

	</div>

	<%@ include file="include2.jsp"%>

</body>
</html>