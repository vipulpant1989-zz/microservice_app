(function(angular){
	'use strict';
	angular.module('app').controller('EventCtrl',[
		'$scope',
		 '$http',
		 function($scope , $http){
		 	$http.get('/json/events.html').success(function(response){

		 		$scope.eventList = response;
		 	});
		}
	]);

}());