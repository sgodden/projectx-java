'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.
angular.module('myApp.services', []).
	factory('CustomerOrdersService',function ($http) {
		return {
			query: function(params) {
				return $http({
					method: "GET",
					url: "/services/myservice/"
				});
			},
			get: function(params) {
				return $http({
					method: "GET",
					url: "/services/myservice/" + params.id,
					transformResponse: function(response) {
						var order = JSON.parse(response);
						order.bookingDate = new Date(order.bookingDate);
						return order;
					}
				});
			}
		}
	}).
	value('version', '0.1');
