import java.util.HashMap;
import java.util.List;

public class Series extends Content {
    private int totalEpisodes;
    private HashMap<Integer, Integer> episodesEachSeason;

    // Constructor
    public Series(int contentID, String title, String director, String description, int releaseYears, boolean isAvailable,
                  List<String> genre, int totalEpisodes, HashMap<Integer, Integer> episodesEachSeason  ) {
        super(contentID, title, director, description, releaseYears, isAvailable, genre);
        this.episodesEachSeason = episodesEachSeason;
        this.totalEpisodes = totalEpisodes;
    }

    
    
    @Override
    public String toString() {
        String genreString = String.join(", ", genres);
        return "ID: " + contentId + " - " + this.getClass().getName() + " - Title: " + title + ", Director: " + director + ", Genres: " + genreString + "Episodes: " + totalEpisodes;
    }

    @Override
    public void printFullDetails() {
        System.out.println("\n--- Series Details ---");
        printBasicDetails();
        System.out.println("Total Episodes: " + totalEpisodes);
        System.out.println("Episodes Each Season: ");
        if (episodesEachSeason.isEmpty()) {
            System.out.println("  No data available.");
        } else {
            for (int season : episodesEachSeason.keySet()) {
                System.out.println("  Season " + season + ": " + episodesEachSeason.get(season) + " episodes");
            }
        }
    }
}
