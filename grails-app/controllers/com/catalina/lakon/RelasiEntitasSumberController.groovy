package com.catalina.lakon

import grails.converters.JSON

class RelasiEntitasSumberController {

    def scaffold =true
	static allowedMethods = [list: "GET", save: "POST", update: "PUT", delete: ["DELETE"], show: "GET"]
	def RelasiEntitasSumberService
	
	def list() {
		render RelasiEntitasSumberService.list() as JSON
	}

	def save() {
		def output = ["message": "success"]

		if (!RelasiEntitasSumberService.save(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def update() {
		def output = ["message": "success"]

		if (!RelasiEntitasSumberService.update(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def show() {
		def id = params.id
		RelasiEntitasSumber relasiEntitasSumber = RelasiEntitasSumber.findById(id.toLong())

		render relasi as JSON

	}
}
