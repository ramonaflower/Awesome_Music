package com.example.ramona.music_player.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ramona.music_player.Constant;
import com.example.ramona.music_player.Entities.SongEntities;
import com.example.ramona.music_player.Fragment.FragmentPlaySongCoverAlbum;
import com.example.ramona.music_player.Fragment.FragmentPlaySongTransparent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramona on 10/20/2017.
 */

public class PlaySongPagerAdapter extends FragmentStatePagerAdapter {
    private List<SongEntities> mList = new ArrayList<SongEntities>();

    public PlaySongPagerAdapter(FragmentManager fm, List<SongEntities> mList) {
        super(fm);
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragListSong= new FragmentPlaySongTransparent();
        Fragment fragCoverAlbum = new FragmentPlaySongCoverAlbum();
        Bundle bundle = new Bundle();
        if (mList != null) {
            switch (position) {
                case 0:
                    bundle.putParcelableArrayList(Constant.PLAYSONG_TO_TRANSPARENT_FRAGMENT, (ArrayList<SongEntities>) mList);
                    fragListSong.setArguments(bundle);
                    return fragListSong;
                case 1:
                    return fragCoverAlbum;
            }

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
