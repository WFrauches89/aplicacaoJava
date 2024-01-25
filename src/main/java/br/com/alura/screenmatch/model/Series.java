package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.services.ConsultaChatGPT;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Optional;
import java.util.OptionalDouble;

public class Series {

    private String title;
    private Integer totalSeason;
    private Double rating;
    private Category genre;
    private String actors;
    private String poster;
    private final String plot;

    public Series(SeriesDatas seriesDatas) {
        this.title = seriesDatas.title();
        this.totalSeason = seriesDatas.totalSeason();
        this.rating = OptionalDouble.of(Double.valueOf(seriesDatas.rating())).orElse(0.0);
        this.genre = Category.fromString(seriesDatas.genre().split(",")[0].trim());
        this.actors = seriesDatas.actors();
        this.poster = seriesDatas.poster();
        this.plot = seriesDatas.plot();
//        this.plot = ConsultaChatGPT.obterTraducao(seriesDatas.plot()).trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalSeason() {
        return totalSeason;
    }

    public void setTotalSeason(Integer totalSeason) {
        this.totalSeason = totalSeason;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Category getGenre() {
        return genre;
    }

    public void setGenre(Category genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPlot() {
        return plot;
    }

    @Override
    public String toString() {
        return
                "genre=" + genre +
                ", title='" + title + '\'' +
                ", totalSeason=" + totalSeason +
                ", rating=" + rating +
                ", actors='" + actors + '\'' +
                ", poster='" + poster + '\'' +
                ", plot='" + plot + '\'';
    }
}
