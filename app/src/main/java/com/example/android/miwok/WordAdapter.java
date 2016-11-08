package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jamie on 01/11/2016.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int backgroundColour;

    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundColour){
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super (context, 0, words);
        this.backgroundColour = backgroundColour;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        // Check if the existing view is being reused i.e is coming from the scarp views otherwise
        // inflate it
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView englishWordTextView = (TextView) listItemView.findViewById(R.id.english_text);
        englishWordTextView.setText(currentWord.getEnglishTranslation());

        TextView miwokWordTextView = (TextView) listItemView.findViewById(R.id.miwok_text);
        miwokWordTextView.setText(currentWord.getMiwokTranslation());

        ImageView associatedImage = (ImageView) listItemView.findViewById(R.id.associated_image);

        if (currentWord.getAssociatedResourceID() != null){
            associatedImage.setImageResource(currentWord.getAssociatedResourceID());
            // Since views get recycled
            associatedImage.setVisibility(View.VISIBLE);
        }else{
            associatedImage.setVisibility(View.GONE);
        }

        // Get the linear layout that contains the text views
        RelativeLayout text_container = (RelativeLayout) listItemView.findViewById(R.id.rel_layout);
        // Then set the background colour
        int colour = ContextCompat.getColor(getContext(), backgroundColour);
        text_container.setBackgroundColor(colour);

        return listItemView;
    }


}
