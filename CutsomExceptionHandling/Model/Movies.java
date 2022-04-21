package CutsomExceptionHandling.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movies {

    @Id
    private String movieName;
    private String heroName;
    private String directorName;

    Movies(){}

    public Movies(String movieName, String heroName, String directorName)
    {
        super();
        this.movieName=movieName;
        this.heroName=heroName;
        this.directorName=directorName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String collection) {
        directorName = collection;
    }
}
