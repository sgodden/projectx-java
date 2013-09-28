'use strict';

/* Controllers */

angular.module('myApp.controllers', []).
  controller('CustomerOrdersController', function($scope, $http) {
		$http.get('/services/myservice').success(function(data) {
			$scope.orders = data;
		});
  })
  .controller('MyCtrl2', [function() {

  }]);