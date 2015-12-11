package com.catalina.lakon

class Alias {

	String nama
	Tokoh tokoh
	Organisasi organisasi

	static belongsTo = [tokoh: Tokoh, organisasi:Organisasi]

    static constraints = {
		tokoh nullable: true, blank: true
		organisasi nullable: true, blank: true
    }
}
