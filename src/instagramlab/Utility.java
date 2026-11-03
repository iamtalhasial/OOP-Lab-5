package instagramlab;

public class Utility {
    public static void main(String[] args) {
        InstagramAccount[] accounts = new InstagramAccount[2];
        accounts[0] = new InstagramAccount("@sara.cs", "Sara", "CS student", new int[]{40, 60, 80}, false);
        accounts[1] = new InstagramAccount("@areeba.tech", "Areeba", "Tech creator", new int[]{20, 30, 40}, true);

        for (InstagramAccount acc : accounts) {
            acc.displayProfile();
        }

        InstagramAccount alias = accounts[0];
        alias.setBio("Coding daily");
        System.out.println("After alias update: " + accounts[0].getUsername() + " | Bio: " + accounts[0].getBio());

        accounts[0].updatePostLikes(0, -15);

        System.out.println("Total Instagram accounts: " + InstagramAccount.getAccountCount());

        HashtagTrend trend = new HashtagTrend("H-01", "#CampusLife", 5);
        trend.recordUse();
        trend.displayTrend();
    }
}