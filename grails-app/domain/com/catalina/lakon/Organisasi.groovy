package com.catalina.lakon

class Organisasi {
	
	String nama
	String linkweb
	Boolean isPartai
	Boolean isNonProfit
	Boolean isPemerintahan
	Boolean isSwasta
	Boolean isBUMN
	
	static hasMany = [relasiEntitas: RelasiEntitas]
	
	static mapping = {
		id column: "ORGANISASI_ID"
	}

    static constraints = {
    }
}
