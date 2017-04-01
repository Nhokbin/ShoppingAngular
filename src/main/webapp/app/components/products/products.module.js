(function(){
angular.module('tedushop.products',['tedushop.common']).config(config);
	
	config.$inject = ['$stateProvider', '$urlRouterProvider']
	
	function config($stateProvider, $urlRouterProvider){
		$stateProvider.state('products', {
			url: "/products",
			templateUrl :"/shopping/app/components/products/productView.html",
			controller: "productListController"
		}).state('product_add',{
			url: "/product_add",
			templateUrl :"/shopping/app/components/products/productAddView.html",
			controller: "productAddController"
		});
	}
})();