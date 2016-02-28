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
        <div class="container">
            <a class="brand">TODO Application</a>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <form:form class="form-inline" id="todo" action="/todo" method="post" modelAttribute="todoBean">
        <form:input path="description" class="span2" placeholder="What I want to do..."/>
        <form:input path="status" class="span2" placeholder="Status..."/>
        <form:input path="priority" class="span2" placeholder="Priority..."/>
        <button type="submit" class="btn btn-primary">Add Task</button>
    </form:form>

    <div class="tabbable tabs-left">
        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#tab1">All Tasks</a></li>
            <li><a data-toggle="tab" href="#tab2">Done</a></li>
            <li><a data-toggle="tab" href="#tab3">In Progress</a></li>
            <li><a data-toggle="tab" href="#tab4">Not Done</a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="tab1">
                <table class="table table-stripe table-condensed table-hover" id="todotable">
                    <c:forEach items="${toDoList.toDos}" var="toDo" varStatus="status">
                        <tr id="${toDo.id}">
                            <td id="toDo-${toDo.id}-desc" style="width: 55%">${toDo.description}</td>
                            <td id="todo-${toDo.id}-status" style="width: 20%">${toDo.status}</td>
                            <td id="todo-${toDo.id}-priority" style="width: 5%">${toDo.priority}</td>
                            <td><a href="/todolist-spring-mvc/todo/done/${toDo.id}" class="btn btn-mini"><i class="icon-ok"></i></a></td>
                            <td><a href="/todolist-spring-mvc/todo/inprogress/${toDo.id}" class="btn btn-mini"><i class="icon-move"></i></a></td>
                            <td><a href="/todolist-spring-mvc/todo/delete/${toDo.id}" class="btn btn-mini"><i class="icon-trash"></i></a></td>
                            <td><a href="/todolist-spring-mvc/todo/edit/${toDo.id}" class="btn btn-mini"><i class="icon-edit"></i></a></td>
                            <td>${toDo.id}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="tab-pane" id="tab2">
                <table class="table table-stripe table-condensed table-hover">
                    <c:forEach items="${toDoList.toDos}" var="toDo" varStatus="status">
                        <c:if test="${toDo.status == 'done'}">
                            <tr id="toDo-${toDo.id}">
                                <td id="toDo-${toDo.id}-desc" style="width: 55%">${toDo.description}</td>
                                <td id="todo-${toDo.id}-status" style="width: 20%">${toDo.status}</td>
                                <td id="todo-${toDo.id}-priority" style="width: 5%">${toDo.priority}</td>
                                <td><a href="/todolist-spring-mvc/todo/delete/${toDo.id}" class="btn btn-mini"><i class="icon-trash"></i></a></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
            <div class="tab-pane" id="tab3">
                <table class="table table-stripe table-condensed table-hover">
                    <c:forEach items="${toDoList.toDos}" var="toDo" varStatus="status">
                        <c:if test="${toDo.status == 'in progress'}">
                            <tr id="toDo-${toDo.id}">
                                <td id="toDo-${toDo.id}-desc" style="width: 55%">${toDo.description}</td>
                                <td id="todo-${toDo.id}-status" style="width: 20%">${toDo.status}</td>
                                <td id="todo-${toDo.id}-priority" style="width: 5%">${toDo.priority}</td>
                                <td><a href="/todolist-spring-mvc/todo/done/${toDo.id}" class="btn btn-mini"><i class="icon-ok"></i></a></td>
                                <td><a href="/todolist-spring-mvc/todo/delete/${toDo.id}" class="btn btn-mini"><i class="icon-trash"></i></a></td>
                                <td><a href="/todolist-spring-mvc/todo/edit/${toDo.id}" class="btn btn-mini"><i class="icon-edit"></i></a></td>
                                <td>${toDo.id}</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
            <div class="tab-pane" id="tab4">
                <table class="table table-stripe table-condensed table-hover">
                    <c:forEach items="${toDoList.toDos}" var="toDo" varStatus="status">
                        <c:if test="${toDo.status != 'done'}">
                            <tr id="toDo-${toDo.id}">
                                <td id="toDo-${toDo.id}-desc" style="width: 55%">${toDo.description}</td>
                                <td id="todo-${toDo.id}-status" style="width: 20%">${toDo.status}</td>
                                <td id="todo-${toDo.id}-priority" style="width: 5%">${toDo.priority}</td>
                                <td><a href="/todolist-spring-mvc/todo/done/${toDo.id}" class="btn btn-mini"><i class="icon-ok"></i></a></td>
                                <td><a href="/todolist-spring-mvc/todo/inprogress/${toDo.id}" class="btn btn-mini"><i class="icon-move"></i></a></td>
                                <td><a href="/todolist-spring-mvc/todo/delete/${toDo.id}" class="btn btn-mini"><i class="icon-trash"></i></a></td>
                                <td><a href="/todolist-spring-mvc/todo/edit/${toDo.id}" class="btn btn-mini"><i class="icon-edit"></i></a></td>
                                <td>${toDo.id}</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>

        </div><!-- tab-content -->

    </div><!-- tabbable -->
</div><!-- container -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="/todolist-spring-mvc/resources/js/bootstrap.min.js"></script>
<script src="/todolist-spring-mvc/resources/js/jquery.tablednd.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $("#todotable").tableDnD({
            onDrop: function(table, row){
                var rows = table.tBodies[0].rows;
                var itemOrder = new Array();
                for (var i=0; i< rows.length; i++) {
                    itemOrder.push(rows[i].id);
                }
                var requestEntry = {"updateEntries" : itemOrder};
                var json = JSON.stringify(requestEntry);
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    dataType: "json",
                    url: "/todo/updateOrder",
                    data : json,
                    success: function(result) {
                        //do nothing
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        alert(jqXHR.status + ":" + jqXHR.responseText + " : " + textStatus + " : " + errorThrown);
                    }
                });
            }
        });
    });
</script>
</body>
</html>