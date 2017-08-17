package com.reacheaugene.news_test;

/**
 * Created by Eaugene on 24/07/2017.
 */

public class newsgt {
    private String inews;
    private String imageID;
    private String desc;
    private String url;

    public newsgt(String inews, String imageID, String desc, String url) {
        this.inews = inews;
        this.imageID = imageID;
        this.desc = desc;
        this.url = url;
    }

    public String getInews() {
        return inews;
    }

    public String getImageID() {
        return imageID;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }
}
