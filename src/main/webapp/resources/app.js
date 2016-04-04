(function() {
	'use strict';
	
	angular.module("cruxApp", ['ui.router', "cruxApp.main", 'cruxApp.list', 'cruxApp.edit'])
	.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise('/');
		
		$stateProvider
			.state('registrar', {
				cache: false,
				url: '/registrar',
				templateUrl: 'resources/createView/createView.html',
				controller: 'mainCtrl'
			})
			.state('lista', {
				cache: false,
				url: '/',
				templateUrl: 'resources/listView/listView.html',
				controller: 'listCtrl'
			})
			.state('editar', {
				cache: false,
				url: '/editar',
				params: {param: null},
				templateUrl: 'resources/editView/editView.html',
				controller: 'editCtrl'
			})
	}]);
})();