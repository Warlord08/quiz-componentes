(function() {
	'use strict';
	
	angular.module("cruxApp.main", [])
	.controller('mainCtrl', ['$scope', '$http', '$state', mainCtrl]);
	
	function mainCtrl($scope, $http, $state) {
		
		$scope.dateWithFormat = '';
		$scope.form = {
			direccion: '',
			precio: '',
			fecha: new Date()
		};
		
		$scope.crearPropiedad = function() {
			if ($scope.PropForm.$valid) {
				
				$scope.dateWithFormat = $scope.form.fecha.getFullYear()
		           + '-' + $scope.form.fecha.getMonth() + '-'
		           + $scope.form.fecha.getDate();
				
				var request = { 
						"pageNumber": 0,
						"pageSize": 0,
						"direction": "",
						"sortBy": [""],
						"searchColumn": "string",
						"searchTerm": "",
						"propiedad": {
							"direccion": $scope.form.direccion,
							"precio": $scope.form.precio,
							"fechaRegistro": $scope.dateWithFormat
							}
						};
				
				$http.post('rest/protected/propiedades/create', request)
				.success(function(response) {
					$state.go('lista');
				});
			}
		}
		
	}
	
})();