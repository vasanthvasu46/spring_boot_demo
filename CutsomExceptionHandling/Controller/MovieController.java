package CutsomExceptionHandling.Controller;

import CutsomExceptionHandling.CustomException.BusinessException;
import CutsomExceptionHandling.CustomException.ControllerException;
import CutsomExceptionHandling.Model.Movies;
import CutsomExceptionHandling.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MovieController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping("/Movies")
    public ResponseEntity<?> getMovies()
    {
        try {
            List<Movies> movies = moviesService.getAllMovies();
            return new ResponseEntity<List<Movies>>(movies, HttpStatus.OK);
        }
        catch(BusinessException e)
        {
            ControllerException exp = null;
            exp = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(exp,HttpStatus.BAD_REQUEST);
        }
        catch(Exception e){
            ControllerException exp = new ControllerException("610","Something went wrong in the controller while get the movie details "+e.getMessage());
            return new ResponseEntity<ControllerException>(exp,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Movies/{movieName}")
    public ResponseEntity<?> getSpecificMovie(@PathVariable String movieName)
    {
        try {
            Movies movie = moviesService.getByMovieName(movieName);
            return new ResponseEntity<Movies>(movie, HttpStatus.OK);
        }
        catch (BusinessException e){
            ControllerException exp = null;
            exp = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(exp,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ControllerException exp = new ControllerException("611","Something went wrong in the controller while get the movie details "+e.getMessage());
            return new ResponseEntity<ControllerException>(exp,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value="/Movies")
    public ResponseEntity<?> addMovie(@RequestBody Movies movie)
    {
        try {
            Movies updateMovie = moviesService.addMovie(movie);
            return new ResponseEntity<Movies>(updateMovie, HttpStatus.OK);
        }
        catch (BusinessException e){
            ControllerException exp=null;
            exp = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(exp,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ControllerException exp = new ControllerException("612","Something went wrong in the controller while adding movie to DB");
            return new ResponseEntity<ControllerException>(exp,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/Movies/{movieName}")
    public ResponseEntity<?> updateMovie(@RequestBody Movies movie, @PathVariable String movieName)
    {
        try {
            Movies updateMovie = moviesService.updateMovie(movie, movieName);
            return new ResponseEntity<Movies>(updateMovie, HttpStatus.OK);
        }
        catch (BusinessException e){
            ControllerException exp=null;
            exp = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(exp,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ControllerException exp = new ControllerException("612","Something went wrong in the controller while updating movie in DB");
            return new ResponseEntity<ControllerException>(exp,HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/Movies/{movieName}")
    public ResponseEntity<?> deleteMovie(@PathVariable String movieName)
    {
        try {
            moviesService.deleteMovie(movieName);
            return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
        }
        catch (BusinessException e){
            ControllerException exp=null;
            exp = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(exp,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ControllerException exp = new ControllerException("613","Something went in the controller while deleting employee details");
            return new ResponseEntity<ControllerException>(exp,HttpStatus.BAD_REQUEST);
        }
    }
}
