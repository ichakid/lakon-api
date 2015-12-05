package com.catalina.lakon

import grails.transaction.Transactional
import org.hibernate.criterion.CriteriaSpecification

@Transactional
class OrganisasiService {

    def serviceMethod() {
	
	}
	
	def list(){
		def result = Organisasi.createCriteria().list() {
			resultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP)
			projections{
				property('id','id')
				property('nama','nama')
				property('linkweb','linkweb')
				property('isPartai','isPartai')
				property('isNonProfit','isNonProfit')
				property('isPemerintahan','isPemerintahan')
				property('isSwasta','isSwasta')
				property('isBUMN','isBUMN')
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
		
		Organisasi out = new Organisasi(
			nama: obj.nama,
			linkweb: obj.linkweb,
			isPartai: obj.isPartai,
			isNonProfit: obj.isNonProfit,
			isPemerintahan: obj.isPemerintahan,
			isSwasta: obj.isSwasta,
			isBUMN: obj.isBUMN,
		)
		return out.save(failOnError: true)
	}
	
	boolean update(Object obj) {
		def out = Organisasi.get(obj.id)
		
		if (out!=null) {
			out.nama = obj.nama
			out.linkweb = obj.linkweb
			out.isPartai = obj.isPartai
			out.isNonProfit = obj.isNonProfit
			out.isPemerintahan = obj.isPemerintahan
			out.isSwasta = obj.isSwasta
			out.isBUMN = obj.isBUMN
		}
		return out.save(failOnError: true)
	}
}
