<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Zamuna
  Date: 8/11/2017
  Time: 11:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp" %>
<%@include file="../nav.jsp" %>
<%--Form start--%>
<h5 class="bg-light text-gray-dark">Add Job Post</h5>
<form:form action="/jobPost/addPosition/${pos.id}" method="post" modelAttribute="pos">
    <div class="form-row">
        <div class="form-group  col-md-6">
            <label  class="col-form-label">Title</label>
            <form:input path="title" cssClass="form-control form-control-sm"/>
        </div>
        <div class="form-group col-md-6">
            <label class="col-form-label">Description</label>
            <form:input path="description" cssClass="form-control form-control-sm"/>

        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-4">
            <label  class="col-form-label form-control-sm">Duration</label>
            <div class="input-group input-group-sm ">
                    <form:input path="duration" cssClass="form-control form-control-sm"/>
                <span class="input-group-addon form-control-sm">Months</span>
            </div>
        </div>
        <div class="form-group col-md-4">
            <label  class="col-form-label form-control-sm">Estimated Wage</label>
            <div class="input-group input-group-sm ">
                <span class="input-group-addon form-control-sm">$</span>
                <form:input path="estimatedwage" cssClass="form-control form-control-sm"/>
            </div>
        </div>
        <div class="form-group col-md-4">
            <label class="col-form-label form-control-sm">Category</label>
            <form:select path="category" cssClass="form-control form-control-sm">
    <form:options items="${categories}"/>
</form:select>
        </div>
    </div>
    <hr/>
    <h5>Job Location </h5>
    <div class="form-row">
    <div class="form-group col-md-5">
    <label  class="col-form-label">Full Address</label>
    <form:input path="jobLocation" cssClass="form-control form-control-sm" placeholder="Full Address"/>
    </div>
        <div class="form-group col-md-3">
            <label  class="col-form-label">DeadLine</label>
            <form:input path="deadline" cssClass="form-control form-control-sm" placeholder="yyyy-MM-dd"/>
        </div>
        <%--<div class="form-group col-md-4">--%>
            <%--<label  class="col-form-label">Street</label>--%>
            <%--<form:input path="locationId.street" cssClass="form-control form-control-sm"/>--%>
        <%--</div>--%>
        <%--<div class="form-group col-md-4">--%>
            <%--<label class="col-form-label">City</label>--%>
            <%--<form:input path="locationId.city" cssClass="form-control form-control-sm"/>--%>
        <%--</div>--%>
        <%--<div class="form-group col-md-4">--%>
            <%--<label class="col-form-label">State</label>--%>
            <%--<form:select path="locationId.state" cssClass="form-control form-control-sm">--%>
                <%--<form:options items="${states}"/>--%>
            <%--</form:select>--%>

        <%--</div>--%>
    </div>
    <c:if test="${pos==null}">
        <form:button  value="Post Job" class="btn btn-success"  >
            Post Job
        </form:button>

    </c:if>
    <c:if test="${pos!=null}">
        <form:button  value="Post Job" class="btn btn-success" >
            Update Job
        </form:button>
        <%--<input type="button" class="btn btn-success" value="Post Job"/>--%>
    </c:if>


</form:form>

<%--form end--%>
<%@include file="../footer.jsp" %>
