<%@ include file="/WEB-INF/include/head.jsp"%>

<c:out value="${msg}" />

<div class="form-signin">
	<div class="col-lg-12 text-center">
		<h2 class="section-heading text-uppercase">Inscription</h2>

		<form:form method="post" action="inscription"
			modelAttribute="inscription-form">

			<form:input class="form-control" path="prenom" placeholder="Prenom" />
			<br>
			<form:input class="form-control" path="nom" placeholder="Nom" />
			<br>
			<form:input class="form-control" path="nomUtilisateur"
				placeholder="nomUtilisateur" />
			<br>
			<form:input class="form-control" path="email" placeholder="Email" />
			<br>
			<form:input class="form-control" path="motDePasse" type="password"
				placeholder="Mot de passe" />
			<br>
			<form:input class="form-control" path="confirmationMotDePasse"
				type="password" placeholder="Confirmation mot de passe " />
			<br>
			<input class="btn btn-lg btn-primary" type="submit"
				value="S'inscrire" />
			<br>
			<br>
		</form:form>
		<div class="error-log">
			<spring:hasBindErrors name="inscription-form">
				<c:forEach var="err" items="${errors.allErrors}">
					<c:out value="${err.field}" /> :
			<c:out value="${err.defaultMessage}" />
					<br />
				</c:forEach>
			</spring:hasBindErrors>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp"%>