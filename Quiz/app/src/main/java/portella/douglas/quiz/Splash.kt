package portella.douglas.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash : AppCompatActivity() {
    private var delayHander : Handler? = null
    private var SPLASH_DELAY: Long = 3000
    internal var runnable = Runnable {
        if(!isFinishing){
            val intent = Intent(this@Splash, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

       delayHander = Handler()
        delayHander!!.postDelayed(runnable, SPLASH_DELAY)

    }

    override fun onDestroy() {
        super.onDestroy()
        delayHander?.let {
            it.removeCallbacks(runnable)
        }
    }
}