package com.udacity.anton.popularmovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.udacity.anton.popularmovies.data.VideoObject;

/**
 * Created by anton on 07/02/17.
 */

public class VideoAdapter extends ArrayAdapter<VideoObject> {

    VideoObject[] mVideos;

    public VideoAdapter(Context context, VideoObject[] videos) {
        super(context, 0, videos);
        this.mVideos = videos;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VideoObject video = getItem(position);
        VideoViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.video_list_item, parent, false);
            viewHolder = new VideoViewHolder();
            viewHolder.text = (TextView) convertView.findViewById(R.id.video_item_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (VideoViewHolder) convertView.getTag();
        }


        viewHolder.text.setText(video.getName());

        return convertView;
    }

    void setVideos(VideoObject[] videos) {
        this.mVideos = videos;
        notifyDataSetChanged();
    }

    static class VideoViewHolder {
        TextView text;
    }

}
