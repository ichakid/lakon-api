package com.catalina.lakon

import grails.converters.JSON

class TokohController {

    def scaffold =true
	static allowedMethods = [list: "GET", save: "POST", update: "PUT", delete: ["DELETE"], show: "GET", buildGraph: "GET"]
	def TokohService
	
	def list() {
		render TokohService.list() as JSON
	}

	def save() {
		def output = ["message": "success"]

		if (!TokohService.save(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def update() {
		def output = ["message": "success"]

		if (!TokohService.update(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def show() {
		def id = params.id
		Tokoh tokoh = Tokoh.findById(id.toLong())

		render tokoh as JSON

	}
}
