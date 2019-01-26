
<%@ include file="/WEB-INF/include/head.jsp"%>

<div class="form-signin">
	<div class="col-lg-12 text-center">
		<h2 class="section-heading text-uppercase">Connexion</h2>
		<form:form method="post" action="connexion"
			modelAttribute="connexion-form">

			<form:input class="form-control" path="nomUtilisateur"
				placeholder="e-mail" />
			<br>
			<form:input class="form-control" path="motDePasse" type="password"
				placeholder="Mot de passe" />
			<br>
			<input class="btn btn-lg btn-primary" type="submit" value="connexion" />
			<br>
			<br>
			<br>

		</form:form>
	</div>
	<div>${msg}</div>
	<div class="error-log">
		<spring:hasBindErrors name="connexion-form">
			<c:forEach var="err" items="${errors.allErrors}">
				<c:out value="${err.field}" /> :
			<c:out value="${err.defaultMessage}" />
				<br />
			</c:forEach>
		</spring:hasBindErrors>
	</div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp"%>