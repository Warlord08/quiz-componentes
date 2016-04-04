(function() {
	'use strict';
	
	angular.module('cruxApp.list', [])
	.controller('listCtrl', ['$scope', '$http', '$state', listCtrl]);
	
	function listCtrl($scope, $http, $state) {
		$scope.listaPropiedades = [];
		
		$http.get('rest/protected/propiedades/getAll')
		.success(function(response) {
			$scope.listaPropiedades = response.propiedades;
			for (var i = 0; i < $scope.listaPropiedades.length; i++) {
				$scope.fecha = new Date($scope.listaPropiedades[i].fechaRegistro);
				$scope.fecha.setMonth($scope.fecha.getMonth() + 1);
				$scope.fecha.setDate($scope.fecha.getDate() + 1);
			}
		});
		
		
		$scope.deletePropiedad = function(idPropiedad, $index) {
			$http.delete('rest/protected/propiedades/' + idPropiedad)
			.success(function(response) {
				$scope.listaPropiedades.splice($index, 1);
			});
		}
		
		$scope.editar = function(idPropiedad) {
			$state.go('editar', {param: {'id': idPropiedad}});
		}
		
	}
	
})();