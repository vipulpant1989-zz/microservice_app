/**
*
**/
'use strict';
(function(angular){
	angular.module('app').controller('BlogCtrl',
		[
			'$scope',
			'$stateParams',
			'$http',
			'$state',
			function($scope, $stateParams, $http, $state){

				$http.get('/json/blogs.json').success(function(response){
					console.log('response ', response);
					$scope.blogs = response;
				});
				
			}
		]
)})(angular);