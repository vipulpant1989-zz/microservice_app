/**
*
**/
'use strict';
(function(angular){
	angular.module('app').controller('ArtistsCtrl',
		[
			'$scope',
			'$stateParams',
			'$http',
			'$state',
			function($scope, $stateParams, $http, $state){
				$http.get('/json/bands.json').success(function(response){
					$scope.bands = response;
				});
				
			}
	]).controller('ArtistCtrl',
		[
			'$scope',
			'$stateParams',
			'$http',
			'$state',
			function($scope, $stateParams, $http, $state){
				$scope.onLoad = false;
				$scope.$on('$viewContentLoaded', function(){
    				//Here your view content is fully loaded !!
    				if(!$scope.onLoad){
	    				setTimeout(function(){
	    					//window.init_player('#mytracklist');
	    				},2000);
	    				$scope.onLoad = true;
    				}
  				});
				
				$http.get('/json/bands.json').success(function(response){
					console.log('response ', response);
					for(var i = 0;i<response.length;i++){
						if(response[i].name === $stateParams.name){
							$scope.band = response[i];

							if(!$scope.band.soundcloud){
								$http.get('/json/audios.json').success(function(audios){
									for(var i = 0;i<audios.length;i++){
										if($scope.band.id === audios[i].bandId)
											$scope.audios = audios[i];
									}
								});
							}
						}
					}

					if($scope.band === undefined){
						$state.go('app.notfound');
					}
					$scope.formData.subject = "Booking enquiry for "+$scope.band.name;
				});
			}
		]
)})(angular);