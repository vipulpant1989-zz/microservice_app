/**
*
**/
'use strict';
(function(angular){
	angular.module('app').controller('ReleaseCtrl',
		[
			'$scope',
			'$stateParams',
			'$http',
			'$state',
			function($scope, $stateParams, $http, $state){
				$http.get('/json/releases.json').success(function(response){
					console.log('release -',$scope.release);
					for(var i = 0;i<response.length;i++){
						if(response[i].userName === $stateParams.userName){
							$scope.release = response[i];
						}
					}
					
					if($scope.release === undefined){
						$state.go('app.notfound');
					}
				});
				$scope.initRevolution = function(){
					window.revolotionInit();
				}
				setTimeout(function(){
					$scope.initRevolution();
				},100);
			}
		]
)})(angular);