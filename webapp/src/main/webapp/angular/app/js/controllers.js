'use strict';

/* Controllers */

angular.module('myApp.controllers', []).
  controller('CustomerOrdersController', function($scope, $http) {
		$scope.orders = [
			{
				orderNumber: 'FOO'
			},
			{
				orderNumber: 'BAR'
			}
		];
  })
  .controller('MyCtrl2', [function() {

  }]);