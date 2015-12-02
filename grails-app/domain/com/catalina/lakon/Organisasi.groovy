package com.catalina.lakon

class Organisasi {
	
	String nama
	String linkweb
	Boolean isPartai
	Boolean isNonProfit
	Boolean isPemerintahan
	Boolean isSwasta
	Boolean isBUMN
	
	static hasMany = [relasiEntitasSumber: RelasiEntitasSumber]
	
	static mapping = {
		id column: "ORGANISASI_ID"
	}

    static constraints = {
    }
}
