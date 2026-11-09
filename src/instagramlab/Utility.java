package instagramlab;

public class Utility {
    public static void main(String[] args) {
        InstagramAccount sara = new InstagramAccount("@sara.cs", "Sara", "CS student", new int[]{40, 60, 80}, false);
        InstagramAccount areeba = new InstagramAccount("@areeba.tech", "Areeba", "Tech creator", new int[]{20, 30, 40}, true);

        InstagramAccount shallowSara = new InstagramAccount(sara);
        InstagramAccount deepSara = new InstagramAccount(sara, true);

        sara.updatePostLikes(0, 100);

        System.out.println("@sara.cs average after update: " + sara.calculateAverageLikes());
        System.out.println("Shallow average: " + shallowSara.calculateAverageLikes() + " | Deep average: " + deepSara.calculateAverageLikes());

        InstagramAccount winner = sara.getMoreEngaging(areeba);
        System.out.println("More engaging: " + winner.getUsername());

        sara.copyBioFrom(areeba);
        System.out.println("Sara bio after copy: " + sara.getBio());

        sara.updatePostLikes(1, -5); // Invalid test

        System.out.println("InstagramAccount objects: " + InstagramAccount.getAccountCount());

        HashtagTrend trend = new HashtagTrend("H-01", "#CampusLife", 5);
        trend.recordUse();
        trend.displayTrend();
    }
}