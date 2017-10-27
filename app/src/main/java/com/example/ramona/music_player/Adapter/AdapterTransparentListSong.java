package com.example.ramona.music_player.Adapter;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ramona.music_player.Entities.SongEntities;
import com.example.ramona.music_player.Helper.ItemTouchHelperAdapter;
import com.example.ramona.music_player.Helper.OnStartDragListener;
import com.example.ramona.music_player.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ramona on 10/20/2017.
 */

public class AdapterTransparentListSong extends RecyclerView.Adapter<AdapterTransparentListSong.MyViewHolder> implements ItemTouchHelperAdapter{
    private List<SongEntities> mList;
    private SongEntities mSong;
    private clickListener mListener;
    private  OnStartDragListener mDragStartListener;
    public AdapterTransparentListSong(List<SongEntities> mList, OnStartDragListener mDragStartListener, clickListener mListener) {
        this.mList = mList;
        this.mDragStartListener = mDragStartListener;
        this.mListener = mListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.lt_item_list_song_transparent, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        mSong = mList.get(position);
        holder.mTextSongIndex.setText(position + 1 + "");
        holder.mTextSongName.setText(mSong.getmSongName());
        holder.mTextArtistAame.setText(mSong.getmArtistName());
        holder.mImageMove.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (MotionEventCompat.getActionMasked(motionEvent) == MotionEvent.ACTION_DOWN) {
                    mDragStartListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        notifyItemChanged(toPosition);
        notifyItemChanged(fromPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextSongIndex, mTextSongName, mTextArtistAame;
        public ImageView mImageMove;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextSongIndex = itemView.findViewById(R.id.text_song_index);
            mTextSongName = itemView.findViewById(R.id.text_name_of_song_transparent);
            mTextArtistAame = itemView.findViewById(R.id.text_name_of_artist_transparent);
            mImageMove= itemView.findViewById(R.id.img_move);
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
