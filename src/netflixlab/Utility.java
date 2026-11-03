package netflixlab;

public class Utility {
    public static void main(String[] args) {
        Movie[] movies = new Movie[2];
        movies[0] = new Movie("M-101", "Interstellar", 169, 0, new int[]{20, 42, 10});
        movies[1] = new Movie("M-102", "Inception", 148, 0, new int[]{30, 20, 15});

        for (Movie m : movies) {
            m.displayDetails();
        }

        movies[0].pauseAt(42);
        movies[1].pauseAt(300);

        Movie alias = movies[0];
        System.out.println("Alias progress: " + alias.getProgressMinutes());

        System.out.println("Movie objects created: " + Movie.getMovieCount());

        SubscriptionPlan plan = new SubscriptionPlan("P-1", "Standard", 1200.0);
        plan.displayPlan();
    }
}