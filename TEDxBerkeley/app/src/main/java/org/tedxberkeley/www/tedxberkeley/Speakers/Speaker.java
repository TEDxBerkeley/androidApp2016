package org.tedxberkeley.www.tedxberkeley.Speakers;

import android.graphics.Bitmap;

/**
 * Created by maxwolffe on 1/7/15.
 */
public class Speaker {

    private String mName;
    private String mSubTitle;
    private String mDescription;
    private Bitmap mPhoto;

    public Speaker(String name, String subTitle, String description){
        this.mName = name;
        this.mDescription = description;
        this.mSubTitle = subTitle;
    }

    public String getName(){
        return mName;
    }

    public String getSubTitle(){
        return mSubTitle;
    }

    public String getDescription(){
        return mDescription;
    }

    public void setName(String name){
        mName = name;
    }

    public void setSubTitle(String subTitle){
        mSubTitle = subTitle;
    }

    public void setDescription(String description){
        mDescription = description;
    }

}
