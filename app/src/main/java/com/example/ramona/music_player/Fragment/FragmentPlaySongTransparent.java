package com.example.ramona.music_player.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ramona.music_player.Adapter.AdapterTransparentListSong;
import com.example.ramona.music_player.Constant;
import com.example.ramona.music_player.Entities.SongEntities;
import com.example.ramona.music_player.Helper.OnStartDragListener;
import com.example.ramona.music_player.Interface.ClickFromTransparentToPlaySong;
import com.example.ramona.music_player.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramona on 10/20/2017.
 */

public class FragmentPlaySongTransparent extends Fragment implements OnStartDragListener, AdapterTransparentListSong.clickListener{
    private RecyclerView mRecyclerView;
    private AdapterTransparentListSong mAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<SongEntities> mList = new ArrayList<>();
    private ItemTouchHelper mItemTouchHelper;
    ClickFromTransparentToPlaySong mToPlaySong;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mToPlaySong = (ClickFromTransparentToPlaySong) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " must implement onSomeEventListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lt_transparent_list_song, container, false);
        mRecyclerView = view.findViewById(R.id.transparent_recycler_view_list_song);
        if (getArguments() != null) {
            mList = getArguments().getParcelableArrayList(Constant.PLAYSONG_TO_TRANSPARENT_FRAGMENT);
        }
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //mAdapter = new AdapterTransparentListSong(mList);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }


    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }

    @Override
    public void onClick(int position) {
        mToPlaySong.clickToPlaySong(position);
    }
}
