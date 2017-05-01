<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" ng-app="todoApp">
<head>
<meta charset="UTF-8">
<title>Todo Application</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script type="text/javascript">
	var todoApp = angular.module("todoApp", []);
	
	// 컨트롤러가 사용하는 공통기능이 정의되어 있는 서비스
	// 주로 서버와의 ajax 통신을 통한 데이터교환이 정의되어 있다.
	// 서비스는 싱글턴이다.
	todoApp.factory("TodoService", function($http) {
		return {
			// 서버에서 모든 todo 를 가져오는 기능
			getAllTodos: function() {
				return $http.get("todos/").then(function(response) {
					// 서버로부터 받은 json 데이터
					return response.data;
				});
			},
			removeTodo: function(id) {
				
			},
			getTodo: function(id) {
				
			},
			saveTodo: function(todo) {
				
			},
			updateTodo: function(todo) {
				
			}
		}
	});
	
	// todo 를 제어와 관련된 속성, 기능을 정의해놓은 컨트롤러
	// 화면 및 사용자와 상호작용한다.
	// 컨트롤러는 사용될 때마다 매번 새로 만들어진다.
	todoApp.controller("todoCtrl", function($scope, TodoService) {
		// 화면에 표시할 todo 목록
		$scope.todoList = [];
		
		$scope.currentPage = 1;
		$scope.pageSize = 5;
		
		$scope.setCurrentPage = function(pageNo) {
			$scope.currentPage = pageNo;
		}
		
		$scope.getActiveClass = function(pageNo) {
			return $scope.currentPage == pageNo ? "btn-info" : "";
		}
		
		$scope.getTodoList = function() {
			TodoService.getAllTodos().then(function(data) {
				$scope.todoList = data;
			});
		};
		
		$scope.getTodoList();
	});
	
	// <tr ng-repeat="todo in todoList | range:1:5">
	todoApp.filter("range", function() {
		return function(data, page, size) {
			var start_index = (page-1) * size;
			var end_index = page * size;
			
			return data.slice(start_index, end_index);
		}
	});
	
	todoApp.filter("navi", function() {
		return function(data, size) {
			var result = [];
			
			for (var i=0; i<Math.ceil(data.length/size); i++) {
				result.push(i);
			}
			
			return result;
		}
	});
</script>
</head>
<body>
<div class="container" ng-controller="todoCtrl">
	<h1>Todo Application</h1>
	
	<div class="row">
		<label>출력 개수</label>
		<select ng-model="pageSize">
			<option value="5"> 5개씩</option>
			<option value="10"> 10개씩</option>
			<option value="20"> 20개씩</option>
		</select>
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
	
	<div class="row text-right">
		<div class="btn-group">
			<a ng-repeat="page in todoList | navi:pageSize" ng-click="setCurrentPage(page+1)" ng-class="getActiveClass(page+1)"
				class="btn btn-default">{{page+1}}</a>
		</div>
	</div>
</div>
</body>
</html>