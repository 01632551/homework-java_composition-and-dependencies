package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MoviePoster;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerShowFilmsWithArgTest {
    @Test
    public void shouldShowLast10FilmsWithArg() {
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
        PosterManager manager = new PosterManager(10);
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
    public void shouldShowLessLimitWithArgs() {
        // create new films
        MoviePoster invisibleHuman = new MoviePoster(1, "ssh://films/invisibleHuman.png", "Человек-неведимка", "ужасы");
        MoviePoster bloodshot = new MoviePoster(2, "ssh://films/bloodshot.png", "Бладшот", "боевик");
        MoviePoster forwardTo = new MoviePoster(3, "ssh://films/forwardTo.png", "Вперёд", "мультфильм");
        MoviePoster hotelBelgrade = new MoviePoster(4, "ssh://films/hotelBelgrade.png", "Отель <<Белград>>", "комедия");
        MoviePoster gentlemen = new MoviePoster(5, "ssh://films/gentlemen.png", "Джентельмены", "боевик");
        MoviePoster trollsWorldTour = new MoviePoster(6, "ssh://films/trollsWorldTour.png", "Тролли. Мировой тур", "мультфильм");

        // add films
        PosterManager manager = new PosterManager(19);
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
    public void shouldShowAllFilmWithArgs() {
        // create new films
        MoviePoster trollsWorldTour = new MoviePoster(1, "ssh://films/trollsWorldTour.png", "Тролли. Мировой тур", "мультфильм");
        MoviePoster bloodshot = new MoviePoster(2, "ssh://films/bloodshot.png", "Бладшот", "боевик");
        MoviePoster hotelBelgrade = new MoviePoster(3, "ssh://films/hotelBelgrade.png", "Отель <<Белград>>", "комедия");
        MoviePoster gentlemen = new MoviePoster(4, "ssh://films/gentlemen.png", "Джентельмены", "боевик");

        // add films
        PosterManager manager = new PosterManager(4);
        manager.addFilm(trollsWorldTour);
        manager.addFilm(bloodshot);
        manager.addFilm(hotelBelgrade);
        manager.addFilm(gentlemen);

        MoviePoster[] expected = {gentlemen, hotelBelgrade, bloodshot, trollsWorldTour};
        MoviePoster[] actual = manager.showLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow0LastFilms() {
        PosterManager manager = new PosterManager(0);

        MoviePoster trollsWorldTour = new MoviePoster(1, "ssh://films/trollsWorldTour.png", "Тролли. Мировой тур", "мультфильм");
        MoviePoster bloodshot = new MoviePoster(2, "ssh://films/bloodshot.png", "Бладшот", "боевик");
        MoviePoster hotelBelgrade = new MoviePoster(3, "https://films/hotelBelgrade.png", "Отель <<Белград>>", "комедия");
        MoviePoster gentlemen = new MoviePoster(4, "ssh://films/gentlemen.png", "Джентельмены", "боевик");


        MoviePoster[] expected = {};
        MoviePoster[] actual = manager.getAllFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowNotFilms() {
        PosterManager manager = new PosterManager(563);

        MoviePoster[] expected = {};
        MoviePoster[] actual = manager.showLastFilms();

        assertArrayEquals(expected, actual);
    }
}