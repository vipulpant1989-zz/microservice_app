/**
*
**/
'use strict';
(function(angular){
	angular.module('app').controller('HomeCtrl',
		[
			'$scope',
			'$state',
			'$http',
			function($scope, $state, $http){
				$scope.onLoad = false;
				$http.get('/json/releases.json').success(function(response){
					$scope.releases = response;
				});
				

				$http.get('/json/bands.json').success(function(response){
					$scope.bands = response;
				});

				$scope.$on('$viewContentLoaded', function(){
					
    				//Here your view content is fully loaded !!
    				if(!$scope.onLoad){
	    				
	    				$scope.onLoad = true;
    				}
  				});
			}
		]
)})(angular);