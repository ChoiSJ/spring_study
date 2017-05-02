<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" ng-app="todoApp">
<head>
<meta charset="UTF-8">
<title>Todo Application</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="resources/directive/myDirective.js"></script>
<script type="text/javascript">
	var todoApp = angular.module("todoApp", ["customDirective"]);
</script>
<script src="resources/service/todoService.js"></script>
<script src="resources/filter/todoFilter.js"></script>
<script src="resources/controller/todoController.js"></script>
</head>
<body>
<div class="container" ng-controller="todoCtrl">
	<h1>Todo Application</h1>
	
	<div class="row">
		<label>출력 개수</label>
		<select ng-model="pageSize" ng-options="row for row in rows"></select>
	</div>
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<td>id</td>
				<td>title</td>
				<td>date</td>
				<td>completed</td>
				<td></td>
			</tr>	
		</thead>
		<tbody>
			<tr ng-repeat="todo in todoList | range:currentPage:pageSize">
				<td>{{todo.id}}</td>
				<td>{{todo.title}}</td>
				<td>{{todo.eventDate}}</td>
				<td>{{todo.completed}}</td>
				<td></td>
			</tr>
		</tbody>
	</table>
	
	<!-- 페이지 내비게이션 -->
	<div navi records="{{todoList.length}}" size="{{pageSize}}" page="currentPage">
	
	</div>
	
	<!-- 
	<div class="row text-right">
		<div class="btn-group">
			<a ng-repeat="page in todoList | navi:pageSize" ng-click="setCurrentPage(page+1)" ng-class="getActiveClass(page+1)"
				class="btn btn-default">{{page+1}}</a>
		</div>
	</div>
	 -->
</div>
</body>
</html>