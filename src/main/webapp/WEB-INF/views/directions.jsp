<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!doctype html>
<html lang="fr">


<head>

<meta charset="utf-8">
<%@ include file="include.jsp"%>

<script type="text/javascript">
	function confirmation(id) {
		var conf = confirm("Etes vous sur de vouloir supprimer?");
		if (conf == true)
			document.location = "suppDir?idDir=" + id;

	}
</script>

</head>

<body>
	<div class="errors">${exception }</div>
	
	<div class="generic-container ">

	<div class="container">

		<%@ include file="navigation.jsp"%>
		
		<div class="well">
            </div>

		

		<div class="row">


			<div
				class="col-lg-offset-1 col-sm-offset-1 col-lg-8 col-sm-7 col-lg-push-2 col-sm-push-3">
				<div class="thumbnail">
					<div class="caption">

						<div id="formDir">
							<f:form class="form-horizontal registrationDirForm" modelAttribute="direction"
								action="saveDir" method="post">
							
								<c:if test="${save eq true}">
									<div class="alert alert-success">Direction enregistrer avec success!</div>
								</c:if>
								
								<c:if test="${suppr eq true}">
									<div class="alert alert-warning">Direction Supprimer avec success!</div>
								</c:if>

								<div style="display: none">
									<td>ID Direction</td>
									<td><f:input path="idDirection" /></td>
									<td><f:errors path="idDirection"
											cssClass="errors"></f:errors></td>

								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Code</label>
									<div class="col-sm-3">
										<f:input class="form-control " placeholder="Acronyme"
											path="nomDirection" />
									</div>
									<div>
										<f:errors path="nomDirection" cssClass="errors"></f:errors>
									</div>

								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Nom</label>
									<div class="col-sm-5">
										<f:input class="form-control" placeholder="Nom"
											path="description" />
									</div>
									<div>
										<f:errors path="description" cssClass="errors"></f:errors>
									</div>

								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Localisation</label>
									<div class="col-sm-7">
										<f:input class="form-control" path="localisation" />
									</div>
									<div>
										<f:errors path="localisation" cssClass="errors">
										</f:errors>
									</div>

								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Categories</label>
									<div class="col-sm-8">
										<label class="checkbox-inline"> Centrale:<f:radiobutton
												path="categorie" value="Direction Centrale"
												class="simple" /></label> <label class="checkbox-inline">Departemental:<f:radiobutton
												path="categorie" value="Direction Departementale"
												class="simple" /></label> <label class="checkbox-inline">Technique:<f:radiobutton
												path="categorie" value="Direction Technique"
												class="parent" /></label> <label class="checkbox-inline">OST:<f:radiobutton
												path="categorie" value="OST" class="parent" /></label>


									</div>
								</div>



								<div class="form-group">
									<label class="col-sm-2 control-label">Type de Direction</label>

									<div class="col-sm-3" id="nature">
										<f:select class="form-control" path="nature">
											<f:option value="Autonome" selected="selected" id="autonome" />

											<f:option value="Generale" style="display : none"
												id="general" class="montre" />
											<f:option value="Simple" style="display : none"
												class="montre" id="directionfils" />



										</f:select>
									</div>



									<td><f:errors path="nature" cssClass="errors"></f:errors></td>

								</div>

								<div class="form-group" style="display: none"
									id="directionparent">
									<label class="col-sm-2 control-label">Direction Parent</label>
									<div class="col-sm-4">
										<f:select class="form-control"
											path="directionsup.idDirection" items="${directions }" itemValue="idDirection"
												itemLabel="nomDirection" >
											
										</f:select>
										<td><f:errors path="directionsup.idDirection"
												cssClass="errors"></f:errors>
									</div>
								</div>
								
								


								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<div>
											<input class="btn btn-success" type="submit" value="Save" />
										</div>
									</div>
								</div>


							</f:form>
						</div>


					</div>
				</div>
			</div>


			<div class="col-lg-3 col-sm-4 col-lg-pull-9 col-sm-pull-8">
				<div class="thumbnail">
					<div class="caption">
						<div id="formrech">
							<f:form class="form-horizontal" modelAttribute="directionForm"
								action="rechDir" method="post">

								<div class="form-group">
									<label class="label-control">Nom </label>
									<td><f:input path="codeDirection" /></td>
									<td><f:errors path="codeDirection" cssClass="errors"></f:errors></td>

								</div>


								<div class="form-group">
									<div class=" col-sm-offset-2 col-sm-10">
										<button class="btn btn-info" type="submit" value="Rechercher">Rechercher
										</button>
									</div>
								</div>


							</f:form>
						</div>
					</div>
				</div>
			</div>

		</div>


		<c:if test="${empty directionForm.exception }">
			<div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Les Directions</span></div>
				<table id="" class="table table-striped table-bordered ">
					<tr>
						<th style="display: none">ID</th>
						<th>Code</th>
						<th>Nom</th>
						<th>Localisation</th>
						<th>Categorie</th>
						<th>Type de Direction</th>
						<th>Direction Parent</th>
					</tr>
					<c:forEach items="${directions}" var="dir">
						<tr>
							<td style="display: none">${dir.idDirection }</td>
							<td>${dir.nomDirection }</td>
							<td>${dir.description }</td>
							<td>${dir.localisation }</td>
							<td>${dir.categorie }</td>
							<td>${dir.nature }</td>
							<td>${dir.directionsup.nomDirection }</td>

							<td><a class="btn btn-danger"
								href="javascript:confirmation('${dir.idDirection }')">Supp</a></td>
							<td><a class="btn btn-warning"
								href="editDir?idDir=${dir.idDirection }">Edit</a></td>

						</tr>
					</c:forEach>
				</table>

			</div>
			
		</c:if>
		<c:if test="${not empty directionForm.exception }">
			<div>${directionForm.exception }</div>

		</c:if>


	</div>

	</div>
	<%@ include file="include2.jsp"%>
	
	
	
	
</body>
</html>