package instagramlab;

public class HashtagTrend {
    private final String trendCode;
    private String hashtag;
    private int useCount;

    public HashtagTrend(String trendCode, String hashtag, int useCount) {
        this.trendCode = trendCode;
        this.hashtag = hashtag;
        this.useCount = (useCount >= 0) ? useCount : 0;
    }

    public void recordUse() {
        this.useCount++;
    }

    public void displayTrend() {
        System.out.println(trendCode + " | " + hashtag + " | Uses: " + useCount);
    }

}