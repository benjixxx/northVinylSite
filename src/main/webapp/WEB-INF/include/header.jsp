<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Start Bootstrap</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="home">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Services</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a>
					</li>
				</ul>

				<ul class="navbar-nav mt-2 mt-lg-0">
					<c:if test="${empty sessionScope.user_name }">
						<li class="nav-item"><a class="nav-link" href="connexion">Connexion</a></li>
						<li class="nav-item"><a class="nav-link" href="inscription">Inscription</a></li>
					</c:if>
					<c:if test="${!empty sessionScope.user_name }">
						<p>Vous êtes ${sessionScope.user_name}</p>
						<li class="nav-item"><a class="nav-link" href="profil">Mon
								profil</a></li>
						<li class="nav-item"><a class="nav-link" href="deconnexion">Déconnexion</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>