package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.SeriesDatas;
import br.com.alura.screenmatch.services.ConsumerAPI;
import br.com.alura.screenmatch.services.DataConvert;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner { //CommandLinRunner é uma implementação para rodar com linhas de comando no run - Realizar a implements e Add methods

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumerAPI consumerAPI = new ConsumerAPI();

		var json = consumerAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=c9d230be");
		System.out.println(json);
//		json = consumerAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);
		DataConvert dataConvert = new DataConvert();
		SeriesDatas seriesDatas = dataConvert.obterDatas(json, SeriesDatas.class);
		System.out.println(seriesDatas);
	}
}
