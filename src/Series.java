import java.util.HashMap;
import java.util.List;

public class Series extends Content {
    private int totalEpisodes;
    private HashMap<Integer, Integer> episodesEachSeason;

    // Constructor
    public Series(int contentID, String title, String director, String description, int releaseYears, boolean isAvailable,
                  List<String> genre, int totalEpisodes, HashMap<Integer, Integer> episodesEachSeason  ) {
        super(contentID, title, director, description, releaseYears, isAvailable, genre);
        this.episodesEachSeason = new HashMap<>();
        this.totalEpisodes = 0;
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public HashMap<Integer, Integer> getEpisodesEachSeason() {
        return episodesEachSeason;
    }

    public void setEpisodesEachSeason(HashMap<Integer, Integer> episodesEachSeason) {
        this.episodesEachSeason = episodesEachSeason;
        this.totalEpisodes = calculateTotalEpisodes(); // Automatically update totalEpisodes
    }

    // Calculate total episodes from episodesEachSeason
    private int calculateTotalEpisodes() {
        return episodesEachSeason.values().stream().mapToInt(Integer::intValue).sum();
    }

    // Add a season with episode count
    public void addSeason(int seasonNumber, int episodeCount) {
        episodesEachSeason.put(seasonNumber, episodeCount);
        this.totalEpisodes = calculateTotalEpisodes(); // Update totalEpisodes
    }
}
