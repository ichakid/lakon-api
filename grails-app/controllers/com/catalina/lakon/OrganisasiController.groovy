package com.catalina.lakon

import grails.converters.JSON

class OrganisasiController {

    def scaffold =true
	static allowedMethods = [list: "GET", save: "POST", update: "PUT", delete: ["DELETE"], show: "GET"]
	def OrganisasiService
	
	def list() {
		render OrganisasiService.list() as JSON
	}

	def save() {
		def output = ["message": "success"]

		if (!OrganisasiService.save(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def update() {
		def output = ["message": "success"]

		if (!OrganisasiService.update(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def show() {
		def id = params.id
		Organisasi organisasi = Organisasi.findById(id.toLong())

		render organisasi as JSON

	}
}
