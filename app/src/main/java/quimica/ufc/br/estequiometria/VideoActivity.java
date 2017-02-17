package quimica.ufc.br.estequiometria;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends BasicActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        setUpFullScreen();

        Uri uri = getIntent().getData();

        videoView = (VideoView) findViewById(R.id.videoView);

        if(uri!=null) {
            videoView.setMediaController(new MediaController(this));
            videoView.setVideoPath(uri.getPath());
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoView.stopPlayback();
    }
}
