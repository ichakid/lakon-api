package com.catalina.lakon

import grails.converters.JSON

class SumberController {

    def scaffold =true
	static allowedMethods = [list: "GET", save: "POST", update: "PUT", delete: ["DELETE"], show: "GET"]
	def SumberService
	
	def list() {
		render SumberService.list() as JSON
	}

	def save() {
		def output = ["message": "success"]

		if (!SumberService.save(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def update() {
		def output = ["message": "success"]

		if (!SumberService.update(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def show() {
		def id = params.id
		Sumber sumber = Sumber.findById(id.toLong())

		render sumber as JSON

	}
}
