'use strict';

var AngularSpringApp = {};

var App = angular.module('TodoApp', ['ui.bootstrap','ngSanitize','TodoApp.filters', 'TodoApp.services', 'TodoApp.directives']);


App.controller("SpringerController", function ($scope, $window, $rootScope, $routeParams, $http, Crawler) {

    $scope.hasError = false;
    $scope.newResults = false;
    $scope.articles = [];

    $scope.noArticles = undefined;

    $scope.crawlArticles = function (authorName) {

        Crawler.crawlArticles(authorName)
                .success(function (n) {
            $scope.noArticles = n;
            $scope.hasError = false;
            $scope.newResults = true;
        })
                .error(function (response, status) {
            $scope.hasError = true;
        });

    }

    Crawler.listArticles().success(function(articles){
        $scope.articles = articles;
    });


    $scope.listArticles = function (){

        Crawler.listArticles().success(function(articles){
            console.log(articles);
            $scope.articles = articles;
        });
    }

});

App.factory("Crawler", function($http) {

    return {

        crawlArticles: function(authorName) {
            return $http.post('/frontend/springer/crawl', authorName);
        },

        listArticles: function(){

            return $http.get('/frontend/springer/list');

        }
    }

});





