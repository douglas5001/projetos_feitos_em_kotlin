package portella.douglas.afinal

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_never_by_alone.*
import kotlinx.android.synthetic.main.activity_take_on_me_.*
import kotlin.coroutines.coroutineContext

class Take_on_me_Activity : AppCompatActivity() {

        private lateinit var mediaPlayer: MediaPlayer
        private lateinit var runnable:Runnable
        private var handler: Handler = Handler()
        private var pause:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_on_me_)



        proximo2.setOnClickListener {
            startActivity(Intent(this@Take_on_me_Activity, NeverByAlone::class.java))

        }
        anterior2.setOnClickListener {
            startActivity(Intent(this@Take_on_me_Activity, I_wlall_want::class.java))
        }


               pauseBtn.visibility = View.INVISIBLE


            // Start the media player
            playBtn.setOnClickListener{
                if(pause){
                    mediaPlayer.seekTo(mediaPlayer.currentPosition)
                    mediaPlayer.start()
                    pause = false
                    pauseBtn.visibility = View.VISIBLE
                    playBtn.visibility = View.INVISIBLE
                    Toast.makeText(this,"media playing", Toast.LENGTH_SHORT).show()
                }else{

                    mediaPlayer = MediaPlayer.create(applicationContext,R.raw.take_on_me)
                    mediaPlayer.start()
                    pauseBtn.visibility = View.VISIBLE
                    playBtn.visibility = View.INVISIBLE
                    Toast.makeText(this,"media playing", Toast.LENGTH_SHORT).show()

                }

                initializeSeekBar()

                playBtn.isEnabled = false
                pauseBtn.isEnabled = true
                stopBtn.isEnabled = true

                mediaPlayer.setOnCompletionListener {
                    playBtn.isEnabled = true
                    pauseBtn.isEnabled = false
                    stopBtn.isEnabled = false
                    Toast.makeText(this,"end", Toast.LENGTH_SHORT).show()
                }
            }
            // Pause the media player
            pauseBtn.setOnClickListener {
                if(mediaPlayer.isPlaying){
                    mediaPlayer.pause()
                    playBtn.visibility = View.VISIBLE
                    pauseBtn.visibility = View.INVISIBLE
                    pause = true
                    playBtn.isEnabled = true
                    pauseBtn.isEnabled = false
                    stopBtn.isEnabled = true
                    Toast.makeText(this,"media pause", Toast.LENGTH_SHORT).show()
                }
            }
            // Stop the media player
            stopBtn.setOnClickListener{
                if(mediaPlayer.isPlaying || pause.equals(true)){
                    pause = false
                    seek_bar.setProgress(0)
                    mediaPlayer.stop()
                    mediaPlayer.reset()
                    mediaPlayer.release()
                    handler.removeCallbacks(runnable)
                    pauseBtn.visibility = View.INVISIBLE
                    playBtn.visibility = View.VISIBLE
                    playBtn.isEnabled = true
                    pauseBtn.isEnabled = false
                    stopBtn.isEnabled = false
                    tv_pass.text = ""
                    tv_due.text = ""
                    Toast.makeText(this,"media stop", Toast.LENGTH_SHORT).show()
                }
            }
            // Seek bar change listener
            seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                    if (b) {
                        mediaPlayer.seekTo(i * 1000)
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
            seek_bar.max = mediaPlayer.seconds

            runnable = Runnable {
                seek_bar.progress = mediaPlayer.currentSeconds

                tv_pass.text = "${mediaPlayer.currentSeconds} sec"
                val diff = mediaPlayer.seconds - mediaPlayer.currentSeconds
                tv_due.text = "$diff sec"

                handler.postDelayed(runnable, 1000)
            }
            handler.postDelayed(runnable, 1000)
        }
    }


// Creating an extension property to get the media player time duration in seconds
    val MediaPlayer.seconds:Int
        get() {
            return this.duration / 1000
        }
    // Creating an extension property to get media player current position in seconds
    val MediaPlayer.currentSeconds:Int
        get() {
            return this.currentPosition/1000
        }




