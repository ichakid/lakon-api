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
			projections{
				property('id','id')
				property('keterangan','keterangan')
			}
		}
		
		return result
	}
	
	boolean save(Object obj) {
		
		Relasi out = new Relasi(
			keterangan: obj.keterangan,
		)
		return out.save(failOnError: true)
	}
	
	boolean update(Object obj) {
		def out = Relasi.get(obj.id)
		
		if (out!=null) {
			out.keterangan = obj.keterangan
		}
		return out.save(failOnError: true)
	}
}
