
'use strict'
angular.module('app').filter('unsafe', function($sce) {
    return function(val) {
        return $sce.trustAsHtml(val);
    };
});