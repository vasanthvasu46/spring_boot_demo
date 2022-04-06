package CutsomExceptionHandling.Service;

import CutsomExceptionHandling.CustomException.BusinessException;
import CutsomExceptionHandling.Model.Movies;
import CutsomExceptionHandling.Repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movies> getAllMovies()
    {
        List<Movies> moviesList =new ArrayList<>();
        try {
            moviesRepository.findAll().forEach(moviesList::add);
        }
        catch(Exception e)
        {
            throw new BusinessException("601","Something went wrong in Service Layer "+e.getMessage());
        }
        if(moviesList.isEmpty())
        {
            throw new BusinessException("602","There is no record to display");
        }
        return moviesList;
    }

    public Movies getByMovieName(String movieName)
    {
        try {
            return moviesRepository.findById(movieName).get();
        }
        catch(NoSuchElementException e)
        {
            throw new BusinessException("603","No record with the given movie name is found in DB. Please check the movie name");
        }
        catch(IllegalArgumentException e)
        {
            throw new BusinessException("604","Check the movie name.");
        }
    }

    public Movies addMovie(Movies movie)
    {
        if(movie.getMovieName().isEmpty() || movie.getMovieName().length()==0)
        {
            throw new BusinessException("605","Enter a valid movie name. It cannot new null");
        }
        if(movie.getHeroName().isEmpty() || movie.getHeroName().length()==0)
        {
            throw new BusinessException("605","Enter a valid hero name. It cannot new null");
        }
        if(movie.getDirectorName().isEmpty() || movie.getDirectorName().length()==0)
        {
            throw new BusinessException("605","Enter a valid director name. It cannot new null");
        }
        try{
            moviesRepository.save(movie);
            return movie;
        }
        catch(IllegalArgumentException e)
        {
            throw new BusinessException("606","Cannot give null values as input");
        }
        catch(Exception e)
        {
            throw new BusinessException("607","Something went wrong in Service Layer "+e.getMessage());
        }
    }

    public Movies updateMovie(Movies movie, String movieName)
    {
        if(movie.getMovieName().isEmpty() || movie.getMovieName().length()==0)
        {
            throw new BusinessException("605","Enter a valid movie name. It cannot new null");
        }
        if(movie.getHeroName().isEmpty() || movie.getHeroName().length()==0)
        {
            throw new BusinessException("605","Enter a valid hero name. It cannot new null");
        }
        if(movie.getDirectorName().isEmpty() || movie.getDirectorName().length()==0)
        {
            throw new BusinessException("605","Enter a valid director name. It cannot new null");
        }
        try{
            moviesRepository.save(movie);
            return movie;
        }
        catch(IllegalArgumentException e)
        {
            throw new BusinessException("606","Cannot give null values as input");
        }
        catch(Exception e)
        {
            throw new BusinessException("607","Something went wrong in Service Layer "+e.getMessage());
        }


    }

    public void deleteMovie(String movieName)
    {
        try{
            moviesRepository.deleteById(movieName);
        }
        catch(NoSuchElementException e)
        {
            throw new BusinessException("608","Check your movie name, the given movie name is not in the DB");
        }
        catch (IllegalArgumentException e){
            throw new BusinessException("609","Enter a valid movie name, the given movie name is null");
        }

    }
}
