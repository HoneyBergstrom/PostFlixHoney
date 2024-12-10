package Content;

import java.util.List;

public abstract class Content {
    private int contentID ;
    private String titel ;
    private String director ;
    private String description ;
    private int releaseYears ;
    private boolean isAvailable ;
    private List<String> genre ;

    public int getContentID() {
        return contentID;
    }

    public void setContentID(int contentID) {
        this.contentID = contentID;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYears() {
        return releaseYears;
    }

    public void setReleaseYears(int releaseYears) {
        this.releaseYears = releaseYears;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }
}

