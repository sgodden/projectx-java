'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.
angular.module('myApp.services', ['ngResource']).
	factory('CustomerOrdersService',function ($resource) {
		return $resource('/services/myservice/:id');
	}).
	value('version', '0.1');
