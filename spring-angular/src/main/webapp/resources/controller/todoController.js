//todo 를 제어와 관련된 속성, 기능을 정의해놓은 컨트롤러
// 화면 및 사용자와 상호작용한다.
// 컨트롤러는 사용될 때마다 매번 새로 만들어진다.
angular.module("todoApp").controller("todoCtrl", function($scope, TodoService) {
	// 화면에 표시할 todo 목록
	$scope.todoList = [];
	$scope.rows = [5, 10, 20];
	
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	$scope.$watch(function(watchScope) {
		return $scope.pageSize;
	}, function(newValue, oldValue) {
		$scope.currentPage = 1;
	});
	
	/*
	$scope.setCurrentPage = function(pageNo) {
		$scope.currentPage = pageNo;
	}
	
	$scope.getActiveClass = function(pageNo) {
		return $scope.currentPage == pageNo ? "btn-info" : "";
	}
	*/
	
	$scope.getTodoList = function() {
		TodoService.getAllTodos().then(function(data) {
			$scope.todoList = data;
		});
	};
	
	$scope.getTodoList();
});