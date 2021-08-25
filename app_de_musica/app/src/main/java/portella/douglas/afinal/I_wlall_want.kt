package portella.douglas.afinal

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_i_wlall_want.*
import kotlinx.android.synthetic.main.activity_take_on_me_.*

class I_wlall_want : AppCompatActivity() {

    private lateinit var mediaPlayer9: MediaPlayer
    private lateinit var runnable9:Runnable
    private var handler9: Handler = Handler()
    private var pause9:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_i_wlall_want)

        peoximo319.setOnClickListener {
            startActivity(Intent(this@I_wlall_want, Take_on_me_Activity::class.java))

        }
        anterior319.setOnClickListener {
            startActivity(Intent(this@I_wlall_want, Pompei::class.java))
        }


        pauseBtn119.visibility = View.INVISIBLE


        // Start the media player
        playBtn119.setOnClickListener{
            if(pause9){
                mediaPlayer9.seekTo(mediaPlayer9.currentPosition)
                mediaPlayer9.start()
                pause9 = false
                pauseBtn119.visibility = View.VISIBLE
                playBtn119.visibility = View.INVISIBLE
                Toast.makeText(this,"media playing", Toast.LENGTH_SHORT).show()
            }else{

                mediaPlayer9 = MediaPlayer.create(applicationContext,R.raw.all_i_want)
                mediaPlayer9.start()
                pauseBtn119.visibility = View.VISIBLE
                playBtn119.visibility = View.INVISIBLE
                Toast.makeText(this,"media playing", Toast.LENGTH_SHORT).show()

            }

            initializeSeekBar()

            playBtn119.isEnabled = false
            pauseBtn119.isEnabled = true
            stopBtn119.isEnabled = true

            mediaPlayer9.setOnCompletionListener {
                playBtn119.isEnabled = true
                pauseBtn119.isEnabled = false
                stopBtn119.isEnabled = false
                Toast.makeText(this,"end", Toast.LENGTH_SHORT).show()
            }
        }
        // Pause the media player
        pauseBtn119.setOnClickListener {
            if(mediaPlayer9.isPlaying){
                mediaPlayer9.pause()
                playBtn119.visibility = View.VISIBLE
                pauseBtn119.visibility = View.INVISIBLE
                pause9 = true
                playBtn119.isEnabled = true
                pauseBtn119.isEnabled = false
                stopBtn119.isEnabled = true
                Toast.makeText(this,"media pause", Toast.LENGTH_SHORT).show()
            }
        }
        // Stop the media player
        stopBtn119.setOnClickListener{
            if(mediaPlayer9.isPlaying || pause9.equals(true)){
                pause9 = false
                seek_bar119.setProgress(0)
                mediaPlayer9.stop()
                mediaPlayer9.reset()
                mediaPlayer9.release()
                handler9.removeCallbacks(runnable9)
                pauseBtn119.visibility = View.INVISIBLE
                playBtn119.visibility = View.VISIBLE
                playBtn119.isEnabled = true
                pauseBtn119.isEnabled = false
                stopBtn119.isEnabled = false
                tv_pass119.text = ""
                tv_pass119.text = ""
                Toast.makeText(this,"media stop", Toast.LENGTH_SHORT).show()
            }
        }
        // Seek bar change listener
        seek_bar119.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    mediaPlayer9.seekTo(i * 1000)
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
        seek_bar119.max = mediaPlayer9.seconds

        runnable9 = Runnable {
            seek_bar119.progress = mediaPlayer9.currentSeconds9

            tv_pass119.text = "${mediaPlayer9.currentSeconds9} sec"
            val diff = mediaPlayer9.seconds - mediaPlayer9.currentSeconds9
            tv_pass119.text = "$diff sec"

            handler9.postDelayed(runnable9, 1000)
        }
        handler9.postDelayed(runnable9, 1000)
    }
}


// Creating an extension property to get the media player time duration in seconds
val MediaPlayer.seconds9:Int
    get() {
        return this.duration / 1000
    }
// Creating an extension property to get media player current position in seconds
val MediaPlayer.currentSeconds9:Int
    get() {
        return this.currentPosition/1000
    }