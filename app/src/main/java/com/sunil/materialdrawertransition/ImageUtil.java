package com.sunil.materialdrawertransition;

import com.sunil.materialdrawertransition.model.ImageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KNS015 on 13-03-2015.
 */
public class ImageUtil {

    List<ImageModel> list=new ArrayList<>();

    String imagearray[]={

            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/flying_in_the_light.jpg",
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/caterpillar.jpg",
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/look_me_in_the_eye.jpg",
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/flamingo.jpg",
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/rainbow.jpg",
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/over_there.jpg",
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/jelly_fish_2.jpg",
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/lone_pine_sunset.jpg"
    };
    String title[]={
            "flying_in_the_light",
            "caterpillar",
            "look_me_in_the_eye",
            "flamingo",
            "rainbow",
            "over_there",
            "jelly_fish_2",
            "lone_pine_sunset"
    };

    public  List<ImageModel> getimagelist(){

        for (int i=0; i< imagearray.length; i++){

            String imageurl=imagearray[i];
            String titlename=title[i];
            ImageModel model=new ImageModel(imageurl, titlename);
            list.add(model);
        }

        return list;
    }
}
