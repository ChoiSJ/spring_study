// 디렉티브 정의하기
angular.module("customDirective", []).directive("navi", function() {
	return {
		scope: {
			rows: "@records",
			size: "@size",
			page: "=page"
		},
		restrict: "EA", // <navi/> <div navi></div>  
		template: "<ul class='pagination'><li ng-class='getActiveClass(page+1)' ng-click='changePage(page+1)' ng-repeat='page in pages'><a>{{page+1}}</a></li></ul>",
		controller: function($scope, $element, $attrs) {
			$scope.changePage = function(pageNo) {
				$scope.page = pageNo;
			}
			
			$scope.getActiveClass = function(pageNo) {
				return $scope.page == pageNo ? "active" : "";
			}
		},
		link: function(scope, element, attrs) {
			var watchFn = function(watchScope) {
				return watchScope.rows + watchScope.size;
			}
			
			/*
				scope.$watch(감시하는 값을 반환하는 함수, 값이 변할 때마다 실행할 함수)
			 */
			// 값에 변화가 있을 때 $watch 가 실행된다.
			scope.$watch(watchFn, function(newValue, oldValue) {
				var result = [];
				console.log(newValue);
				
				for (var i=0; i<Math.ceil(scope.rows/scope.size); i++) {
					result.push(i);
					
					scope.pages = result;
				}
			});
		}
	}
});