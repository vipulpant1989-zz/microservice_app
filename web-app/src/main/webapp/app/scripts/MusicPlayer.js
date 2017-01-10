'use strict';
angular.module('app').directive('musicPlayer',['$sce','$rootScope', function($sce,$rootScope) {
  return {
    restrict: 'EA',
    templateUrl: '/views/small_player.html',
    scope:{
        audios : '=',
        total  : '=',
        elapsed: '='
    },
    link: function (scope, element, attr) {

        var count = 0;
        var trackProgress = 0;
        scope.showTimer = false;
        scope.soundManager = soundManager.setup({

            // where to find the SWF files, if needed
            url: '/js/soundmanager/swf/',

            onready: function() {
              // SM2 has loaded, API ready to use e.g., createSound() etc.
            },

            ontimeout: function() {
              // Uh-oh. No HTML5 support, SWF missing, Flash blocked or other issue
            }
        });
        
        setTimeout(function(){
            $(element).find('li:odd').addClass('odd');
            $(element).each(function(){
                $(this).data('playnext', 'true');
                if ($(this).hasClass('autostart')) $(this).data('autoplay', 'true');
                $('li', this).each(function(i){
                    i = i + 1;
                    $('<span class="track-number">'+i+'</span>').prependTo(this);
                });
            });
            $(element).find('.tracks').each(function(){ 
                $(this).addClass('playable'); 
                count++;
                addSounds($(this), count);
            });

            $(element).find('.tracks').on('click',function(){
               
                if($(event.target).parent().hasClass('progress')){
                    $(this).find('.progress').on('click',function(event){
                        bindSeekControl(event , $(this));
                    }); 
                }else{
                     playSound($(this));
                }                     
            });

            // Add default data to tracklist
            $('#tracklist').data('playnext', 'true');
            if ($('#tracklist').hasClass('autostart'))
                $('#tracklist').data('autoplay', 'true');

            if ($(element).find('.tracks').data('show-ui'))
                $(element).find('.tracks').addClass('show-ui');
        },1000); 

        var addSounds = function(trackElement, id){
            var url = trackElement.attr('data-url');
            if(url){
                scope.soundManager.createSound({
                    id  : id.toString(),
                    url : url,
                    whileplaying : function(){
                        scope.currentTrackId = this.id;
                        trackProgress = ((this.position / this.duration) * 100);
                        $rootScope.$broadcast('PROGRESS_CHANGED',trackProgress);
                        $rootScope.$broadcast('ELAPSED', this.position);
                        $rootScope.$broadcast('TOTAL', this.duration);
                    },onfinish   : function() {
                        $rootScope.$broadcast('PROGRESS_CHANGED',0);
                        $rootScope.$broadcast('ELAPSED',0);
                        $rootScope.$broadcast('IS_PLAYING', false);
                    }
                });
            }
            trackElement.attr('id',id);
        }

        var playSound = function(trackElement){
            if(trackElement){ 
                $(element).find('.tracks').each(function(){
                    var id = $(this).attr('id');
                    if ($(this).hasClass('playing')) {
                        scope.soundManager.pause(id.toString());
                        $(this).removeClass('playing');
                        $rootScope.$broadcast('IS_PLAYING', false);
                        //$(this).find('ui timing').hide();   
                        //trackElement.find('ui progress').hide();                     
                    }else if(trackElement.attr('id') === id){
                        scope.soundManager.play(trackElement.attr('id').toString());
                        trackElement.addClass('playing');
                        $rootScope.$broadcast('IS_PLAYING', true);
                        //trackElement.find('ui timing').show();
                        //trackElement.find('ui progress').show();
                    }

                    
                });
               
            }
        }

        var convertMilliSecond = function(milli){
                //var milliseconds = milli % 1000;
                var seconds = Math.floor((milli / 1000) % 60);
                var minutes = Math.floor((milli / (60 * 1000)) % 60);
                return minutes + ":" + seconds;
        }

       scope.$on('PROGRESS_CHANGED', function(event, data) {
            scope.$apply(function() {
                scope.progress = data;
            });
        });
        scope.$on('ELAPSED', function(event, data) {
            scope.$apply(function() {
                scope.elapsed = convertMilliSecond(data);
            });
        });
        scope.$on('TOTAL', function(event, data) {
            scope.$apply(function() {
                scope.total = convertMilliSecond(data);
            });
        });

        scope.$on('IS_PLAYING', function(event, data) {
            scope.$apply(function() {
                scope.isPlaying = data;
                scope.showTimer = data;
            });
        });

       var bindSeekControl = function (event , element) {
            event.preventDefault();
            if (scope.currentTrackId === null) {
                $log.debug('no track loaded');
                return;
            }
            var sound = scope.soundManager.getSoundById(scope.currentTrackId);
            var getXOffset = function (event) {
              var x = 0, element = event.target;
              while (element && !isNaN(element.offsetLeft) && !isNaN(element.offsetTop)) {
                x += element.offsetLeft - element.scrollLeft;
                element = element.offsetParent;
              }
              return event.clientX - x;
            };
            var x = event.offsetX || getXOffset(event),
                width = element[0].clientWidth,
                duration = sound.durationEstimate;
            console.log("this ----- ",this ,  x , width ,duration);
            sound.setPosition((x / width) * duration);
           
        }
    }
  };
}]);