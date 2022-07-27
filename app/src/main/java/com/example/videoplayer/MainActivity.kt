package com.example.videoplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.videoplayer.databinding.ActivityMainBinding

const val URL =
    "https://hw20.asset.aparat.com/aparat-video/ec18dea76e6a4fab8f3eceb4e1a9dce711376561-480p.mp4?wmsAuthSign=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6IjU5ODQzYzI5ZjZiNzJmY2NlZjc4NWY0MDRlYmE2YTA4IiwiZXhwIjoxNjU4OTQ3MzE5LCJpc3MiOiJTYWJhIElkZWEgR1NJRyJ9.tHGCdCmu0SUaZNntZ-ETxTmcTbgP9ZNrRWsgraNJcWM"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.videoView.setVideoPath(URL)

        //when Prepared video  , it'll start
        binding.videoView.setOnPreparedListener {
            binding.videoView.start()
            val mediaController = MediaController(this)
            mediaController.setMediaPlayer(binding.videoView)
            binding.videoView.setMediaController(mediaController)
            mediaController.setAnchorView(binding.videoView)
        }
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

    }

    override fun onDestroy() {
        super.onDestroy()
        binding.videoView.stopPlayback()
    }
}