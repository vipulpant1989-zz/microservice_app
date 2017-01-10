angular.module('app').directive('youtube', function($sce) {
  return {
    restrict: 'EA',
    scope: { 
      src:'=' 
    },
    replace: true,
    template: '<div style="height:400px;"><iframe style="overflow:hidden;height:100%;width:100%" width="100%" height="100%" src="{{url}}" frameborder="0" allowfullscreen></iframe></div>',
    link: function (scope) {
        scope.$watch('src', function (newVal) {
           if (newVal) {
               scope.url = $sce.trustAsResourceUrl(newVal + '&output=embed');
           }
        });
    }
  };
});