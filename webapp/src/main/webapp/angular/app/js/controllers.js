'use strict';

angular.module('myApp.controllers', [])
	.controller('CustomerOrdersController', function ($scope, CustomerOrdersService) {
		$scope.orders = CustomerOrdersService.query();
	})
	.controller('CustomerOrderController', function ($scope, $routeParams, CustomerOrdersService) {
		$scope.order = CustomerOrdersService.get({id: $routeParams.id});

		$scope.submit = function() {
			console.log($scope.order.orderNumber);
			$scope.order.$save(function() {
				window.location.href = '#/orders';
			});
		};
	})
	.controller('MyCtrl1', function () {

	})
	.controller('MyCtrl2', function () {

	})
;