// 필터 정의하기
// <tr ng-repeat="todo in todoList | range:1:5">
angular.module("todoApp").filter("range", function() {
	return function(data, page, size) {
		var start_index = (page-1) * size;
		var end_index = page * size;
		
		return data.slice(start_index, end_index);
	}
});

/*
todoApp.filter("navi", function() {
	return function(data, size) {
		var result = [];
		
		for (var i=0; i<Math.ceil(data.length/size); i++) {
			result.push(i);
		}
		
		return result;
	}
});
*/