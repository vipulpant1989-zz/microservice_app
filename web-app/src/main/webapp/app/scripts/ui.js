
/**
 * 
 *
 *
 */
'use strict';
(function(angular){
    angular.module('app').config([
        '$stateProvider',
        '$urlRouterProvider',
        '$sceDelegateProvider',
        function ($stateProvider, $urlRouterProvider , $sceDelegateProvider) {
            // For any unmatched url, redirect to /state1
            $urlRouterProvider.otherwise("/app/home");
            // Now set up the states
            $stateProvider.state('app', {
                url: '/app',
                templateUrl:'/views/app.html',
                abstract:true,
                controller:'AppCtrl'
            }).state('app.home', {
                url: '/home',
                controller:'HomeCtrl',
                templateUrl:'/views/home.html',
            }).state('app.releases',{
                url: '/releases',
                controller:'HomeCtrl',
                templateUrl:'/views/releases.html',
            }).state('app.release',{
                url:'/release/:userName',
                templateUrl:'/views/release.html',
                controller:'ReleaseCtrl'
            }).state('app.notfound',{
                url:'/404',
                templateUrl:'/404.html',
            }).state('app.artists',{
                url:'/artists',
                templateUrl:'/views/artists.html',
                controller:'ArtistsCtrl'
            }).state('app.artist',{
                url:'/artist/:name',
                templateUrl:'/views/artist.html',
                controller:'ArtistCtrl'
            }).state('app.contact',{
                url:'/contact',
                templateUrl:'/views/contact.html',
                controller:function($scope){
                   $scope.formData.subject = '';
                }
            }).state('app.blog',{
                url:'/blog',
                templateUrl:'/views/blog.html',
                controller:'BlogCtrl'
            }).state('app.team',{
                url:'/views/team',
                template:'<team teams="teams"></team>',
                controller:'TeamCtrl'
            }).state('app.events',{
                url:'/views/events',
                templateUrl : '/events.html',
                controller: 'EventCtrl'
            });   

        }
    ]);
})(angular);