angular.module('app').directive('team', function($sce) {
  return {
    restrict: 'EA',
    scope: { 
      teams:'=' 
    },
    templateUrl:'/team.html',
    link: function (scope) {
   
      }
  };
});