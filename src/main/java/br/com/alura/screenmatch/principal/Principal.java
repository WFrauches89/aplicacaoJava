package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.*;
import br.com.alura.screenmatch.services.ConsumerAPI;
import br.com.alura.screenmatch.services.DataConvert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

private Scanner getInsert = new Scanner(System.in);
private final String ADRESS = "https://www.omdbapi.com/?t=";
private final String API_KEY = "&apikey=c9d230be";
private ConsumerAPI consumerAPI = new ConsumerAPI();
private DataConvert dataConvert = new DataConvert();
private List<SeriesDatas> seriesDatas = new ArrayList<>();



public void menu() {
    var choice = -1;
    while (choice != 0) {

        var menu = """
                ********************** Opções **********************
                1 - Buscar séries
                2 - Buscar episódios
                3 - Listar séries pesquisadas                
                0 - Sair                               
                """;

        System.out.println(menu);
        System.out.println("Escolha sua opção: ");
        choice = getInsert.nextInt();
        getInsert.nextLine();

        switch (choice) {
            case 1:
                buscarSerieWeb();
                break;
            case 2:
                buscarEpisodioPorSerie();
                break;
            case 3:
                serieList();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
}

private void buscarSerieWeb() {
        SeriesDatas sDatas = getSeriesDatas();
        seriesDatas.add(sDatas);
        System.out.println(sDatas);
        }

private void serieList() {
        List<Series> series = new ArrayList<>();
        series= seriesDatas.stream()
                .map(s -> new Series(s))
                .collect(Collectors.toList());
        series.stream()
                .sorted(Comparator.comparing(Series::getGenre))
                .forEach(System.out::println);
}


private SeriesDatas getSeriesDatas() {
        System.out.println("Digite o nome da série desejada: ");
        var serieName = getInsert.nextLine();
        var json = consumerAPI.getDados(ADRESS + serieName.replace(" ", "+") + API_KEY);
        SeriesDatas seriesDatas = dataConvert.obterDatas(json, SeriesDatas.class);
        return seriesDatas;
        }

private void buscarEpisodioPorSerie(){
        SeriesDatas seriesDatas = getSeriesDatas();
        List<SeasonDatas> seasonsDataList =new ArrayList<>();

        for (int i = 1; i <= seriesDatas.totalSeason(); i++) {
        var json = consumerAPI.getDados(ADRESS + seriesDatas.title().replace(" ", "+") + "&season=" + i + API_KEY);
        SeasonDatas seasonDatas = dataConvert.obterDatas(json, SeasonDatas.class);
        seasonsDataList.add(seasonDatas);
        }
        seasonsDataList.forEach(System.out::println);
        }





}
