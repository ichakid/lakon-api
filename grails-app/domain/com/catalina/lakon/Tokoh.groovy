package com.catalina.lakon

class Tokoh {
	
	String nama
	String linkweb
	Boolean isPemerintan
	Boolean isBusinessman
	Boolean isPolitician
	
	static hasMany = [relasiEntitasSumber: RelasiEntitasSumber]
	
	static mapping = {
		id column: "TOKOH_ID"
	}

    static constraints = {
    }
}
