// 컨트롤러가 사용하는 공통기능이 정의되어 있는 서비스
// 주로 서버와의 ajax 통신을 통한 데이터교환이 정의되어 있다.
// 서비스는 싱글턴이다.
angular.module("todoApp").factory("TodoService", function($http) {
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