package com.catalina.lakon

class Relasi {

    String keterangan
	
	static hasMany = [relasiEntitasSumber: RelasiEntitasSumber]
	
	static mapping = {
		id column: "RELASI_ID"
	}

}
