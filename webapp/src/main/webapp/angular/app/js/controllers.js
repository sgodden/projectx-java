'use strict';

angular.module('myApp.controllers', ['ui.date'])

	.controller('CustomerOrdersController', function ($scope, CustomerOrdersService) {
		CustomerOrdersService.query().then(function(response) {
			$scope.orders = response.data;
		});
	})

	.controller('CustomerOrderController', function ($scope, $routeParams, CustomerOrdersService) {
		$scope.order = {};
		CustomerOrdersService.get({id: $routeParams.id}).then(function(response) {
			$scope.order = response.data;
		});
		$scope.submit = function() {
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