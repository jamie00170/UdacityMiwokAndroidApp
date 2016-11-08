package com.example.android.miwok;

/**
 * Created by Jamie on 01/11/2016.
 */

public class Word {

    private String englishTranslation;
    private String miwokTranslation;
    private Integer associatedResourceID;
    private Integer associatedSoundID;


    public Word(String englishTranslation, String miwokTranslation, Integer associatedSoundID) {
        this.englishTranslation = englishTranslation;
        this.miwokTranslation = miwokTranslation;
        this.associatedSoundID = associatedSoundID;
    }

    public Word(String englishTranslation, String miwokTranslation, Integer associatedResourceID, Integer associatedSoundID) {
        this.englishTranslation = englishTranslation;
        this.miwokTranslation = miwokTranslation;
        this.associatedResourceID = associatedResourceID;
        this.associatedSoundID = associatedSoundID;
    }

    public String getEnglishTranslation() {
        return englishTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public Integer getAssociatedResourceID() {
        return associatedResourceID;
    }

    public  Integer getAssociatedSoundID(){
        return associatedSoundID;
    }
}
