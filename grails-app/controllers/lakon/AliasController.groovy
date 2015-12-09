package lakon
import grails.converters.JSON

import java.util.*

class AliasController {

    def scaffold =true
	static allowedMethods = [list: "GET", save: "POST", update: "PUT", delete: ["DELETE"], show: "GET"]
	def AliasService
	
	def list() {
		render AliasService.list() as JSON
	}

	def save() {
		def output = ["message": "success"]

		if (!AliasService.save(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def update() {
		def output = ["message": "success"]

		if (!AliasService.update(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def show() {
		def id = params.id
		Alias alias = AliasService.findById(id.toLong())

		render alias as JSON

	}

	def searchByAlias() {
		def al =  params.alias
		def res = Alias.findAllByNamaIlike(al.toLowerCase()+"%")

		def response = []

		Tokoh tokoh = Tokoh.findByNamaIlike(al+"%")	
		if (tokoh!=null) {
			AliasResponse ar = new AliasResponse()
			ar.nama = tokoh.nama
			ar.id = tokoh.id
			ar.type = "tokoh"
			response.add(ar)
		}

		Organisasi organisasi = Organisasi.findByNamaIlike(al+"%")	
		if (organisasi!=null) {
			AliasResponse aro = new AliasResponse()
			aro.nama = organisasi.nama
			aro.id = organisasi.id
			aro.type = "organisasi"
			response.add(aro)
		}


		res.each {
			AliasResponse aliasResponse = new AliasResponse()
			if (it.tokoh != null) {		
				Tokoh tok = Tokoh.findById(it.tokoh.id)
				aliasResponse.nama = tok.nama
				aliasResponse.id = tok.id
				aliasResponse.type = "tokoh"
				response.add(aliasResponse)
			} else {
				Organisasi org = Organisasi.findById(it.organisasi.id)
				aliasResponse.nama = org.nama
				aliasResponse.id = org.id
				aliasResponse.type = "organisasi"
				response.add(aliasResponse)
			}
		}
		
		def uniqueRes = response.unique({a,b -> a.id <=> b.id})

		render uniqueRes as JSON
	}
}
