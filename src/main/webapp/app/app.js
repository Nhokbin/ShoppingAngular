(function(){
	angular.module('tedushop',
		[	'tedushop.products',
			'tedushop.product_categories',
			'tedushop.common'
		]).config(config);
	
	config.$inject = ['$stateProvider', '$urlRouterProvider']
	
	function config($stateProvider, $urlRouterProvider){
		$stateProvider.state('home', {
			url: "/shopping",
			templateUrl :"/shopping/app/components/home/homeView.html",
			controller: "homeController"
		});
		
		$urlRouterProvider.otherwise('/shopping');
	}
})();