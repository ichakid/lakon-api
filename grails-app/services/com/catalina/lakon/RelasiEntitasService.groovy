package com.catalina.lakon

import grails.transaction.Transactional

import org.hibernate.criterion.CriteriaSpecification

@Transactional
class RelasiEntitasService {

    def serviceMethod() {
	
	}
	
	def list(){
		def result = RelasiEntitas.createCriteria().list() {
			resultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP)
			createAlias('relasi', 'RL', CriteriaSpecification.LEFT_JOIN)
			createAlias('tokoh', 'TK', CriteriaSpecification.LEFT_JOIN)
			createAlias('organisasi', 'ORG', CriteriaSpecification.LEFT_JOIN)
			projections{
				property('id','id')
				property('waktu','waktu')
				property('relasi','relasi')
				property('tokoh','tokoh')
				property('organisasi','organisasi')
			}
		}

		return result
	}
	
	boolean save(Object obj) {
		
		RelasiEntitas out = new RelasiEntitas(
			waktu: obj.waktu,
			relasi: obj.relasi,
			tokoh: obj.tokoh,
			organisasi: obj.organisasi,
		)
		return out.save(failOnError: true)
	}
	
	boolean update(Object obj) {
		def out = RelasiEntitas.get(obj.id)
		def relasi = Relasi.findById(obj.sumber.id.toLong())
		def tokoh = Tokoh.findById(obj.sumber.id.toLong())
		def organisasi = Organisasi.findById(obj.sumber.id.toLong())
		
		if (out!=null) {
			out.waktu = obj.waktu
			out.relasi = relasi
			out.tokoh = tokoh
			out.organisasi = organisasi
		}
		return out.save(failOnError: true)
	}

	def listByTokoh(Tokoh tokoh) {

		def result = RelasiEntitas.createCriteria().list() {
			eq("tokoh", tokoh)
			resultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP)
			createAlias('relasi', 'RL', CriteriaSpecification.LEFT_JOIN)
			createAlias('tokoh', 'TK', CriteriaSpecification.LEFT_JOIN)
			projections{
				property('id','id')
				property('waktu','waktu')
				property('relasi','relasi')
				property('tokoh','tokoh')
			}
		}

		return result

	}
}
