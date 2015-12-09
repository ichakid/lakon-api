package lakon

import java.sql.Timestamp

class RelasiEntitas {

	Timestamp waktu
	Relasi relasi
	Tokoh tokoh
	Organisasi organisasi

	static belongsTo = [relasi:Relasi, tokoh: Tokoh, organisasi:Organisasi]

    static constraints = {
    	relasi nullable: false, blank: false
		tokoh nullable: true, blank: true
		organisasi nullable: true, blank: true
    }
}
