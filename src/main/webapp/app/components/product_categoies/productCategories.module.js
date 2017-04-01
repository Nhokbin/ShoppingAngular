(function(){
	angular.module('tedushop.product_categories',['tedushop.common']).config(config);
	
	config.$inject = ['$stateProvider', '$urlRouterProvider']
	
	function config($stateProvider, $urlRouterProvider){
		$stateProvider.state('product_categories', {
			url: "/product_categories",
			templateUrl :"/shopping/app/components/product_categoies/productCategoryListView.html",
			controller: "producCategoryListController"
		}).state('add_product_category', {
			url: "/add_product_category",
			templateUrl :"/shopping/app/components/product_categoies/productCategoryAddView.html",
			controller: "producCategoryAddController"
		});
	}
})();