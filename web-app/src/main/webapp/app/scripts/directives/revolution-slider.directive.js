/**
 * 
 */
(function(){
	'use strict';
	angular.module('app').directive('revolutionSlider',revolutionSlider);

	revolutionSlider.$inject = [];
	function revolutionSlider(){
		return {
			restrict: 'EA',
			scope:{
				templateUrl : '@'
			},
			link : function(scope , element , attr){
				$(element).revolution( {	
					delay: 9000,												
					startwidth: 940,
					startheight: 600,
					onHoverStop: 'on',						// Stop Banner Timet at Hover on Slide on/off
					thumbWidth: 100,						// Thumb With and Height and Amount (only if navigation Tyope set to thumb !)
					thumbHeight: 50,
					thumbAmount: 4,
					hideThumbs: 200,
					navigationType: 'both',					// Bullet, thumb, none, both	 (No Shadow in Fullwidth Version !)
					navigationArrows: 'verticalcentered',	// Nexttobullets, verticalcentered, none
					navigationStyle: 'round',				// Round,square,navbar
					touchenabled: 'on',						// Enable Swipe Function : on/off
					navOffsetHorizontal: 0,
					navOffsetVertical: 20,
					fullWidth: 'on',
					shadow: 0								//0 = no Shadow, 1,2,3 = 3 Different Art of Shadows -  (No Shadow in Fullwidth Version !)
				});	
			}
		}
	}
}(angular));