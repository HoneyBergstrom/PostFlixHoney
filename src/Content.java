import java.util.List;

public abstract class Content {
    public int contentID ;
    public String title ;
    public String director ;
    public String description ;
    public int releaseYears ;
    public boolean isAvailable ;
    public List<String> genres;

    public Content(int contentID, String title, String director, String description, int releaseYears, boolean isAvailable, List<String> genres) {
        this.contentID = contentID;
        this.title = title;
        this.director = director;
        this.description = description;
        this.releaseYears = releaseYears;
        this.isAvailable = isAvailable;
        this.genres = genres;
    }

    public abstract void printFullDetails();

    protected void printBasicDetails() {
        System.out.println("Content ID: " + contentID);
        System.out.println("Title: " + title);
        System.out.println("Director: " + director);
        System.out.println("Description: " + description);
        System.out.println("Release Year: " + releaseYears);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("Genres: " + (genres.isEmpty() ? "None" : String.join(", ", genres)));
    }

    public int getContentID() {
        return contentID;
    }

    public void setContentID(int contentID) {
        this.contentID = contentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public void printFullContent() {
    }
}

