package Content;

import java.util.HashMap;

public class Series extends Content {
    private int totalEpisodes;
    private HashMap<Integer, Integer> episodesEachSeason;

    // Constructor
    public Series() {
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
