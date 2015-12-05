package com.catalina.lakon

import grails.transaction.Transactional
import org.hibernate.criterion.CriteriaSpecification

@Transactional
class SumberService {

    def serviceMethod() {
	
	}
	
	def list(){
		def result = Sumber.createCriteria().list() {
			resultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP)
			projections{
				property('id','id')
				property('link','link')
				property('who','who')
			}
		}

		def relasi = Relasi.findAll()
		result.each {
			long rid = it.id
			def rs = relasi.findAll{ it.sumber && it.sumber.id == rid }

			it.put("relasi",rs)
		}
		
		return result
	}
	
	boolean save(Object obj) {
		
		Sumber out = new Sumber(
			link: obj.link,
			who: obj.who
		)
		return out.save(failOnError: true)
	}
	
	boolean update(Object obj) {
		def out = Sumber.get(obj.id)
		
		if (out!=null) {
			out.link = obj.link
			out.who = who
		}
		return out.save(failOnError: true)
	}
}
