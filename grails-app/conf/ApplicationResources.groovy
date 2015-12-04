modules = {
    application {
        resource url:'js/application.js'
    }
	
	'app-js' {
		dependsOn 'angular'  // base angular modules
        resource url:'js/app.js'
        resource url:'js/services.js'
        resource url:'js/controllers.js'
        resource url:'js/filters.js'
        resource url:'js/directives.js'
    }

    'app' {
		// dependsOn 'angular'  // base angular modules
		// dependsOn 'angular-top'  // most common angular modules
		// dependsOn 'angular-all'  // all angular modules (without test scripts)
		dependsOn 'angular-all'  // enable this, as a sample ...
		dependsOn 'app-js'  // application-specific angular-related scripts ...
    }

    'index' {
        // resource url:'js/app.js'
    }
}