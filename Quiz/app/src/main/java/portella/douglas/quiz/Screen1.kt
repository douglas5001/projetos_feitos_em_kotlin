package portella.douglas.quiz

import android.content.Context
import android.content.Intent
import android.media.MediaActionSound
import android.media.MediaPlayer
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_screen1.*
import portella.douglas.quiz.extension.toast
import portella.douglas.quiz.model.Quiz
import java.util.concurrent.TimeUnit

class Screen1 : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)



        buttonNext.visibility = View.INVISIBLE
        progressBar.visibility = View.INVISIBLE
        Quiz.context= this@Screen1
        Quiz.questionsShuffle()
        Quiz.genarateQuestions()

        val question = Quiz.questionArray.get(0)

        getScore()

       descricao.text = question.questionDescription
        activityRadioButton1.text = question.option1.toString()
        activityRadioButton2.text = question.option2
        activityRadioButton3.text = question.option3
        activityRadioButton4.text = question.option4

        buttonN.setOnClickListener {


            buttonN.visibility = View.INVISIBLE
            buttonNext.visibility = View.VISIBLE


            val id = activityRadioGroup1.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)
            progressBar.visibility = View.VISIBLE
            carregar()
            getScore()

            if(Quiz.verifuTheCorrectanser(radio.text.toString())){
                toast("${baseContext.getString(R.string.acertou)}")
                getScore()
                acertou()
                val vibrator = getSystemService(Context.VIBRATOR_SERVICE)as Vibrator
                val milliseconds: Long = 500
                vibrator.vibrate(milliseconds)

            } else {
                toast("${baseContext.getString(R.string.errou)}")
                errou()
            }

        }


        buttonNext.setOnClickListener {
            startActivity(Intent(this@Screen1, ScreenQuis2::class.java))
            finish()
        }


    }



    fun getScore(){
        textViewScore.text = Quiz.score().toString()
    }
    fun carregar(){
        progressBar.visibility = View.VISIBLE
        TimeUnit.SECONDS.sleep(1)


    }
    fun acertou(){
        mediaPlayer = MediaPlayer.create(this@Screen1, R.raw.acertoumizeravi)
        mediaPlayer.start()
        play(R.raw.acertoumizeravi)

    }

    fun errou(){
        mediaPlayer = MediaPlayer.create(this@Screen1, R.raw.errou)
        mediaPlayer.start()
        play(R.raw.errou)
    }

    fun play(sound: Int){
        mediaPlayer = MediaPlayer.create(this@Screen1, sound)
        mediaPlayer.start()
    }
}