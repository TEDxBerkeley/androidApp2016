package org.tedxberkeley.www.tedxberkeley2016.Speakers;


import org.tedxberkeley.www.tedxberkeley2016.R;

import java.util.Arrays;
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
    public static final String[] PERFORMER_NAMES = new String[] { "UC Berkeley Azaad",
            "Rob Hotchkiss",
            "Celli@Berkeley",
            "OSA Chamber Choir",
            "Rose Gelfand",
            "Molly Gardner",
            "Isa Ansari",
            "Sonia Rao"};
    private static final Set<String> PERFORMER_SET = new HashSet<>(Arrays.asList(PERFORMER_NAMES));


    public Speaker(String name, String subTitle, String description, int photoId){
        this.mName = name;
        this.mDescription = description;
        this.mSubTitle = subTitle;
        this.mIcon = performOrSpeaker(name);
        this.mPhotoId = photoId;
    }

    private Integer performOrSpeaker(String name){
        if (PERFORMER_SET.contains(name)){
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
