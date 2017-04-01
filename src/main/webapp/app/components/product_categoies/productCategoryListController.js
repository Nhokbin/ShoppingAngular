(function(app){
	
	app.controller('producCategoryListController', producCategoryListController);
	
	producCategoryListController.$inject = ['$scope','apiService','notificationService'];
	
	function producCategoryListController($scope, apiService, notificationService){
		$scope.productCategories = [];
		$scope.page = 0;
		$scope.pagesCount = 0;
		$scope.totalCount = 0;
		$scope.getProductCategories = getProductCategories;
		$scope.keyword='';

		$scope.search = search;

		function search(){
			getProductCategories();
		}

		function getProductCategories(page){
			page = page || 0;
			var config = {
				params : {
					page: page,
					pageSize : 20,
					keyword: $scope.keyword
				}
			}
			apiService.get('/shopping/rest/categoryproduct/getall/page',config, function(result){
				if(result.data.totalCount == 0){
					notificationService.displayWarning('Không có bản ghi nào được tìm thấy.');
				}else{
					notificationService.displaySuccess('Có '+result.data.totalCount+' bản ghi được tìm thấy.');
				}
				$scope.productCategories = result.data.items;
				$scope.page = result.data.page;
				$scope.pagesCount = result.data.totalPages;
				$scope.totalCount = result.data.totalCount;
			}, function(){
				console.log('Load productCategory failed');
			});
		}
		$scope.getProductCategories();
	}
})(angular.module('tedushop.product_categories'));