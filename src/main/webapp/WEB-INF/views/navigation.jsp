<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<nav class="navbar navbar-default ">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Annuaire MUHA</a>
		</div>
		
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav ">
				<li class=""><a href="/annuaire/recherche/index">Annuaire<span class="sr-only">(current)</span></a></li>
				<security:authorize access="hasRole('ROLE_ADMIN')">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Administration <span class="caret"></span></a>
					<ul class="dropdown-menu">
						
						<li><a href="/annuaire/admin/employes">Employes</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="/annuaire/admin/directions">Directions</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="/annuaire/admin/fonctions">Fonctions</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="/annuaire/admin/services">Services</a></li>

					</ul></li>
					 </security:authorize>
			</ul>
			<ul class="nav navbar-nav navbar-right">
			 <security:authorize access="! isAuthenticated()">
				<li class=""><a href="/annuaire/login">Connexion </a></li>
				</security:authorize>
              <security:authorize access="isAuthenticated()">
				<li class=""><a href="<c:url value="/j_spring_security_logout" />">Déconnexion <span
						class="sr-only">(current)</span></a></li>
						</security:authorize>

			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	<!--/.container-fluid -->
</nav>
