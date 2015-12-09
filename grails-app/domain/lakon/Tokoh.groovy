package lakon

class Tokoh {
	
	String nama
	String linkweb
	Boolean isPemerintah
	Boolean isBusinessman
	Boolean isPolitician
	
	static hasMany = [relasiEntitas: RelasiEntitas]
	
	static mapping = {
		id column: "TOKOH_ID"
	}

    static constraints = {
    }
}
