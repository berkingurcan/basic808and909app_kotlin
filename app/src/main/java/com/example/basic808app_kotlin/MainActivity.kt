package com.example.basic808app_kotlin

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var btnPlaySound1: ImageButton
    private lateinit var btnPlaySound2: ImageButton
    private lateinit var btnPlaySound3: ImageButton
    private lateinit var btnPlaySound4: ImageButton
    private lateinit var btnPlaySound5: ImageButton
    private lateinit var btnPlaySound6: ImageButton
    private lateinit var fabChangeSoundStyle: FloatingActionButton
    private lateinit var txtSoundType: TextView

    private lateinit var pad: MediaPlayer
    private lateinit var pad909: MediaPlayer
    private lateinit var pad2: MediaPlayer
    private lateinit var pad2909: MediaPlayer
    private lateinit var kick: MediaPlayer
    private lateinit var kick909: MediaPlayer
    private lateinit var chihat: MediaPlayer
    private lateinit var chihat909: MediaPlayer
    private lateinit var ohihat: MediaPlayer
    private lateinit var ohihat909: MediaPlayer
    private lateinit var clap: MediaPlayer
    private lateinit var clap909: MediaPlayer

    private var play808Sounds = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeVariables()
        onClickListeners()
    }

    private fun initializeVariables() {
        btnPlaySound1 = findViewById(R.id.btnPlaySound1)
        btnPlaySound2 = findViewById(R.id.btnPlaySound2)
        btnPlaySound3 = findViewById(R.id.btnPlaySound3)
        btnPlaySound4 = findViewById(R.id.btnPlaySound4)
        btnPlaySound5 = findViewById(R.id.btnPlaySound5)
        btnPlaySound6 = findViewById(R.id.btnPlaySound6)
        fabChangeSoundStyle = findViewById(R.id.fabChangeSoundStyle)
        txtSoundType = findViewById(R.id.txtSoundType)

        updateTxtSoundType()

        pad = MediaPlayer.create(this, R.raw.sopad)
        pad909 = MediaPlayer.create(this, R.raw.rs01)

        pad2 = MediaPlayer.create(this, R.raw.deepad)
        pad2909 = MediaPlayer.create(this, R.raw.mt02)

        kick = MediaPlayer.create(this, R.raw.kick)
        kick909 = MediaPlayer.create(this, R.raw.bd01)

        chihat = MediaPlayer.create(this, R.raw.chihat)
        chihat909 = MediaPlayer.create(this, R.raw.hh01)

        ohihat = MediaPlayer.create(this, R.raw.ohihat)
        ohihat909 = MediaPlayer.create(this, R.raw.oh02)

        clap = MediaPlayer.create(this, R.raw.clap)
        clap909 = MediaPlayer.create(this, R.raw.sd13)
    }

    private fun onClickListeners() {
        btnPlaySound1.setOnClickListener {
            playSound(pad, pad909)
        }
        btnPlaySound2.setOnClickListener {
            playSound(pad2, pad2909)
        }
        btnPlaySound3.setOnClickListener {
            playSound(clap, clap909)
        }
        btnPlaySound4.setOnClickListener {
            playSound(chihat, chihat909)
        }
        btnPlaySound5.setOnClickListener {
            playSound(kick, kick909)
        }
        btnPlaySound6.setOnClickListener {
            playSound(ohihat, ohihat909)
        }
        fabChangeSoundStyle.setOnClickListener {
            play808Sounds = !play808Sounds
            updateTxtSoundType()
        }
    }

    private fun updateTxtSoundType() {
        txtSoundType.text = when (play808Sounds) {
            true -> getString(R.string.soundType, "808")
            false -> getString(R.string.soundType, "909")
        }
    }

    private fun playSound(sound808: MediaPlayer, sound909: MediaPlayer) {
        if (play808Sounds) {
            if (sound808.isPlaying) {
                sound808.stop()
                sound808.prepareAsync()

                sound808.setOnPreparedListener {
                    if (!sound808.isPlaying)
                        sound808.start()
                }
            } else
                sound808.start()
        } else {
            if (sound909.isPlaying) {
                sound909.stop()
                sound909.prepareAsync()

                sound909.setOnPreparedListener {
                    if (!sound909.isPlaying)
                        sound909.start()
                }
            } else
                sound909.start()
        }
    }
}