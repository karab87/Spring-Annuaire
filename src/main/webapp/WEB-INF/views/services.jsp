<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html lang="fr">
<head>

	<meta charset="utf-8">
	
	<%@ include file="include.jsp" %>
	
	<script type="text/javascript">
		function confirmation(id) {
			var conf = confirm("Etes vous sur de vouloir supprimer?");
			if (conf == true)
				document.location = "suppServ?idServ=" + id;
	
		}
	</script>

</head>
<body>
	<div class="errors">${exception }</div>
	<div class="generic-container ">
	
	

	<div class="container">

		<%@ include file="navigation.jsp" %>

		<div class="well">
            </div>

		

		<div class="row">

			<div
				class="col-lg-offset-1 col-sm-offset-1 col-lg-8 col-sm-7 col-lg-push-2 col-sm-push-3">
				<div class="thumbnail">
					<div class="caption">
						<div id="formServ" >
							<f:form class="form-horizontal registrationServForm " modelAttribute="service"
								action="saveServ" method="post">
								
								<c:if test="${save eq true}">
									<div class="alert alert-success">Service Modifier avec success!</div>
								</c:if>
								
								<c:if test="${suppr eq true}">
									<div class="alert alert-warning">Service Supprimer avec success!</div>
								</c:if>
								
								<div class="form-group">



									<div style="display: none">
										<label> ID</label>
										<div>
											<f:input path="idService" />
										</div>
										<div>
											<f:errors path="idService" cssClass="errors"></f:errors>
										</div>

									</div>

									<div class="form-group">


										<label class="col-sm-2 control-label">Code</label>
										<div class="col-sm-3">
											<f:input placeholder="Acronyme de la fonction"
												class="form-control" path="nomService" />
										</div>
										<div>
											<f:errors path="nomService" cssClass="errors"></f:errors>
										</div>

									</div>
									<br />

									<div class="form-group">
										<label class="col-sm-2 control-label">Nom</label>
										<div class="col-sm-7">
											<f:input placeholder="Nom entier du service"
												class="form-control" path="description" />
										</div>
										<div>
											<f:errors path="description" cssClass="errors"></f:errors>
										</div>

									</div>
									
									<div class="form-group">
										<label class="col-sm-2 control-label">Direction</label >
										<div class="col-md-7"><f:select class="form-control" path="directions"
												items="${directions}" size="10"  multiple="true" itemValue="idDirection"
												itemLabel="nomDirection"></f:select></div>
										<div><f:errors path="directions"
												cssClass="errors help-inline"></f:errors></div>
									</div>



									<%-- Direction parent <tr id="dir" >
					<td id="nom">Direction </td>
					
					
					<td ><f:select path="direct.idDirection" >
						<f:option value="${0}" selected="selected" label="Veillez Selectionner" />	
						<f:options items="${directions}" itemValue="idDirection" itemLabel="nomDirection" />
						
					</f:select>
						</td>
					<td><f:errors path="direct.idDirection" cssClass="errors"></f:errors></td>
					
				</tr>
				<td><input id="double" type="button" value="Une autre Direction"/></td> --%>



									<div class="col-sm-offset-2 col-sm-10">
										<div>
											<input class="btn btn-success" type="submit"
												value="Enregistrer" />
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

						<div id="formrech" >
							<f:form class="form-horizontal" modelAttribute="serviceForm"
								action="rechServ" method="post">

								<div class="form-group">
									<label>Nom</label>
									<td><f:input path="codeService" /></td>
									<td><f:errors path="codeService" cssClass="errors"></f:errors></td>

								</div>

								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" value="Rechercher" class="btn btn-info">Rechercher</button>
									</div>
								</div>


							</f:form>
						</div>
					</div>
				</div>
			</div>








		</div>
		<div>
			<div>
				<c:if test="${empty serviceForm.exception }">
					<div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Les services</span></div>
						<table id="" class="table table-striped table-bordered ">
							<tr>
								<th style="display: none">ID</th>
								<th>Nom</th>
								<th>Description</th>
							</tr>
							<c:forEach items="${services}" var="serv">
								<tr>
									<td style="display: none">${serv.idService }</td>
									<td>${serv.nomService }</td>
									<td>${serv.description }</td>

									<td><a class="btn btn-danger"
										href="javascript:confirmation('${serv.idService }')">Supp</a></td>
									<td><a class="btn btn-warning"
										href="editServ?idServ=${serv.idService }">Edit</a></td>

								</tr>
							</c:forEach>
						</table>
					</div>

				</c:if>
				<c:if test="${not empty serviceForm.exception }">
					<div>${serviceForm.exception }</div>

				</c:if>


				


			</div>
		</div>

	</div>
	</div>
	

	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script type="text/javascript"
			src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/resources/js/myApp.js"></script>
</div>
				

</body>

</html>



