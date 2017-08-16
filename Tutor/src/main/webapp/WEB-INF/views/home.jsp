<%@include file="header.jsp"%>
<%@include file="nav.jsp"%>

	<!-- Page Content -->
	<div class="container">

		<!-- Jumbotron Header -->
		<header class="jumbotron my-4">
			<h1 class="display-3">CsTech</h1>
			<p class="lead">Find your A+ Tutor</p>
			<a href="#" class="btn btn-primary btn-lg">Call to action!!!!!</a>
		</header>

		<!-- Page Features -->
		<div class="row text-center">
			<c:forEach var="position" items="${positionList}">
				<div class="col-lg-3 col-md-6 mb-4">
					<div class="card">
						<img class="card-img-top" src="http://placehold.it/500x325" alt="">
						<div class="card-body">
							<h4 class="card-title">${position.title}</h4>
							<p class="card-text">${position.description}</p>
						</div>
						<div class="card-footer">
							<a href="#" class="btn btn-primary">Find Out More!</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<%@include file="footer.jsp"%>