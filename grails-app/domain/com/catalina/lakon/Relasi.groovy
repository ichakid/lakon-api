package com.catalina.lakon

class Relasi {

    String keterangan
	Sumber sumber
	String type

	static hasMany = [relasiEntitas: RelasiEntitas]
	static belongsTo = [sumber: Sumber]
	
	static mapping = {
		id column: "RELASI_ID"
	}

	static constraints = {
		sumber nullable: false, blank: false
	}

}
