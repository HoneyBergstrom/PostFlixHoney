import java.util.List;

public class Movie extends Content {
    private int runTime;
    private boolean hasCreditScenes;

    // Constructor
    public Movie(int contentID, String title, String director, String description, int releaseYears,
                 boolean isAvailable, List<String> genre, int runTime, boolean hasCreditScenes) {
        super(contentID, title, director, description, releaseYears, isAvailable, genre);
        this.runTime = runTime;
        this.hasCreditScenes = hasCreditScenes;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public boolean isHasCreditScenes() {
        return hasCreditScenes;
    }

    public void setHasCreditScenes(boolean hasCreditScenes) {
        this.hasCreditScenes = hasCreditScenes;
    }

    @Override
    public String toString() {
        String genreString = String.join(", ", genres);
        return this.getClass().getName() + " - Title: " + title + ", Director: " + director + ", Genres: " + genreString;
    }
}