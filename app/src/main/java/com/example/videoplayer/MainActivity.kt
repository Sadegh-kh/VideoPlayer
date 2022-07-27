package com.example.videoplayer

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.videoplayer.databinding.ActivityMainBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

const val URI =
    "https://hw20.asset.aparat.com/aparat-video/ec18dea76e6a4fab8f3eceb4e1a9dce711376561-480p.mp4?wmsAuthSign=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6IjU5ODQzYzI5ZjZiNzJmY2NlZjc4NWY0MDRlYmE2YTA4IiwiZXhwIjoxNjU4OTQ3MzE5LCJpc3MiOiJTYWJhIElkZWEgR1NJRyJ9.tHGCdCmu0SUaZNntZ-ETxTmcTbgP9ZNrRWsgraNJcWM"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var exoPlayer: ExoPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

/*  Video View
        binding.videoView.setVideoPath(URL)

        //when Prepared video  , it'll start
        binding.videoView.setOnPreparedListener {
            binding.videoView.start()
            val mediaController = MediaController(this)
            mediaController.setMediaPlayer(binding.videoView)
            binding.videoView.setMediaController(mediaController)
            mediaController.setAnchorView(binding.videoView)
        }*/

/* More attribute for Video View
        binding.videoView.duration
        binding.videoView.currentPosition
        binding.videoView.start()
        binding.videoView.pause()
        binding.videoView.seekTo()

        binding.videoView.setOnCompletionListener {  }
        binding.videoView.setOnErrorListener { mediaPlayer, i, i2 ->
            true
        }*/

        exoPlayer = ExoPlayer.Builder(this).build()
        val mediaItem = MediaItem.fromUri(URI)
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.playWhenReady=true
        exoPlayer.play()

        binding.PlayerVideo.player=exoPlayer
    }

    override fun onDestroy() {
        super.onDestroy()
//        binding.videoView.stopPlayback()
        exoPlayer.release()
    }
}