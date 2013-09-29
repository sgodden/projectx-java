'use strict';

angular.module('myApp.controllers', [])
	.controller('CustomerOrdersController', function ($scope, CustomerOrdersService) {
		CustomerOrdersService.query(function (response) {
			$scope.orders = response;
		});
	})
	.controller('CustomerOrderController', function ($scope, $routeParams, CustomerOrdersService) {
		CustomerOrdersService.get({id: $routeParams.id}, function (response) {
			$scope.order = response;
		});
	})
	.controller('MyCtrl1', function () {

	})
	.controller('MyCtrl2', function () {

	})
;