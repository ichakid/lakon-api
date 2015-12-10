package lakon

class Sumber {
	
	String link
	String who
	
	static hasMany = [relasi:Relasi]
	
	static mapping = {
		id column: "SUMBER_ID"
	}
}
