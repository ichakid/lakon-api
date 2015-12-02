package com.catalina.lakon

class Sumber {
	
	String link
	
	//TODO change to user
	String who
	
	static hasMany = [relasiEntitasSumber: RelasiEntitasSumber]
	
	static mapping = {
		id column: "SUMBER_ID"
	}
}
