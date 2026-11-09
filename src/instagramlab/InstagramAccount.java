package instagramlab;

public class InstagramAccount {
    private final String username;
    private String displayName;
    private String bio;
    private int[] recentPostLikes;
    private boolean isPrivate;
    private static int accountCount = 0;

    public InstagramAccount(String username, String displayName, String bio, int[] likes, boolean isPrivate) {
        this.username = username;
        this.displayName = displayName;
        this.bio = (bio != null && bio.length() <= 150) ? bio : "Default Bio";
        this.isPrivate = isPrivate;
        this.recentPostLikes = new int[3];
        for (int i = 0; i < 3; i++) {
            this.recentPostLikes[i] = (likes[i] >= 0) ? likes[i] : 0;
        }
        accountCount++;
    }
    public InstagramAccount(InstagramAccount other) {
        this.username = other.username;
        this.displayName = other.displayName;
        this.bio = other.bio;
        this.isPrivate = other.isPrivate;
        this.recentPostLikes = other.recentPostLikes; // Shared array reference
        accountCount++;
    }

    // Deep / Flexible Copy Constructor
    public InstagramAccount(InstagramAccount other, boolean deep) {
        this.username = other.username;
        this.displayName = other.displayName;
        this.bio = other.bio;
        this.isPrivate = other.isPrivate;
        if (deep) {
            this.recentPostLikes = new int[other.recentPostLikes.length];
            for (int i = 0; i < other.recentPostLikes.length; i++) {
                this.recentPostLikes[i] = other.recentPostLikes[i];
            }
        } else {
            this.recentPostLikes = other.recentPostLikes;
        }
        accountCount++;
    }

    public String getUsername() { return username; }
    public String getDisplayName() { return displayName; }
    public String getBio() { return bio; }
    public boolean isPrivate() { return isPrivate; }
    public static int getAccountCount() { return accountCount; }

    public void setBio(String bio) {
        if (bio != null && bio.length() <= 150) {
            this.bio = bio;
        } else {
            System.out.println("Bio update rejected: Exceeds maximum 150 character limit.");
        }
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public void updatePostLikes(int index, int likes) {
        if (index >= 0 && index < 3 && likes >= 0) {
            recentPostLikes[index] = likes;
        } else {
            System.out.println("Invalid likes or index.");
        }
    }

    public double calculateAverageLikes() {
        int sum = 0;
        for (int s : recentPostLikes) {
            sum += s;
        }
        return sum / 3.0;
    }

    public void displayProfile() {
        System.out.println(username + " | Bio: " + bio + " | Avg likes: " + calculateAverageLikes());
    }
}