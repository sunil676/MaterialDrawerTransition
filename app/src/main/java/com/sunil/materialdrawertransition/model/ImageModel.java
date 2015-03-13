package com.sunil.materialdrawertransition.model;

/**
 * Created by KNS015 on 13-03-2015.
 */
public class ImageModel {

    private String imageurl;
    private String title;

   public ImageModel(String imageurl, String title){
        this.imageurl=imageurl;
        this.title=title;
    }

    public String getImageurl() {
        return imageurl;
    }


    public String getTitle() {
        return title;
    }

}
