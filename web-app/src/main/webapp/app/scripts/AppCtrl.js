/**
 * 
 */
'use strict';
(function(angular) {
	angular
			.module('app')
			.controller(
					'AppCtrl',
					[
							'$scope',
							'$stateParams',
							'$http',
							'$state',
							'$anchorScroll',
							'$location',
							'$rootScope',
							function($scope, $stateParams, $http, $state,
									$anchorScroll, $location, $rootScope) {

								$scope.progress = 0;
								$scope.formData = {};
								$scope.showSuccess = false;
								$scope.error = false;

								$scope.gotoAnchor = function(x) {
									var newHash = x;
									if ($location.hash() !== newHash) {
										// set the $location.hash to `newHash`
										// and
										// $anchorScroll will automatically
										// scroll to it
										$location.hash(x);
									} else {
										// call $anchorScroll() explicitly,
										// since $location.hash hasn't changed
										$anchorScroll();
									}
								};

								$scope.contact = function(event) {
									event.preventDefault();
									$scope.showSuccess = false;
									$scope.error = false;
									if (validateFormData()) {
										$http
												.post(
														'plugins/contact-form.php',
														$scope.formData)
												.then(
														function(response) {
															$scope.message = "Your request has successfully reached us,Thank You.";
															$scope.showSuccess = true;
														});
									}
								}

								var validateFormData = function() {
									if (!$scope.formData.name
											|| $scope.formData.name === '') {
										$scope.error = true;
										$scope.errMsg = 'Name is Required.';
										return false;
									}
									if (!$scope.formData.subject
											|| $scope.formData.subject === '') {
										$scope.error = true;
										$scope.errMsg = 'Subject is Required.';
										return false;
									}
									if (!$scope.formData.email
											|| $scope.formData.email === '') {
										$scope.error = true;
										$scope.errMsg = 'Email is Required.';
										return false;
									}
									if (!$scope.formData.message
											|| $scope.formData.message === '') {
										$scope.error = true;
										$scope.errMsg = 'Message is Required.';
										return false;
									}
									return true;
								}
								$http.get('/json/audios.json').success(function(response) {
									var playlist = [];
									for ( var key in response) {
										var audios = response[key].audio;
										var name = response[key].name;
										for ( var key in audios) {
											var audio = audios[key];
											audio.artistName = name;
											playlist.push(audio);
										}
									}
									$scope.tracklist = playlist;
								});
								$scope.goToArtist = function(name) {
									if (name)
										$state.go('app.artist', {
											'name' : name.toString()
										}, {
											absolute : true
										});
								}
								$scope.goToRelease = function(username) {
									if (username)
										$state.go('app.release', {
											'userName' : username.toString()
										}, {
											absolute : true
										});
								}
							} ]).controller('TeamCtrl',[
							'$scope',
							'$http',
							function($scope, $http) {
								$http.get('/json/team.json').success(
										function(response) {
											$scope.teams = response;
										});

							} ])
})(angular);