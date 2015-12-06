package com.catalina.lakon

import grails.converters.JSON

class RelasiEntitasController {

    def scaffold =true
	static allowedMethods = [list: "GET", save: "POST", update: "PUT", delete: ["DELETE"], show: "GET"]
	def RelasiEntitasService
	
	def list() {
		render RelasiEntitasService.list() as JSON
	}

	def save() {
		def output = ["message": "success"]

		if (!RelasiEntitasService.save(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def update() {
		def output = ["message": "success"]

		if (!RelasiEntitasService.update(request.JSON)) {
			output = ["message": "failed"]
		}

		render output as JSON
	}

	def show() {
		def id = params.id
		RelasiEntitas relasiEntitas = RelasiEntitas.findById(id.toLong())

		render relasiEntitas.relasi as JSON

	}

	def buildGraph() {
		def id = params.id
		Tokoh tokoh = Tokoh.findById(id.toLong())

		def res = RelasiEntitasService.listByTokoh(tokoh)

		Graph graph = new Graph()

		Node noder = new Node()
		noder.name = tokoh.nama
		noder.type = "main"
		noder.root = true
		noder.id = 0

		graph.nodes.add(noder)

		int count=1

		for(ite in res){
			def rel = RelasiEntitas.findAllByRelasi(ite.relasi)
		    for(ite2 in rel){
		    	Node node = new Node()
		    	if (ite2.tokoh !=null) {
		    		def tok = Tokoh.findById(ite2.tokoh.id)
		    		if (tok.id != id.toLong()) { 	
			         	node.name = tok.nama
			         	node.type = "tokoh"
			         	node.id = count
			         	graph.nodes.add(node)
			         	count = count+1

			         	Edge edge = new Edge()
						edge.source = 0
						edge.target = node.id
						edge.keterangan = ite.relasi.keterangan
						edge.type = "event"
						graph.edges.add(edge)
		         	}
		        } else {
		        	def org = Organisasi.findById(ite2.organisasi.id)
		        	node.name = org.nama
		         	node.type = "organisasi"
		         	graph.nodes.add(node)
		         	node.id = count
		         	count = count+1

	         		Edge edge = new Edge()
					edge.source = 0
					edge.target = node.id
					edge.keterangan = ite.relasi.keterangan
					edge.type = "event"
					graph.edges.add(edge)
		        }
		    }
		}

		res.each {
			
		}


		

		render graph  as JSON
	}
}
