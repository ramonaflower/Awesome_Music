package com.example.ramona.music_player.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ramona.music_player.Activity.AlbumDetail;
import com.example.ramona.music_player.Adapter.AdapterTranparentListSong;
import com.example.ramona.music_player.Constant;
import com.example.ramona.music_player.Entities.SongEntities;
import com.example.ramona.music_player.Interface.ClickFromTranparentToPlaySong;
import com.example.ramona.music_player.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramona on 10/20/2017.
 */

public class FragmentPlaySongTransparent extends Fragment{
    private RecyclerView mRecyclerView;
    private AdapterTranparentListSong mAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<SongEntities> mList = new ArrayList<SongEntities>();
    ClickFromTranparentToPlaySong mToPlaySong;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mToPlaySong = (ClickFromTranparentToPlaySong) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " must implement onSomeEventListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lt_transparent_list_song, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.transparent_recycler_view_list_song);
        if (getArguments() != null) {
            mList = getArguments().getParcelableArrayList(Constant.PLAYSONG_TO_TRANSPARENT_FRAGMENT);
        }
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AdapterTranparentListSong(mList);
        mRecyclerView.setAdapter(mAdapter);
        initEvent();
        return view;
    }

    private void initEvent() {
        mAdapter.onItemClick(new AdapterTranparentListSong.clickListener() {
            @Override
            public void onClick(int position) {
                mToPlaySong.clickToPlaySong(position);
            }
        });
    }
}
