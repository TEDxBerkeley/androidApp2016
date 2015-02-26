package org.tedxberkeley.www.tedxberkeley.Speakers;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import org.tedxberkeley.www.tedxberkeley.R;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by maxwolffe on 1/7/15.
 */
public class Speaker {

    private String mName;
    private String mSubTitle;
    private String mDescription;
    private int mPhotoId;
    private Integer mIcon;
    private HashSet<String> mPerformerNames = new HashSet<String>();

    public Speaker(String name, String subTitle, String description, int photoId){
        this.mName = name;
        this.mDescription = description;
        this.mSubTitle = subTitle;
        this.mIcon = performOrSpeaker(name);
        this.mPhotoId = photoId;
    }

    private Integer performOrSpeaker(String name){
        mPerformerNames.add("UC Men's Octet");
        mPerformerNames.add("Cal Bhangra");
        mPerformerNames.add("Viviana Guzmán");
        mPerformerNames.add("Cal Raijin Taiko");
        if (mPerformerNames.contains(name)){
            return R.drawable.music;
        }
        return R.drawable.speaker;
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

    public int getPhoto() { return mPhotoId; }

    public Integer getIcon() {return mIcon;}

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
