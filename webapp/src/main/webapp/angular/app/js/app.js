'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', ['$strap.directives', 'ngRoute', 'myApp.filters', 'myApp.services', 'myApp.directives', 'myApp.controllers']).
  config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/orders', {templateUrl: 'partials/ListCustomerOrders.html', controller: 'CustomerOrdersController'});
    $routeProvider.when('/orders/:id', {templateUrl: 'partials/CustomerOrder.html', controller: 'CustomerOrderController'});
    $routeProvider.when('/view1', {templateUrl: 'partials/partial1.html', controller: 'MyCtrl1'});
    $routeProvider.when('/view2', {templateUrl: 'partials/partial2.html', controller: 'MyCtrl2'});
    $routeProvider.otherwise({redirectTo: '/view1'});
  }]);
