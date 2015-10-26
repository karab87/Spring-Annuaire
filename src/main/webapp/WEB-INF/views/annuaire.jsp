<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!doctype html>
<html lang="fr">

<head>

<%@ include file="include.jsp"%>


</head>
<body>
	<div class="errors">${exception}</div>
	
	<div class="generic-container ">
	<div class="container">



		<%@ include file="navigation.jsp"%>

		<div class="row">
			<div
				class="col-lg-offset-1 col-sm-offset-1 col-lg-8 col-sm-7 col-lg-push-2 col-sm-push-3">
				<div class="thumbnail">
					<div class="caption">


						<div id="formrech">
							<f:form modelAttribute="rechercherForm" action="rechEmp"
								method="post" class="form-horizontal">

								<div class="form-group">
									<label class="col-sm-2 control-label">Nom</label>
									<div class="col-sm-3">
										<f:input path="codeEmploye" />
										
									</div>
									<div>
										<f:errors path="codeEmploye" cssClass="errors"></f:errors>
									</div>

								</div>

								<div  class="form-group avance">
									<label class="col-sm-2 control-label">Direction</label>
									<div class="col-sm-2 avance">
										<f:select class="form-control" path="codeDirection"
											items="${direction}" itemValue="idDirection"
											itemLabel="nomDirection"></f:select>
									</div>
									<td><f:errors path="codeDirection" cssClass="errors"></f:errors></td>
								</div>
								<div  class="form-group avance">
									<label class="col-sm-2 control-label">Service</label>
									<div class="col-sm-2 ">
										<f:select class="form-control" path="codeService"
											items="${service}" itemValue="idService"
											itemLabel="nomService"></f:select>
									</div>
									<td><f:errors path="codeService" cssClass="errors"></f:errors></td>
								</div>
								<div  class="form-group avance">
									<label class="col-sm-2 control-label">Fonction</label>
									<div class="col-sm-2 ">
										<f:select class="form-control" path="codeFonction"
											items="${fonction}" itemValue="idFonction"
											itemLabel="nomFonction"></f:select>
									</div>
									<td><f:errors path="codeFonction" cssClass="errors"></f:errors></td>
								</div>




								<div class="form-group">
									<div class=" col-sm-offset-2 col-sm-10">
										<div>
											<input class="btn btn-info" type="submit" value="Rechercher" />
											
										</div>
									</div>
								</div>

							</f:form>
						</div>



					</div>
				</div>


			</div>
		</div>


		<c:if test="${empty rechercherForm.exception }">
			<div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Les Employes</span></div>
				<table id="" class="table table-striped table-bordered ">
					<tr>
						<th style="display: none">ID</th>
						<th>civilite</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Phone</th>
						<th>Mobile</th>
						<th>Mobile2</th>

						<th>Email</th>

					</tr>
					<c:forEach items="${employes}" var="emp">
						<tr>
							<td style="display: none">${emp.idEmploye }</td>
							<td>${emp.civilite }</td>
							<td>${emp.nom }</td>
							<td>${emp.prenom }</td>
							<td>${emp.telephone }</td>
							<td>${emp.mobile }</td>
							<td>${emp.mobile2 }</td>

							<td>${emp.mail }</td>




							<td><img src="photoEmp?idEmp=${emp.idEmploye }"></td>
							<td style="display: none"><a
								href="suppEmp?idEmp=${emp.idEmploye }">Supp</a></td>
							<td style="display: none"><a
								href="editEmp?idEmp=${emp.idEmploye }">Edit</a></td>




						</tr>
					</c:forEach>
				</table>
				


			</div>
		</c:if>
		<c:if test="${not empty rechercherForm.exception }">
			<div>${rechercherForm.exception }</div>

		</c:if>
	</div>
	<%@ include file="include2.jsp"%>
	</div>

</body>