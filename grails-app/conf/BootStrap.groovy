import com.catalina.lakon.*

class BootStrap {

    def init = { servletContext ->
		
		Relasi relasi1 = new Relasi(
			keterangan: "sby sholat berjamaan",
			).save(flush:true,failOnError:true);
		
		Relasi relasi2 = new Relasi(
			keterangan: "gala dinner",
			).save(flush:true,failOnError:true);
    }
    def destroy = {
    }
}
