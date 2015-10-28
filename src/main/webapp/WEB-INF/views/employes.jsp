<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>



<!doctype html>
<html lang="fr">
<head>
<title>Employés</title>
<%@ include file="include.jsp"%>
<script type="text/javascript">
	function confirmation(id) {
		var conf = confirm("Etes vous sur de vouloir supprimer?");
		if (conf == true)
			document.location = "suppEmp?idEmp=" + id;

	}
</script>


</head>

<body>
	<div class="errors">${exception}</div>



	<div class="generic-container ">
	
	<div class="container">

		<%@ include file="navigation.jsp"%>
		
		<div class="well">
            <a href="/annuaire/admin/nouvelEmp">Ajouter un Employé</a></div>

		<div class="row">


			<div style="display: none"
				>
				<div class="thumbnail">
					<div class="caption">

						<div id="formEmp">
							<f:form modelAttribute="employe" action="saveEmp"
								method="post" enctype="multipart/form-data" class="form-horizontal registrationEmpForm">
								
								
								<c:if test="${save eq true}">
									<div class="alert alert-success">Employe enregistrer avec success!</div>
								</c:if>
								<c:if test="${suppr eq true}">
									<div class="alert alert-warning">Employe Supprimer avec success!</div>
								</c:if>
								
									<div style="display: none">
										<td>ID Employe</td>
										<td><f:input path="idEmploye" /></td>
										<td><f:errors path="idEmploye" cssClass="errors"></f:errors></td>

									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Civilite</label>
										
										
										
										<div class="col-sm-2" id="civilite">
										<f:select class="form-control" path="civilite">
											<f:option value="--Genre--"  selected="selected"/>
											<f:option value="Mlle"  />

											<f:option value="Mme" />
											<f:option value="Mr" />



										</f:select>
									</div>
									<div><f:errors path="civilite" cssClass="errors help-inline"></f:errors></div >
									</div>
									
									<div class="form-group">
										<label class="col-sm-2 control-label">Nom</label>
										<div class="col-sm-3"><f:input class="form-control" placeholder="Nom" path="nom" /></div>
										<td><f:errors path="nom" cssClass="errors"></f:errors></td>
										<label class="col-sm-2 control-label">Prenom</label>
										<div class="col-sm-5"><f:input class="form-control" placeholder="Prenom" path="prenom" /></div>
										<td><f:errors path="prenom" cssClass="errors"></f:errors></td>
										
									</div>
									<div class="form-group ">
										
										

									</div>
									
									<div class="form-group">
										

									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Mobile</label>
										<div class="col-sm-3"><f:input path="mobile"  class="form-control" placeholder="Num Portable"/></div>
										<td><f:errors path="mobile" cssClass="errors"></f:errors></td>

									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Mobile2</label>
										<div class="col-sm-3"><f:input path="mobile2" class="form-control" placeholder="Autre mobile" /></div>
										<td><f:errors path="mobile2" cssClass="errors"></f:errors></td>

									</div>
									<div class="form-group">
										<label  class="col-sm-2 control-label">Interphone</label>
										<div class="col-sm-3"><f:input path="interphone" class="form-control" placeholder=" Interphone" /></div>
										<td><f:errors path="interphone" cssClass="errors"></f:errors></td>

									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Email</label>
										<div class="col-sm-5"><f:input path="mail" class="form-control" placeholder=" Email" /></div>
										<td><f:errors path="mail" cssClass="errors"></f:errors></td>

									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Bureau</label>
										<div class="col-sm-2"><f:input path="bureau" class="form-control" placeholder=" Bureau" /></div>
										<td><f:errors path="bureau" cssClass="errors"></f:errors></td>

									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Etage</label>
										<div class="col-sm-2"><f:input path="etage"  class="form-control" placeholder=" Etage"/></div>
										<td><f:errors path="etage" cssClass="errors"></f:errors></td>

									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Batiment</label>
										<div class="col-sm-2"><f:input path="batiment" class="form-control" placeholder=" Batiment" /></div>
										<td><f:errors path="batiment" cssClass="errors"></f:errors></td>

									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" >Status</label>
										<div class="col-sm-2"><f:input path="status" class="form-control" placeholder=" Interphone" /></div>
										<td><f:errors path="status" cssClass="errors"></f:errors></td>

									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Direction</label>
										<div class="col-sm-2"><f:select class="form-control" path="direction.idDirection"
												items="${direction}" itemValue="idDirection"
												itemLabel="nomDirection"></f:select></div>
										<td><f:errors path="direction.idDirection"
												cssClass="errors"></f:errors></td>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Service</label >
										<div class="col-sm-2"><f:select class="form-control" path="service.idService"
												items="${service}" itemValue="idService"
												itemLabel="nomService"></f:select></div>
										<td><f:errors path="service.idService"
												cssClass="errors"></f:errors></td>
									</div>
									
									
									 <div class="form-group">
										<label class="col-sm-2 control-label">Fonctions</label >
										<div class="col-md-7"><f:select class="form-control" path="fonctions"
												items="${fonction}" size="5"  multiple="true" itemValue="idFonction"
												itemLabel="nomFonction"></f:select></div>
										<div><f:errors path="fonctions"
												cssClass="errors help-inline"></f:errors></div>
									</div>
 


									<div class="form-group">
										<label class="col-sm-2 control-label">Photo</label>
										<div><c:if test="${employe.idEmploye!=null }">
												<img src="photoEmp?idEmp=${employe.idEmploye }">
											</c:if></div>
										<input type="file" name="file" />
										<td></td>
									</div>
									
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">

										<div><input class="btn btn-success" type="submit" value="Save" /></div>
									</div>
									</div>
								
							</f:form>
						</div>


					</div>
				</div>
			</div>



			<div class="col-lg-offset-1 col-sm-offset-1 col-lg-8 col-sm-7 col-lg-push-2 col-sm-push-3">
				<div class="thumbnail">
					<div class="caption">


						<div id="formrech">
							<f:form modelAttribute="employeForm" action="rechEmp"
								method="post" class="form-inline">
								
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
			
			<div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Les Employés</span></div>
			<table id="" class="table table-striped table-bordered ">
				<tr>
					<th style="display: none">ID</th>
					<th>civilite</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Phone</th>
					<th>Mobile</th>

					<th>Interphone</th>
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

						<td>${emp.interphone }</td>
						<td>${emp.mail }</td>
						<td>${emp.bureau }</td>
						<td>${emp.etage }</td>
						<td>${emp.batiment }</td>


						<td>${emp.direction.nomDirection }</td>
						<td>${emp.service.nomService }</td>

						<td>${emp.photo }</td>
						<td><img src="photoEmp?idEmp=${emp.idEmploye }"></td>
						<td><a class="btn btn-danger"
							href="suppEmp?idEmp=${emp.idEmploye }">Supp</a></td>
						<td><a class="btn btn-warning"
							href="editEmp?idEmp=${emp.idEmploye }">Edit</a></td>




					</tr>
				</c:forEach>
			</table>
			</div>

</div>
		</div>

	</div>

	<%@ include file="include2.jsp"%>

</body>
</html>