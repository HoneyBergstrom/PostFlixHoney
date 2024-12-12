

import java.util.ArrayList;
import java.util.List;

public class ContentManager {
    private static ContentManager instance;
    private List<Content> inventory;
    private List<User> users;


    private ContentManager() {
        this.inventory = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public static ContentManager getInstance() {
        if (instance == null) {
            instance = new ContentManager();
        }
        return instance;
    }

    public List<Content> getInventory() {
        return inventory;
    }
    public List<Content> readFromFile(Path readDataFromFile) {
        List<Content> contents = new ArrayList<>();

        try(Scanner scanner = new Scanner(readDataFromFile)) {
                while(scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    int contentID = Integer.parseInt(parts[0]);
                    String contentType = parts[1];
                    String title = parts[2];
                    String director = parts[3];
                    String description = parts[4];
                    List<String> genre = Arrays.asList(parts[5].split(";"));
                    int releaseYear = Integer.parseInt(parts[6]);
                    boolean isAvailable = Boolean.parseBoolean(parts[7]);

                    if(contentType.equals("Movie")){
                        int runtTime = Integer.parseInt(parts[8]);
                        boolean hasCreditScenes = Boolean.parseBoolean(parts[9]);
                        Movie movie = new Movie(contentID, title, director, description, releaseYear, isAvailable, genre, runtTime, hasCreditScenes);
                        contents.add(movie);
                        //Content content = contents.get(0);
                        //Movie temp = (Movie)content;
                        //temp.getRunTime();
                    }
                    else if(contentType.equals("Series")){
                        int totalEpisodes = Integer.parseInt(parts[8]);
                        String[] episodeEachSeason = parts[9].split(";");

                        HashMap<Integer, Integer> episodeEachSeasonMap = new HashMap();
                        for (String s : episodeEachSeason) {
                            String[] episodeAndSeason = s.split("-");
                            int episode = Integer.parseInt(episodeAndSeason[0]);
                            int season = Integer.parseInt(episodeAndSeason[1]);
                            episodeEachSeasonMap.put(episode, season);
                        }

                        Series series = new Series(contentID, title, director, description, releaseYear, isAvailable, genre, totalEpisodes, episodeEachSeasonMap);
                        contents.add(series);
                    }
                }
        }
        catch (FileNotFoundException e) {
            System.out.println("File could not be found");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Could not read file");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
            System.exit(0);
        }
        return contents;
    }

    public void writeToFile(String fileName, List<Content> contents) {
        try(BufferedWriter wr = new BufferedWriter(new FileWriter(fileName, true))) {

            for(Content c : contents) {
                wr.write(c.getContentID() + ", " + c.getTitle() + ", " + c.isAvailable());
                wr.newLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
            System.exit(0);
        }
    }


    public void addContent(Content content) {
        inventory.add(content);
    }


    public void addUser(User user) {
        users.add(user);
    }


    public void processOrder(Content content) {
        if (inventory.contains(content) && content.isAvailable()) {
            content.setAvailable(false);
            System.out.println("Ordern har behandlats: " + content.getTitle());
        } else {
            System.out.println("Innehållet är inte tillgängligt.");
        }
    }


    public void processReturn(Content content) {
        if (inventory.contains(content) && !content.isAvailable()) {
            content.setAvailable(true);
            System.out.println("Returen har behandlats: " + content.getTitle());
        } else {
            System.out.println("Returen kunde inte behandlas.");
        }
    }


    public void showInventory() {
        System.out.println("Inventory:");
        for (Content content : inventory) {
            System.out.println("- " + content.getTitle() + " (Tillgänglig: " + content.isAvailable() + ")");
        }
    }
}
//test
