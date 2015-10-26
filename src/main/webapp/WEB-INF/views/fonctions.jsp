<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!doctype html>
<html lang="fr">



<head>

<%@ include file="include.jsp"%>

<script type="text/javascript">
	function confirmation(id) {
		var conf = confirm("Etes vous sur de vouloir supprimer?");
		if (conf == true)
			document.location = "suppFonc?idFonc=" + id;

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

						<div id="formFonc" >
							<f:form modelAttribute="fonction" action="saveFonc"
								method="post" class="form-horizontal registrationFoncForm">
								
								<c:if test="${edit eq true}">
									<div class="alert alert-success">Fonction Modifier avec success!</div>
								</c:if>
								<c:if test="${save eq true}">
									<div class="alert alert-success">Fonction enregistrer avec success!</div>
								</c:if>
								<c:if test="${suppr eq true}">
									<div class="alert alert-warning">Fonction Supprimer avec success!</div>
								</c:if>
								
								
									<div style="display: none" class="form-group">
										<label class="label-control">ID Fonction</label>
										<div class="form-control"><f:input path="idFonction" /></div>
										<td><f:errors path="idFonction"
												cssClass="errors"></f:errors></td>

									</div>
									<div class="form-group">
										<label class="label-control col-sm-2">Nom</label>
										<div class="col-sm-3 "><f:input class="form-control" path="nomFonction" placeholder="Acronyme"/></div>
										<td><f:errors path="nomFonction"
												cssClass="errors"></f:errors></td>

									</div>
									<div class="form-group">
										<label class="label-control col-sm-2">Description</label>
										<div class="col-sm-5"><f:input path="description" class="form-control" placeholder="Nom entier" /></div>
										<td><f:errors path="description"
												cssClass="errors"></f:errors></td>

									</div>
									<div class="form-group">
										<label class="label-control col-sm-2">Titre</label>
										<div class="col-sm-3"><f:input path="level" class="form-control" placeholder="Nom entier" /></div>
										<td><f:errors path="level" cssClass="errors"></f:errors></td>

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



			<div class="col-lg-3 col-sm-4 col-lg-pull-9 col-sm-pull-8">
				<div class="thumbnail">
					<div class="caption">
						<div id="formrech" >
							<f:form modelAttribute="fonctionForm" action="rechFonc"
								method="post" class="form-horizontal">
								
									<div class="form-group">
										<label class="control-label">Nom</label>
										<td><f:input path="codeFonction"  /></td>
										<td><f:errors path="codeFonction" cssClass="errors"></f:errors></td>

									</div>

									<div class="form-group">
									<div class=" col-sm-offset-2 col-sm-10">
										<button class="btn btn-info"  type="submit" value="Rechercher" >Rechercher</button>
									</div>
									</div>

								
							</f:form>
						</div>

					</div>
				</div>
			</div>





		</div>

		<c:if test="${empty fonctionForm.exception }">
			<div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Les Fonctions</span></div>
				<table id="" class="table table-striped table-bordered ">
					<tr>
						<th style="display: none">ID</th>
						<th>Fonction</th>
						<th>Description</th>
						<th>level</th>
					</tr>
					<c:forEach items="${fonctions}" var="fonc">
						<tr>
							<td style="display: none">${fonc.idFonction }</td>
							<td>${fonc.nomFonction }</td>
							<td>${fonc.description }</td>
							<td>${fonc.level }</td>
							<td><a class="btn btn-danger" href="javascript:confirmation('${fonc.idFonction }')">Supp</a></td>

							<td><a class="btn btn-warning" href="editFonc?idFonc=${fonc.idFonction }">Edit</a></td>

						</tr>
					</c:forEach>
				</table>
				</div>
				
			
		</c:if>
		<c:if test="${not empty fonctionForm.exception }">
			<div class="alert alert-warning">${fonctionForm.exception }</div>

		</c:if>

	</div>
	</div>
	<%@ include file="include2.jsp"%>

</body>
</html>

