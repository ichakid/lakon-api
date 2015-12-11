package com.catalina.lakon

import grails.transaction.Transactional
import grails.converters.JSON

@Transactional
class AliasService {

	def serviceMethod() {
	
	}
	
	def list(){
		def result = Alias.createCriteria().list() {
			resultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP)
			createAlias('tokoh', 'TK', CriteriaSpecification.LEFT_JOIN)
			createAlias('organisasi', 'ORG', CriteriaSpecification.LEFT_JOIN)
			projections{
				property('id','id')
				property('nama','nama')
				property('tokoh','tokoh')
				property('organisasi','organisasi')
			}
		}

		return result
	}
	
	boolean save(Object obj) {
		
		Alias out = new Alias(
			nama: obj.nama,
			tokoh: obj.tokoh,
			organisasi: obj.organisasi,
		)
		return out.save(failOnError: true)
	}
	
	boolean update(Object obj) {
		def out = Alias.get(obj.id)
		def tokoh = Tokoh.findById(obj.tokoh.id.toLong())
		def organisasi = Organisasi.findById(obj.organisasi.id.toLong())
		
		if (out!=null) {
			out.nama = obj.nama
			out.tokoh = tokoh
			out.organisasi = organisasi
		}
		return out.save(failOnError: true)
	}

    
}
