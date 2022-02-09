package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.MoviePoster;

@NoArgsConstructor
public class PosterManager {
    private MoviePoster[] films = new MoviePoster[0];
    int limitLengthForShow = 10;

    public PosterManager(int limitLengthForShow){
        this.limitLengthForShow = limitLengthForShow;
    }

    public void addFilm(MoviePoster film) {
        // create new array more per 1
        int length = films.length + 1;
        MoviePoster[] tmp = new MoviePoster[length];

        // copy elements one by one
        System.arraycopy(films, 0, tmp, 0, films.length);

        // add last element in array
        int lastFilmIndex = tmp.length - 1;
        tmp[lastFilmIndex] = film;

        // change elements
        films = tmp;
    }

    public MoviePoster[] getAllFilms(){
        return films;
    }

    public MoviePoster[] showLastFilms(){
        int resultLength;
        if (limitLengthForShow == 10 && films.length < 10) {
            resultLength = films.length;
        }else{
            resultLength = limitLengthForShow;
        }

        MoviePoster[] result = new MoviePoster[resultLength];
        for (int i = 0; i < resultLength; i ++){
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
