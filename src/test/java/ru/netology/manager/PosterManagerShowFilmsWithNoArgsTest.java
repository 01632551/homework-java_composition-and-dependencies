package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MoviePoster;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerShowFilmsWithNoArgsTest {
    @Test
    public void shouldShowLast10Films() {
        // create new films
        MoviePoster invisibleHuman = new MoviePoster(1, "ssh://films/invisibleHuman.png", "Человек-неведимка", "ужасы");
        MoviePoster bloodshot = new MoviePoster(2, "ssh://films/bloodshot.png", "Бладшот", "боевик");
        MoviePoster forwardTo = new MoviePoster(3, "ssh://films/forwardTo.png", "Вперёд", "мультфильм");
        MoviePoster hotelBelgrade = new MoviePoster(4, "ssh://films/hotelBelgrade.png", "Отель <<Белград>>", "комедия");
        MoviePoster gentlemen = new MoviePoster(5, "ssh://films/gentlemen.png", "Джентельмены", "боевик");
        MoviePoster trollsWorldTour = new MoviePoster(6, "ssh://films/trollsWorldTour.png", "Тролли. Мировой тур", "мультфильм");
        MoviePoster numberOne = new MoviePoster(7, "ssh://films/numberOne.png", "Номер один", "комедия");
        MoviePoster moonDrop = new MoviePoster(8, "ssh://films/moonDrop.png", "Падение луны", "фантастика");
        MoviePoster deathOnTheNile = new MoviePoster(9, "ssh://films/deathOnTheNile.png", "Смерть на Ниле", "детектив");
        MoviePoster naughty = new MoviePoster(10, "ssh://films/naughty.png", "Непослушник", "комедия");
        MoviePoster alleyOfNightmares = new MoviePoster(11, "ssh://films/alleyOfNightmares.png", "Аллея кошмаров", "триллер");
        MoviePoster firstComer = new MoviePoster(12, "ssh://films/firstComer.png", "Первый встречный", "мелодрама");
        MoviePoster spiderManNoWayToHome = new MoviePoster(13, "ssh://films/spiderManNoWayToHome.png", "Человек-паук: Нет пути домой", "фэнтези");
        MoviePoster gucciHome = new MoviePoster(14, "ssh://films/gucciHome.png", "Дом Gucci", "триллер");

        // add films
        PosterManager manager = new PosterManager();
        manager.addFilm(invisibleHuman);
        manager.addFilm(bloodshot);
        manager.addFilm(forwardTo);
        manager.addFilm(hotelBelgrade);
        manager.addFilm(gentlemen);
        manager.addFilm(trollsWorldTour);
        manager.addFilm(numberOne);
        manager.addFilm(moonDrop);
        manager.addFilm(deathOnTheNile);
        manager.addFilm(naughty);
        manager.addFilm(alleyOfNightmares);
        manager.addFilm(firstComer);
        manager.addFilm(spiderManNoWayToHome);
        manager.addFilm(gucciHome);

        MoviePoster[] expected = {gucciHome, spiderManNoWayToHome,
                firstComer, alleyOfNightmares,
                naughty, deathOnTheNile,
                moonDrop, numberOne,
                trollsWorldTour, gentlemen};
        MoviePoster[] actual = manager.showLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLessThatLast10FilmsWithNoArgs() {
        // create new films
        MoviePoster invisibleHuman = new MoviePoster(1, "ssh://films/invisibleHuman.png", "Человек-неведимка", "ужасы");
        MoviePoster bloodshot = new MoviePoster(2, "ssh://films/bloodshot.png", "Бладшот", "боевик");
        MoviePoster forwardTo = new MoviePoster(3, "ssh://films/forwardTo.png", "Вперёд", "мультфильм");
        MoviePoster hotelBelgrade = new MoviePoster(4, "ssh://films/hotelBelgrade.png", "Отель <<Белград>>", "комедия");
        MoviePoster gentlemen = new MoviePoster(5, "ssh://films/gentlemen.png", "Джентельмены", "боевик");
        MoviePoster trollsWorldTour = new MoviePoster(6, "ssh://films/trollsWorldTour.png", "Тролли. Мировой тур", "мультфильм");

        // add films
        PosterManager manager = new PosterManager();
        manager.addFilm(invisibleHuman);
        manager.addFilm(bloodshot);
        manager.addFilm(forwardTo);
        manager.addFilm(hotelBelgrade);
        manager.addFilm(gentlemen);
        manager.addFilm(trollsWorldTour);

        MoviePoster[] expected = {trollsWorldTour, gentlemen,
                hotelBelgrade, forwardTo,
                bloodshot, invisibleHuman};
        MoviePoster[] actual = manager.showLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow1FilmWithNoArgs() {
        // create new films
        MoviePoster trollsWorldTour = new MoviePoster(1, "ssh://films/trollsWorldTour.png", "Тролли. Мировой тур", "мультфильм");

        // add films
        PosterManager manager = new PosterManager();
        manager.addFilm(trollsWorldTour);

        MoviePoster[] expected = {trollsWorldTour};
        MoviePoster[] actual = manager.showLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowFromEmptyArray() {
        // create empty film
        PosterManager manager = new PosterManager();

        MoviePoster[] expected = {};
        MoviePoster[] actual = manager.showLastFilms();

        assertArrayEquals(expected, actual);
    }
}
