package portella.douglas.quiz

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_screen1.*
import kotlinx.android.synthetic.main.activity_screen3.*
import portella.douglas.quiz.extension.toast
import portella.douglas.quiz.model.Quiz
import java.util.concurrent.TimeUnit

class ActivityScreen3 : AppCompatActivity() {
    private lateinit var mediaPlayer3: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_screen3)
        buttonNext4.visibility = View.INVISIBLE
        progressBar4.visibility = View.INVISIBLE



        Quiz.context= this@ActivityScreen3
        Quiz.genarateQuestions()
        Quiz.questionsShuffle()

        val question = Quiz.questionArray.get(0)

        getScore()

        descricao4.text = question.questionDescription
        radioButton144.text = question.option1
        activityRadioButton24.text = question.option2
        activityRadioButton34.text = question.option3
        activityRadioButton44.text = question.option4

        buttonN4.setOnClickListener {


            buttonN4.visibility = View.INVISIBLE
            buttonNext4.visibility = View.VISIBLE


            val id = activityRadioGroup14.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)
            progressBar4.visibility = View.VISIBLE
            carregar()
            getScore()

            if (Quiz.verifuTheCorrectanser(radio.text.toString())) {
                toast("${baseContext.getString(R.string.acertou)}")
                acertou()
                getScore()

                val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                val milliseconds: Long = 500
                vibrator.vibrate(milliseconds)

            } else {
                toast("${baseContext.getString(R.string.errou)}")
                errou()
            }

        }



        buttonNext4.setOnClickListener {
            startActivity(Intent(this@ActivityScreen3, QuisScreen4::class.java))
            finish()
        }


    }




    fun getScore(){
        textViewScore4.text = Quiz.score().toString()
    }
    fun carregar(){
        progressBar4.visibility = View.VISIBLE
        TimeUnit.SECONDS.sleep(1)


    }
    fun acertou(){
        mediaPlayer3 = MediaPlayer.create(this@ActivityScreen3, R.raw.acertoumizeravi)
        mediaPlayer3.start()
        play(R.raw.acertoumizeravi)

    }

    fun errou(){
        mediaPlayer3 = MediaPlayer.create(this@ActivityScreen3, R.raw.errou)
        mediaPlayer3.start()
        play(R.raw.errou)
    }

    fun play(sound: Int){
        mediaPlayer3 = MediaPlayer.create(this@ActivityScreen3, sound)
        mediaPlayer3.start()
    }
}
