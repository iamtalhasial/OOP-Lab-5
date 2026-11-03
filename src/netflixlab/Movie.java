package netflixlab;

public class Movie {
    private final String movieId;
    private String title;
    private int durationMinutes;
    private int progressMinutes;
    private int[] sessionMinutes;
    private static int movieCount = 0;

    public Movie(String movieId, String title, int durationMinutes, int progressMinutes, int[] sessions) {
        this.movieId = movieId;
        this.title = title;
        this.durationMinutes = durationMinutes;
        this.progressMinutes = progressMinutes;
        this.sessionMinutes = new int[3];
        for (int i = 0; i < 3; i++) {
            this.sessionMinutes[i] = sessions[i];
        }
        movieCount++;
    }

    public int getProgressMinutes() { return progressMinutes; }

    public void pauseAt(int minutes) {
        if (minutes >= 0 && minutes <= durationMinutes) {
            progressMinutes = minutes;
            System.out.println("Paused " + title + " at " + minutes + " min.");
        } else {
            System.out.println("Invalid viewing position.");
        }
    }

    public void resume() {
        System.out.println("Resuming " + title + " from " + progressMinutes + " min.");
    }

    public int calculateTotalWatchedMinutes() {
        int sum = 0;
        for (int s : sessionMinutes) {
            sum += s;
        }
        return sum;
    }

    public void displayDetails() {
        System.out.println(title + " | Progress: " + progressMinutes + "/" + durationMinutes + " | Session minutes: " + calculateTotalWatchedMinutes());
    }

    public static int getMovieCount() { return movieCount; }
}