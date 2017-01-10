'use strict';
angular.module('app').directive('soundcloud', function($sce) {
  return {
    restrict: 'EA',
    scope: { 
      code:'=' 
    },
    template: '<iframe class="iframe" ng-src={{url}} width="100%" height="465" scrolling="no" frameborder="no"></iframe>',
    link: function (scope) {
        scope.$watch('code', function (newVal) {
           if (newVal) {
               window.initSoundCloud(newVal);
               //var widget = SC.Widget(iframe);	
           }
        });
    }
  };
});