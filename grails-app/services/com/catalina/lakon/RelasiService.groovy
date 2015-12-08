package com.catalina.lakon

import grails.transaction.Transactional
import org.hibernate.criterion.CriteriaSpecification

@Transactional
class RelasiService {

	def serviceMethod() {
	
	}
	
	def list(){
		def result = Relasi.createCriteria().list() {
			resultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP)
			createAlias('sumber', 'SR', CriteriaSpecification.LEFT_JOIN)
			projections{
				property('id','id')
				property('keterangan','keterangan')
				property('sumber','sumber')
				property('type','type')
			}
		}

		def relasiEntitas = RelasiEntitas.findAll()
		result.each {
			long rid = it.id
			def rs = relasiEntitas.findAll{ it.relasi && it.relasi.id == rid }

			it.put("relasiEntitas",rs)
		}
		
		return result
	}
	
	boolean save(Object obj) {
		
		Relasi out = new Relasi(
			keterangan: obj.keterangan,
			sumber: obj.sumber,
			type: obj.type
		)
		return out.save(failOnError: true)
	}
	
	boolean update(Object obj) {
		def out = Relasi.get(obj.id)
		def sumber = Sumber.findById(obj.sumber.id.toLong())
		
		if (out!=null) {
			out.keterangan = obj.keterangan
			out.sumber = sumber
			out.type = type
		}
		return out.save(failOnError: true)
	}
}
