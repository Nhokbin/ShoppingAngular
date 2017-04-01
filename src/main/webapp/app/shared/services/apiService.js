(function(app) {
	app.factory('apiService', apiService);

	apiService.$inject = [ '$http', 'notificationService' ];
	function apiService($http, notificationService) {
		return {
			get : get,
			post : post
		}

		function get(url, params, success, failure) {
			$http.get(url, params).then(function(result) {
				success(result);
			}, function(error) {
				failure(error)
			});
		}

		function post(url, data, success, failure) {
			var headers = {
				"accept" : "application/json; charset=utf-8",
				"Content-Type" : "application/x-www-form-urlencoded",
				"X-Login-Ajax-call" : 'true'
			}
			$http.post(url, data).then(
					function(result) {
						success(result);
					},
					function(error) {
						if (error.status === 401 ) {
							notificationService
									.displayError('Authenticate is required!');
						}else if(error.status === 409){
							notificationService
							.displayError('Data is already exists!');
						}else if(error.status === 400){
							notificationService
							.displayError('Please enter full information!');
						}
						failure(error);
					})
		}
	}
})(angular.module('tedushop.common'));