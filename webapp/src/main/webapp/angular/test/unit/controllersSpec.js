describe('controllers', function () {
	beforeEach(module('myApp.controllers'));

	describe("CustomerOrdersController", function() {
		var scope;
		beforeEach(inject(function($rootScope, $controller) {
			scope = $rootScope.$new(),
				mockService = {
					query: function() {
						return [
							{orderNumber: 'O001'},
							{orderNumber: 'O001'}
						];
					}
				};
			ctrl = $controller('CustomerOrdersController', {
				$scope: scope,
				CustomerOrdersService: mockService
			});
		}));

		it("should create orders model with 2 orders fetched from server", function() {
			expect(scope.orders.length).toBe(2);
			expect(scope.orders[0].orderNumber).toBe('O001');
		});

	});
});
