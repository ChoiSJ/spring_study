var other = angular.module("otherModule", []);

// 디렉티브 정의하기
other.directive("itemList", function() {
	/*
	 * <div item-list="x" items="y">
	 * scope	: 이 디렉티브가 사용된 곳의 $scope 를 가리킨다.
	 * element	: 이 디렉티브가 사용된 태그를 가리킨다. jQuery 객체다.
	 * 			$("div") 를 사용해서 선택했을 때와 똑같은 상태의 객체다.
	 * attrs	: 이 디렉티브가 사용된 태그의 attribute 정보를 담고 있다.
	 * 			attrs = {"item-list": "x", "items", "y"}
	 */
	return function(scope, element, attrs) {
		//element.append("<span>Hello, ハロー, 안녕<span>");
		
		var itemVal = attrs["item"];
		var nameVal = attrs["name"];
		var data = scope[itemVal];
		
		if (angular.isArray(data)) {
			var html = "<ul class='list-group'>";
			
			data.forEach(function(item, index) {
				var value = item[nameVal];
				html += "<li class='list-group-item'>"+value+"</li>";
			})
			
			html += "</ul>";
			
			element.append(html);
		}
	}
});