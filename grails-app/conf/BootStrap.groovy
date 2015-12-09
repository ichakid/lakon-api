import java.sql.Timestamp

class BootStrap {

    def init = { servletContext ->

    	Timestamp now = new Timestamp(new Date().getTime())
		Timestamp des4 = new Timestamp(115,11,4,0,0,0,0)
		Timestamp des42014 = new Timestamp(114,11,4,0,0,0,0)

    }
    def destroy = {
    }
}
