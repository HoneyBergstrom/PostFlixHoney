public class Movie extends Content {
    private int runTime;
    private boolean hasCreditScenes;

    // Constructor
    public Movie(int runTime, boolean hasCreditScenes) {
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
}