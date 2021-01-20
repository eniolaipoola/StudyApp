package com.eniola.studyapp.ui.subjects

import android.net.Uri
import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.eniola.studyapp.R
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.fragment_play_lesson.*

class PlayLessonFragment : Fragment(), Player.EventListener {


    private var exoPlayer: SimpleExoPlayer? = null
    var mediaUrl: String? = null
    var mediaSessionCompat: MediaSessionCompat? = null
    private val TAG = "media_session_tag"
    var stateCompatBuilder: PlaybackStateCompat.Builder? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_play_lesson, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set up media session
        mediaSessionCompat = MediaSessionCompat(activity?.applicationContext, TAG)
        mediaSessionCompat!!.setFlags(MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS or MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS)
        mediaSessionCompat!!.setMediaButtonReceiver(null)
        stateCompatBuilder = PlaybackStateCompat.Builder().setActions(
            PlaybackStateCompat.ACTION_PLAY or
                    PlaybackStateCompat.ACTION_PLAY_PAUSE or PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS
                    or PlaybackStateCompat.ACTION_SKIP_TO_NEXT
        )
        mediaSessionCompat!!.setPlaybackState(stateCompatBuilder!!.build())
        mediaSessionCompat!!.setCallback(MediaSessionCallback())
        mediaSessionCompat!!.isActive = true

        //get media url passed from chapters fragment
        val bundle = arguments
        if(bundle != null){
            mediaUrl = bundle.getString("media")

            //play url using exoplayer
            initiateMediaPlayer(Uri.parse(mediaUrl))
        }

    }

    private fun initiateMediaPlayer(mediaUri: Uri) {
        if (exoPlayer == null) {
            //create an exoPlayer instance
            val trackSelector: TrackSelector = DefaultTrackSelector()
            val loadControl: LoadControl = DefaultLoadControl()
            exoPlayer = ExoPlayerFactory.newSimpleInstance(activity, trackSelector, loadControl)
            playerView.player = exoPlayer
            //prepare the media source
            val userAgent = Util.getUserAgent(
                activity,
                "StudyApp"
            )

            val videoSource: MediaSource = ExtractorMediaSource(
                mediaUri, DefaultDataSourceFactory(activity, userAgent),
                DefaultExtractorsFactory(), null, null
            )
            exoPlayer!!.prepare(videoSource)
            exoPlayer!!.playWhenReady = true
        } else {
            Log.i("tag", "exoplayer is null")
        }
    }

    private class MediaSessionCallback : MediaSessionCompat.Callback() {
        override fun onPlay() {
            super.onPlay()

            //save video in recent activity
        }

        override fun onPause() {
            super.onPause()
        }

        override fun onSkipToPrevious() {
            super.onSkipToPrevious()
        }

        override fun onSkipToNext() {
            super.onSkipToNext()
        }
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }

    override fun onPause() {
        super.onPause()
        releasePlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaSessionCompat!!.isActive = false
    }

    private fun releasePlayer() {
        if (exoPlayer != null) {
            //mNotificationManger.cancelAll();
            exoPlayer!!.stop()
            exoPlayer!!.release()
            exoPlayer = null
        }
    }


}