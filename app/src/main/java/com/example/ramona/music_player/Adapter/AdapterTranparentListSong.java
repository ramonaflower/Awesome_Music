package com.example.ramona.music_player.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ramona.music_player.Entities.SongEntities;
import com.example.ramona.music_player.R;

import java.util.List;

/**
 * Created by Ramona on 10/20/2017.
 */

public class AdapterTranparentListSong extends RecyclerView.Adapter<AdapterTranparentListSong.MyViewHolder> {
    private List<SongEntities> mList;
    private SongEntities mSong;
    clickListener mListener;
    public AdapterTranparentListSong(List<SongEntities> mList) {
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.lt_item_list_song_transparent, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        mSong = mList.get(position);
        holder.text_song_index.setText(position + 1 + "");
        holder.text_song_name.setText(mSong.getmSongName());
        holder.text_artist_name.setText(mSong.getmArtistName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text_song_index, text_song_name, text_artist_name;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_song_index = itemView.findViewById(R.id.text_song_index);
            text_song_name = itemView.findViewById(R.id.text_name_of_song_transparent);
            text_artist_name = itemView.findViewById(R.id.text_name_of_artist_transparent);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onClick(getLayoutPosition());
                }
            });
        }
    }

    public void onItemClick(clickListener listener){
        mListener = listener;
    }

    public interface clickListener {
        void onClick(int position);
    }
}
