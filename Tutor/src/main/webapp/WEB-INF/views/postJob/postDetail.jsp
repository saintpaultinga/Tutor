<%--
  Created by IntelliJ IDEA.
  User: Zamuna
  Date: 8/12/2017
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>
<%@include file="../nav.jsp"%>
<div class="row justify-content-center">
    <div class="card col-md-8">
        <div class="card-body">
            <h4 class="card-title">${position.title}</h4>
            <p class="card-text float-right">Posted Date: ${position.deadline}</p>
            <h6 class="card-subtitle mb-2 text-muted">${position.description}</h6>
            <p class="card-text">Estimated Wage: $ ${position.estimatedwage}</p>
            <p class="card-text">Duration: ${position.duration} months</p>
            <p class="card-text">Category: ${position.category}</p>


            <address>
                <h6 class="card-subtitle mb-2 text-muted">Location:</h6>
                <p class="card-text">${position.jobLocation}</p>
                <%--<p class="card-text"> ${position.locationId.street}, ${position.locationId.city}, ${position.locationId.state}</p>--%>
            </address>

            <a href="../updatePosition/${position.id}" class="btn btn-info btn-sm float-right">Update</a>
            <form action="../deletePosition/${position.id}" method="get">
                <button class="btn btn-danger btn-sm float-right" value="Delete" type="submit">
                    Delete</button>
            </form>

        </div>
    </div>
</div>
<h6>Available Tutors</h6>
<%--Available tutor section starts--%>
    <section class="d-flex flex-row  justify-content-center">
    <div class="col-sm-6 col-md-4 col-lg-3 mt-4">
        <div class="card">
            <img class="card-img-top" src="https://www.lacartedescolocs.fr/assets/fallbacks/profile_woman_medium_fallback-a7f0361efd57b6d193bef198dacdaaf2a0ac1aa17f23cd9613540c05f2c6bac6.png">
            <div class="card-block">

                <h4 class="card-title mt-3">${seeker}</h4>
                <div class="meta">
                    <h5>India, 22 ans</h5>

                </div>

            </div>
            <div class="card-footer">

                <div class="icon pull-right">
                    <a href="#"><i class="fa fa-envelope fa-fw fa-2x" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-ban fa-2x" aria-hidden="true"></i></a>

                </div>
            </div>
        </div>
    </div>
    <%--end of section of available tutorszs--%>

<%@include file="../footer.jsp"%>