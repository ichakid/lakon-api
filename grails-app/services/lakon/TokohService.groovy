package lakon

import grails.transaction.Transactional
import org.hibernate.criterion.CriteriaSpecification

@Transactional
class TokohService {

    def serviceMethod() {
	
	}
	
	def list(){
		def result = Tokoh.createCriteria().list() {
			resultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP)
			projections{
				property('id','id')
				property('nama','nama')
				property('linkweb','linkweb')
				property('isPemerintah','isPemerintah')
				property('isBusinessman','isBusinessman')
				property('isPolitician','isPolitician')
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
		
		Tokoh out = new Tokoh(
			nama: obj.nama,
			linkweb: obj.linkweb,
			isPemerintah: obj.isPemerintah,
			isBusinessman: obj.isBusinessman,
			sumber: obj.sumber,
		)
		return out.save(failOnError: true)
	}
	
	boolean update(Object obj) {
		def out = Tokoh.get(obj.id)
		
		if (out!=null) {
			out.nama = obj.nama
			out.linkweb = obj.linkweb
			out.isPemerintah = obj.isPemerintah
			out.isBusinessman = obj.isBusinessman
			out.isPolitician = obj.isPolitician
		}
		return out.save(failOnError: true)
	}
}