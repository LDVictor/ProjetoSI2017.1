app.config(function($routeProvider) {
	$routeProvider.when("/", {}).when("/complaint/register", {
		templateUrl : "view/registerComplaint.html",
		controller : "registraQueixa"
	}).when("/consultarEspecialidade", {
		templateUrl : "/view/consultarEspecialidadeMedica.html",
		controller : "consultaEspecialidade"
	}).when("/addespecialidade", {
		templateUrl : "view/addEspecialidade.html",
		controller : "addEspecialidade"
	}).when("/unidade/adicionaHospital", {
		templateUrl : "view/adicionarUnidadeSaude.html",
		controller : "adicionaHospital"
	}).when("/unidade/adicionaPostoSaude", {
		templateUrl : "view/adicionarUnidadeSaude.html",
		controller : "adicionaPostoSaude"
	}).when("/searchcomplaint", {
		templateUrl : "view/search_complaint.html",
		controller : "procuraQueixa"
	}).when("/createdunidadesaude/:id", {
		templateUrl : "view/sucessPageUnidadeSaude.html",
		controller : "mensagemCriacaoUnidadeSaude"
	}).when("/search_health_unit", {
		templateUrl : "view/searchHealthUnit.html",
		controller : "procuraUnidadeSaude"
	}).when("/prefeitura/modifica", {
		templateUrl : "view/modificaSituacaoPrefeitura.html",
		controller : "modificaSituacaoPrefeitura"
	}).when("/searchaverage", {
		templateUrl : "view/search_average_per_patient.html",
		controller : "procuraMediaMedicoPaciente"
	}).when("/modificaoprefeitura/", {
		templateUrl : "view/sucessPageModificaSituacaoPrefeitura.html"
	}).when("createdespecialidade/:id", {
		templateUrl : "/view/sucessPageEspecialidade.html",
		controller : "mensagemCriacaoEspecialidade"
	}).when("/createdcomplaint/:id", {
		templateUrl : "view/successPage.html",
		controller : "mensagemCriacaoQueixa"
	}).when("/deletedcomplaint/:id", {
		templateUrl : "view/deletaQueixaPage.html"
	}).when("/generalSituationComplaints", {
		templateUrl : "view/generalSituationComplaints.html",
		controller : "situacaoGeralQueixas"
	}).when("/usuario/:id", {
		templateUrl : "view/user.html"
	}).when("/login/admin", {
		templateUrl : "/view/admin.html",
		controller : "retornaQueixasCtrl"
	}).when("/login/listaUnidadeSaude", {
		templateUrl : "/view/listaUnidadeSaude.html",
		controller : "retornaUnidadeSaudeCtrl"
	}).otherwise({
		redirectTo : '/'
	});
});
