'use strict';

angular.module('app').filter('DelimiterFilter', function() {
    return function(str , limit) {
    	if(!limit)
    		limit = 480;
    	if(!str)
    		return;
    	console.log(limit);
		return str.substr(0, limit) + '...';
	}
});