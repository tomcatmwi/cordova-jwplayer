package com.pixeldog.jwplayer;

import android.app.Activity;
import android.os.Bundle;

import java.util.List;
import java.util.ArrayList;

import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;

import com.longtailvideo.jwplayer.JWPlayerView;
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem;
import com.longtailvideo.jwplayer.configuration.PlayerConfig;

public class JWPlayerActivity extends Activity {

    private JWPlayerView mPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String package_name = getApplication().getPackageName();
        setContentView(getApplication().getResources().getIdentifier("main", "layout", package_name));

        mPlayerView = findViewById(R.id.jwplayer);

        // Create playlist

        List<PlaylistItem> playlist = new ArrayList<>();

        PlaylistItem playlistItem = new PlaylistItem.Builder()
                .file("https://www.learningcontainer.com/bfd_download/sample-mp4-file/").build();

        playlist.add(playlistItem);

        // Configure player

        PlayerConfig config = new PlayerConfig.Builder().playlist(playlist).build();
        mPlayerView.setup(config);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPlayerView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlayerView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayerView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPlayerView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayerView.onDestroy();
    }
}