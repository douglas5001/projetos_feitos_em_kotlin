package portella.douglas.afinal

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.SeekBar
import android.widget.Toast


import kotlinx.android.synthetic.main.activity_pompei.*
import kotlinx.android.synthetic.main.activity_take_on_me_.*
import kotlin.math.max
import portella.douglas.afinal.currentSeconds as currentSeconds1

class Pompei : AppCompatActivity() {
    private lateinit var mediaPlayer1: MediaPlayer
    private lateinit var runnable1:Runnable
    private var handler: Handler = Handler()
    private var pause1:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pompei)

        peoximo3.setOnClickListener {
            startActivity(Intent(this@Pompei, I_wlall_want::class.java))

        }
        anterior3.setOnClickListener {
            startActivity(Intent(this@Pompei, NeverByAlone::class.java))
        }


        pauseBtn1.visibility = View.INVISIBLE


        // Start the media player
        playBtn1.setOnClickListener{
            if(pause1){
                mediaPlayer1.seekTo(mediaPlayer1.currentPosition)
                mediaPlayer1.start()
                pause1 = false
                pauseBtn1.visibility = View.VISIBLE
                playBtn1.visibility = View.INVISIBLE
                Toast.makeText(this,"media playing", Toast.LENGTH_SHORT).show()
            }else{

                mediaPlayer1 = MediaPlayer.create(applicationContext,R.raw.pompei)
                mediaPlayer1.start()
                pauseBtn1.visibility = View.VISIBLE
                playBtn1.visibility = View.INVISIBLE
                Toast.makeText(this,"media playing", Toast.LENGTH_SHORT).show()

            }

            initializeSeekBar()

            playBtn1.isEnabled = false
            pauseBtn1.isEnabled = true
            stopBtn1.isEnabled = true

            mediaPlayer1.setOnCompletionListener {
                playBtn1.isEnabled = true
                pauseBtn1.isEnabled = false
                stopBtn1.isEnabled = false
                Toast.makeText(this,"end", Toast.LENGTH_SHORT).show()
            }
        }
        // Pause the media player
        pauseBtn1.setOnClickListener {
            if(mediaPlayer1.isPlaying){
                mediaPlayer1.pause()
                playBtn1.visibility = View.VISIBLE
                pauseBtn1.visibility = View.INVISIBLE
                pause1 = true
                playBtn1.isEnabled = true
                pauseBtn1.isEnabled = false
                stopBtn1.isEnabled = true
                Toast.makeText(this,"media pause", Toast.LENGTH_SHORT).show()
            }
        }
        // Stop the media player
        stopBtn1.setOnClickListener{
            if(mediaPlayer1.isPlaying || pause1.equals(true)){
                pause1 = false
                seek_bar1.setProgress(0)
                mediaPlayer1.stop()
                mediaPlayer1.reset()
                mediaPlayer1.release()
                handler.removeCallbacks(runnable1)
                pauseBtn1.visibility = View.INVISIBLE
                playBtn1.visibility = View.VISIBLE
                playBtn1.isEnabled = true
                pauseBtn1.isEnabled = false
                stopBtn1.isEnabled = false
                tv_pass1.text = ""
                tv_due1.text = ""
                Toast.makeText(this,"media stop", Toast.LENGTH_SHORT).show()
            }
        }
        // Seek bar change listener
        seek_bar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    mediaPlayer1.seekTo(i * 1000)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
    }
    // Method to initialize seek bar and audio stats
    private fun initializeSeekBar() {
        seek_bar1.max = mediaPlayer1.seconds2
        runnable1 = Runnable {
            seek_bar1.progress = mediaPlayer1.currentSeconds2

            tv_pass1.text = "${mediaPlayer1.currentSeconds2} sec"
            val diff = mediaPlayer1.seconds2 - mediaPlayer1.currentSeconds2
            tv_due1.text = "$diff sec"

            handler.postDelayed(runnable1, 1000)
        }
        handler.postDelayed(runnable1, 1000)
    }
}
// Creating an extension property to get the media player time duration in seconds
val MediaPlayer.seconds2:Int
    get() {
        return this.duration / 1000
    }
// Creating an extension property to get media player current position in seconds
   val MediaPlayer.currentSeconds2:Int

    get() {
        return this.currentPosition/1000
    }
