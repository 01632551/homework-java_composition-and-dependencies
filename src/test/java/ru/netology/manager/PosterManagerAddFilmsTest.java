package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MoviePoster;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerAddFilmsTest {
    @Test
    public void shouldAddNewFilm() {
        // create new films
        MoviePoster invisibleHuman = new MoviePoster(1, "ssh://films/invisibleHuman.png", "Человек-неведимка", "ужасы");
        MoviePoster bloodshot = new MoviePoster(2, "ssh://films/bloodshot.png", "Бладшот", "боевик");
        MoviePoster forwardTo = new MoviePoster(3, "ssh://films/forwardTo.png", "Вперёд", "мультфильм");
        MoviePoster hotelBelgrade = new MoviePoster(4, "ssh://films/hotelBelgrade.png", "Отель <<Белград>>", "комедия");
        MoviePoster gentlemen = new MoviePoster(5, "ssh://films/gentlemen.png", "Джентельмены", "боевик");
        MoviePoster trollsWorldTour = new MoviePoster(6, "ssh://films/trollsWorldTour.png", "Тролли. Мировой тур", "мультфильм");
        MoviePoster numberOne = new MoviePoster(7, "ssh://films/numberOne.png", "Номер один", "комедия");

        // add films
        PosterManager manager = new PosterManager();
        manager.addFilm(invisibleHuman);
        manager.addFilm(bloodshot);
        manager.addFilm(forwardTo);
        manager.addFilm(hotelBelgrade);
        manager.addFilm(gentlemen);
        manager.addFilm(trollsWorldTour);
        manager.addFilm(numberOne);

        MoviePoster[] expected = {invisibleHuman, bloodshot, forwardTo, hotelBelgrade, gentlemen, trollsWorldTour, numberOne};
        MoviePoster[] actual = manager.getAllFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNoFilm() {
        // create empty film
        PosterManager manager = new PosterManager();

        MoviePoster[] expected = {};
        MoviePoster[] actual = manager.getAllFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneFilm() {
        // create one new film
        MoviePoster humanAnger = new MoviePoster(1, "http://films/humanAnger.png", "Гнев человеческий", "боевик");

        // add film
        PosterManager manager = new PosterManager();
        manager.addFilm(humanAnger);

        MoviePoster[] expected = {humanAnger};
        MoviePoster[] actual = manager.getAllFilms();

        assertArrayEquals(expected, actual);
    }
}
