<%@include file="../header.jsp" %>
<%@include file="../nav.jsp" %>

<!-- Page Content -->
<div class="container">

    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
        <h1 class="display-3">CsTech User Home</h1>
        <p class="lead">Find your A+ Tutor</p>
        <a href="#" class="btn btn-primary btn-lg">Call to action!</a>
    </header>

    <!-- Page Features -->
    <section class="d-flex flex-row  justify-content-center">
        <c:forEach var="position" items="${positionList}">
        <div class="col-lg-3 col-md-6 mb-4">
        <div class="card">
        <img class="card-img-top" src="http://placehold.it/500x325" alt="">
        <div class="card-body">
        <h4 class="card-title">${position.title}</h4>
        <p class="card-text">${position.description}</p>
        <p class="card-text">${position.postedBy}</p>
        </div>
        <div class="card-footer">
        <%--<a href="#" class="btn btn-primary">Find Out More!</a>--%>
            <form method="post" action="/job/apply/${position.id}">
            <button type="submit" class="btn btn-link btn-primary">Apply
            </button>
                    </form>
        </div>
        </div>
        </div>
        </c:forEach>
    </section>


    <%--</div>--%>
    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<%@include file="../footer.jsp" %>