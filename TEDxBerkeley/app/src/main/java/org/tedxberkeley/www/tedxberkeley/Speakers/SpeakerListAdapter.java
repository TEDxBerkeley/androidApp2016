package org.tedxberkeley.www.tedxberkeley.Speakers;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.tedxberkeley.www.tedxberkeley.R;

import java.util.ArrayList;

/**
 * Created by maxwolffe on 1/7/15.
 */
public class SpeakerListAdapter extends ArrayAdapter<Speaker> {
    Context mContext;
    int mLayoutResourceId;
    ArrayList<Speaker> mData = null;

    public SpeakerListAdapter(Context context, int layoutResourceId, ArrayList<Speaker> data){
        super(context, layoutResourceId, data);
        this.mContext = context;
        this.mLayoutResourceId = layoutResourceId;
        this.mData = data;
    }

    @Override
    public View getView(int position,  View convertview, ViewGroup parent){
        View row = convertview;
        SpeakerHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);

            holder = new SpeakerHolder();
            holder.name = (TextView)row.findViewById(R.id.name);
            holder.subTitle = (TextView)row.findViewById(R.id.subtitle);
            holder.photo = (ImageView) row.findViewById(R.id.talk_icon);

            row.setTag(holder);
        }
        else
        {
            holder = (SpeakerHolder)row.getTag();
        }
        Speaker speaker = mData.get(position);
        holder.name.setText(speaker.getName());
        holder.subTitle.setText(speaker.getSubTitle());
        holder.photo.setImageResource(speaker.getIcon());

        return row;
    }

    static class SpeakerHolder{
        TextView name;
        TextView subTitle;
        ImageView photo;
    }
}
