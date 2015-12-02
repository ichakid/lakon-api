package com.catalina.lakon

import java.sql.Timestamp;

import grails.transaction.Transactional

import org.hibernate.criterion.CriteriaSpecification

@Transactional
class RelasiEntitasSumberService {

    def serviceMethod() {
	
	}
	
	def list(){
		def result = RelasiEntitasSumber.createCriteria().list() {
			resultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP)
			createAlias('relasi', 'RL', CriteriaSpecification.LEFT_JOIN)
			createAlias('tokoh', 'TK', CriteriaSpecification.LEFT_JOIN)
			createAlias('organisasi', 'OR', CriteriaSpecification.LEFT_JOIN)
			createAlias('sumber', 'SM', CriteriaSpecification.LEFT_JOIN)
			projections{
				property('id','id')
				property('relasi','relasi')
				property('tokoh','tokoh')
				property('organisasi','organisasi')
				property('sumber','sumber')
				property('waktu','waktu')
			}
		}
		
		return result
	}
	
	boolean save(Object obj) {
		
		RelasiEntitasSumber out = new RelasiEntitasSumber(
			relasi: obj.relasi,
			tokoh: obj.tokoh,
			organisasi: obj.organisasi,
			sumber: obj.sumber,
			waktu: obj.waktu,
		)
		return out.save(failOnError: true)
	}
	
	boolean update(Object obj) {
		def out = RelasiEntitasSumber.get(obj.id)
		def relasi = Relasi.findById(obj.relasi.id.toLong())
		def tokoh = Tokoh.findById(obj.relasi.id.toLong())
		
		if (out!=null) {
			out.relasi = relasi
			out.tokoh = obj.tokoh
			out.organisasi = obj.organisasi
			out.sumber = obj.sumber
			out.waktu = obj.waktu
		}
		return out.save(failOnError: true)
	}
}
