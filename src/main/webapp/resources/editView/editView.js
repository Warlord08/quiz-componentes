(function() {
	'use strict';
	
	angular.module('cruxApp.edit', [])
	.controller('editCtrl', ['$scope', '$http', '$state', '$stateParams', editCtrl]);
	
	function editCtrl($scope, $http, $state, $stateParams) {
		var idPropiedad = $stateParams.param.id
		$scope.propiedad = {};
		
		$http.get('rest/protected/propiedades/getById/' + idPropiedad)
		.success(function(response) {
			$scope.propiedad = response.propiedad;
			$scope.fecha = new Date($scope.propiedad.fechaRegistro);
			$scope.fecha.setMonth($scope.fecha.getMonth() + 1)
			$scope.fecha.setDate($scope.fecha.getDate() + 1)
		});
		
		$scope.updatePropiedad = function() {
			if ($scope.PropForm.$valid) {
				var request = { 
						"pageNumber": 0,
						"pageSize": 0,
						"direction": "",
						"sortBy": [""],
						"searchColumn": "string",
						"searchTerm": "",
						"propiedad": {
							"direccion": $scope.propiedad.direccion,
							"precio": $scope.propiedad.precio,
							}
						};
				$http.put('rest/protected/propiedades/update/'+idPropiedad, request)
				.success(function(response) {
					$state.go('lista');
				});
			}
		}
	}
	
})();