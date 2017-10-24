package com.example.ramona.music_player.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.ramona.music_player.R;

/**
 * Created by Ramona on 10/20/2017.
 */

public class FragmentPlaySongCoverAlbum extends Fragment {
    private RotateAnimation mRotateAnimation;
    private ImageView mImg_album_cover;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.lt_playsong_cover_album, container, false);
        mRotateAnimation = new RotateAnimation(0, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        mRotateAnimation.setInterpolator(new LinearInterpolator());
        mRotateAnimation.setDuration(4000);
        mRotateAnimation.setRepeatCount(Animation.INFINITE);
        initControl();
        return mView;
    }

    private void initControl() {
        mImg_album_cover = mView.findViewById(R.id.img_cover_album);
        mImg_album_cover.startAnimation(mRotateAnimation);
    }
}
