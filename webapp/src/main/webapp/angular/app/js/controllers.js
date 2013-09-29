'use strict';

angular.module('myApp.controllers', [])
	.controller('CustomerOrdersController', function($scope, CustomerOrdersService) {
		CustomerOrdersService.query(function(data) {
			$scope.orders = data;
		});
  })
  .controller('MyCtrl1', function() {

  })
  .controller('MyCtrl2', function() {

  })
;