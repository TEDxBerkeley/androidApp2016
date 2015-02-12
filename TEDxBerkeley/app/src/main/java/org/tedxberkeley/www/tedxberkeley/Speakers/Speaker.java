package org.tedxberkeley.www.tedxberkeley.Speakers;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import org.tedxberkeley.www.tedxberkeley.R;

import java.util.Set;

/**
 * Created by maxwolffe on 1/7/15.
 */
public class Speaker {

    private String mName;
    private String mSubTitle;
    private String mDescription;
    private Bitmap mPhoto;
    private Integer mIcon;
    private Set<String> mPerformerNames;

    public Speaker(String name, String subTitle, String description){
        this.mName = name;
        this.mDescription = description;
        this.mSubTitle = subTitle;
        this.mIcon = performOrSpeaker(name);
    }

    private Integer performOrSpeaker(String name){
        if (mPerformerNames.contains(name)){
            return R.drawable.icon_guitar;
        }
        return R.drawable.icon_speaker;
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
