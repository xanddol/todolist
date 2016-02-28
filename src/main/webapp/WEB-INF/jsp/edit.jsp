<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />"  />
    <style>
        body {
            padding-top: 60px;
        }
        table { table-layout: fixed; }
        table th, table td { overflow: hidden; }
    </style>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="brand">TODO Application</a>
                </div>
            </div>
        </div>
    </div>
    </div>
</div>

<div class="container">
    <form:form class="form-inline" id="todo" action="/todo/edit" method="post" modelAttribute="todoBean">
        <form:input path="description" value="${toDo.description}"/>
        <form:input path="status" value="${toDo.status}"/>
        <form:input path="priority" value="${toDo.priority}"/>
        <form:hidden path="id" value="${toDo.id}"/>
        <button type="submit">Edit Task</button>
    </form:form>
</div>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>