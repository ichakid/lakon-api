package lakon

import grails.converters.JSON

class RelasiController {

	def scaffold =true
	static allowedMethods = [list: "GET", save: "POST", update: "PUT", delete: ["DELETE"], show: "GET"]
	def RelasiService
	
	def list() {
		render RelasiService.list() as JSON
	}

	def save() {
		def output = ["message": "success"]

		if (!RelasiService.save(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def update() {
		def output = ["message": "success"]

		if (!RelasiService.update(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def show() {
		def id = params.id
		Relasi relasi = Relasi.findById(id.toLong())

		render relasi as JSON

	}
}
