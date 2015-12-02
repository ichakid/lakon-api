package com.catalina.lakon

import java.sql.Timestamp;

class RelasiEntitasSumber {
	
	Relasi relasi
	Tokoh tokoh
	Organisasi organisasi
	Sumber sumber
	Timestamp waktu
	
	static belongsTo=[relasi:Relasi,tokoh:Tokoh,organisasi:Organisasi]

    static constraints = {
		relasi(blank:true, nullable: true)
		tokoh(blank:true, nullable: true)
		organisasi(blank:true, nullable: true)
		sumber(blank:true, nullable: true)
		waktu(blank:true, nullable: true)
    }
	
	static mapping = {
		id column: "RES_ID"
	}
}
