package portella.douglas.afinal

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_never_by_alone.*
import kotlinx.android.synthetic.main.activity_pompei.*

class NeverByAlone : AppCompatActivity() {
    private lateinit var mediaPlayer4: MediaPlayer
    private lateinit var runnable4:Runnable
    private var handler: Handler = Handler()
    private var pause4:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_never_by_alone)

        pauseBtn4.visibility = View.INVISIBLE

        proximo1.setOnClickListener {
            startActivity(Intent(this@NeverByAlone, Pompei::class.java))

        }
        anterior1.setOnClickListener {
            startActivity(Intent(this@NeverByAlone, Take_on_me_Activity::class.java))
        }
        // Start the media player
        playBtn4.setOnClickListener{
            if(pause4){
                mediaPlayer4.seekTo(mediaPlayer4.currentPosition)
                mediaPlayer4.start()
                pause4 = false
                pauseBtn4.visibility = View.VISIBLE
                playBtn4.visibility = View.INVISIBLE
                Toast.makeText(this,"media playing", Toast.LENGTH_SHORT).show()
            }else{

                mediaPlayer4 = MediaPlayer.create(applicationContext,R.raw.never)
                mediaPlayer4.start()
                pauseBtn4.visibility = View.VISIBLE
                playBtn4.visibility = View.INVISIBLE
                Toast.makeText(this,"media playing", Toast.LENGTH_SHORT).show()

            }

            initializeSeekBar()

            playBtn4.isEnabled = false
            pauseBtn4.isEnabled = true
            stopBtn4.isEnabled = true

            mediaPlayer4.setOnCompletionListener {
                playBtn4.isEnabled = true
                pauseBtn4.isEnabled = false
                stopBtn4.isEnabled = false
                Toast.makeText(this,"end", Toast.LENGTH_SHORT).show()
            }
        }
        // Pause the media player
        pauseBtn4.setOnClickListener {
            if(mediaPlayer4.isPlaying){
                mediaPlayer4.pause()
                playBtn4.visibility = View.VISIBLE
                pauseBtn4.visibility = View.INVISIBLE
                pause4 = true
                playBtn4.isEnabled = true
                pauseBtn4.isEnabled = false
                stopBtn4.isEnabled = true
                Toast.makeText(this,"media pause", Toast.LENGTH_SHORT).show()
            }
        }
        // Stop the media player
        stopBtn4.setOnClickListener{
            if(mediaPlayer4.isPlaying || pause4.equals(true)){
                pause4 = false
                seek_bar4.setProgress(0)
                mediaPlayer4.stop()
                mediaPlayer4.reset()
                mediaPlayer4.release()
                handler.removeCallbacks(runnable4)
                pauseBtn4.visibility = View.INVISIBLE
                playBtn4.visibility = View.VISIBLE
                playBtn4.isEnabled = true
                pauseBtn4.isEnabled = false
                stopBtn4.isEnabled = false
                tv_pass4.text = ""
                tv_due4.text = ""
                Toast.makeText(this,"media stop", Toast.LENGTH_SHORT).show()
            }
        }
        // Seek bar change listener
        seek_bar4.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    mediaPlayer4.seekTo(i * 1000)
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
        seek_bar4.max = mediaPlayer4.seconds6
        runnable4 = Runnable {
            seek_bar4.progress = mediaPlayer4.currentSeconds2

            tv_pass4.text = "${mediaPlayer4.currentSeconds2} sec"
            val diff = mediaPlayer4.seconds6 - mediaPlayer4.currentSeconds6
            tv_due4.text = "$diff sec"

            handler.postDelayed(runnable4, 1000)
        }
        handler.postDelayed(runnable4, 1000)
    }
}
// Creating an extension property to get the media player time duration in seconds
val MediaPlayer.seconds6:Int
    get() {
        return this.duration / 1000
    }
// Creating an extension property to get media player current position in seconds
val MediaPlayer.currentSeconds6:Int

    get() {
        return this.currentPosition/1000
    }


