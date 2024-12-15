import java.util.ArrayList;
import java.util.List;

public abstract class Content {
    public int contentID ;
    public String title ;
    public String director ;
    public String description ;
    public int releaseYears ;
    public boolean isAvailable ;
    public List<String> genres;
    List<Integer> feedbackScores;

    public Content(int contentID, String title, String director, String description, int releaseYears, boolean isAvailable, List<String> genres) {
        this.contentID = contentID;
        this.title = title;
        this.director = director;
        this.description = description;
        this.releaseYears = releaseYears;
        this.isAvailable = isAvailable;
        this.genres = genres;
        this.feedbackScores = new ArrayList<>();
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
        System.out.printf("Average Feedback Score: %.2f\n", getAverageFeedback());
    }
    
    public void leaveFeedback(int score) {
        if (score >= 1 && score <= 5) {
            feedbackScores.add(score);
        } else {
            System.out.println("Feedback score must be between 1 and 5");
        }
    }

    public double getAverageFeedback() {
        if (feedbackScores.isEmpty()) {
            return 0.0;
        }
        int total = feedbackScores.stream().mapToInt(Integer::intValue).sum();
        return total / (feedbackScores.size() * 1.0);
    }
    
    public int getContentID() {
        return contentID;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setDirector(String director) {
        this.director = director;
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

    
}

