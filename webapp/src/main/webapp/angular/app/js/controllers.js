'use strict';

/* Controllers */

angular.module('myApp.controllers', []).
  controller('CustomerOrdersController', function($scope, CustomerOrdersService) {
		CustomerOrdersService.get(function(data) {
			$scope.orders = data;
		});
  })
  .controller('MyCtrl2', [function() {

  }]);