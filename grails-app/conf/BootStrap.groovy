import com.catalina.lakon.*

import java.sql.Timestamp

class BootStrap {

    def init = { servletContext ->

    	Timestamp now = new Timestamp(new Date().getTime())
		Timestamp des4 = new Timestamp(115,11,4,0,0,0,0)

    	Tokoh tokoh1 = new Tokoh(
			nama: "Setya Novanto",
			linkweb: "http://aniesbaswedan.com/",
			isPemerintah: true,
			isBusinessman: false,
			isPolitician: false,

			).save(flush:true,failOnError:true);

    	Tokoh tokoh2 = new Tokoh(
			nama: "Aburizal Bakrie",
			linkweb: "https://twitter.com/aburizalbakrie",
			isPemerintah: false,
			isBusinessman: true,
			isPolitician: false,

			).save(flush:true,failOnError:true);

    	Organisasi organisasi1 = new Organisasi(
			nama: "PDI Perjuangan",
			linkweb: "http://www.pdiperjuangan.or.id/",
			isPartai: true,
			isNonProfit: false,
			isPemerintahan: false,
			isSwasta: false,
			isBUMN: false,
			).save(flush:true,failOnError:true);

    	Organisasi organisasi2 = new Organisasi(
			nama: "Partai Demokrat",
			linkweb: "http://www.demokrat.or.id/",
			isPartai: true,
			isNonProfit: false,
			isPemerintahan: false,
			isSwasta: false,
			isBUMN: false,
			).save(flush:true,failOnError:true);

    	Sumber sumber1 = new Sumber(
			link: "http://news.detik.com/berita/3088453/hanya-3-menteri-yang-hadiri-resepsi-pernikahan-putri-novanto",
			who: "admin",
			).save(flush:true,failOnError:true);
		
		Relasi relasi1 = new Relasi(
			keterangan: "pernikahan putri Setya Novanto",
			sumber: sumber1,
			).save(flush:true,failOnError:true);

		RelasiEntitas relasiEntitas1 = new RelasiEntitas(
			waktu: des4,
			relasi: relasi1,
			tokoh: tokoh1,
			organisasi: null,
		).save(flush:true,failOnError:true);

		RelasiEntitas relasiEntitas2 = new RelasiEntitas(
			waktu: des4,
			relasi: relasi1,
			tokoh: tokoh2,
			organisasi: null,
		).save(flush:true,failOnError:true);
		

    }
    def destroy = {
    }
}
