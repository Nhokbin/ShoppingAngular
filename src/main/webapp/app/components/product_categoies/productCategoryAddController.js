(function(app) {

	app.controller('producCategoryAddController', producCategoryAddController);

	producCategoryAddController.$inject = [ '$scope', 'apiService',
			'notificationService', '$state' ];

	function producCategoryAddController($scope, apiService,
			notificationService, $state) {
		$scope.productCategory = {
			id : null,
			name : null,
			alias:null,
			description:null,
			parentID:null,
			displayOrder:null,
			image: null,
			homeFlag: null,
			createdDate : new Date(),
			createdBy:null,
			updatedDate:null,
			updatedBy:null,
			metaKeyword:null,
			metaDescription:null,
			Status : true
			
		}

		$scope.parentCategory = [];

		$scope.addProductCategory = addProductCategory;

		function addProductCategory() {
			apiService.post('/shopping/rest/categoryproduct/create', $scope.productCategory, function(result) {
				notificationService.displaySuccess(result.data.name
						+ " đã được thêm mới");
				$state.go('product_categories')
			}, function(error) {
				notificationService.displayError("Thêm mới không thành công!");
			})
		}

		function loadParentCategory() {
			apiService.get('/shopping/rest/categoryproduct/getall', null,
					function(result) {
						$scope.parentCategory = result.data;
					}, function() {
						console.log('Cannot get list parent');
					});
		}
		loadParentCategory();
	}
})(angular.module('tedushop.product_categories'));