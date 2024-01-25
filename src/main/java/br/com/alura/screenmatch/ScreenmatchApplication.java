package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.EpisodeDatas;
import br.com.alura.screenmatch.model.SeasonDatas;
import br.com.alura.screenmatch.model.SeriesDatas;
import br.com.alura.screenmatch.principal.Principal;
import br.com.alura.screenmatch.services.ConsumerAPI;
import br.com.alura.screenmatch.services.DataConvert;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner { //CommandLinRunner é uma implementação para rodar com linhas de comando no run - Realizar a implements e Add methods

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.menu();

	}
}
