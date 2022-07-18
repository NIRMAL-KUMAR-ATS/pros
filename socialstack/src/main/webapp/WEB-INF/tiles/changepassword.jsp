<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="/css/profile.css">
<c:url var="img" value="/img" />
<div class="container">
    <div class="main-body">
        <div class="row">   
            <div class="col-lg-8">
                <div class="card">
                    <div class="card-body">
                        <%--@elvariable id="editProfile" type="com.ducthangchin.model.Profile"--%>
                        <form:form modelAttribute="editProfile">
                             <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Change Password</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <form:input type="text" class="form-control" value="${profile.changePassword}" path="changePassword"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-9 text-secondary">
                                    <input type="submit" class="btn btn-primary px-4" value="Save Changes">
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>