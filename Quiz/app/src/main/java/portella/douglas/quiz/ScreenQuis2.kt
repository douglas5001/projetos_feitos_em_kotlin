package portella.douglas.quiz

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_screen1.*
import kotlinx.android.synthetic.main.activity_screen_quis2.*
import portella.douglas.quiz.extension.toast
import portella.douglas.quiz.model.Question
import portella.douglas.quiz.model.Quiz

class ScreenQuis2 : AppCompatActivity() {
    private lateinit var mediaPlayer2: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_quis2)


        buttonNextScreen2.visibility = View.INVISIBLE
        progressBar3.visibility = View.INVISIBLE


        Quiz.context= this@ScreenQuis2
        Quiz.genarateQuestions()
        Quiz.questionsShuffle()
        val question = Quiz.questionArray.get(0)

        getScore()

        descricao21.text = question.questionDescription
        radioButton1Screen2.text = question.option1
        radioButton2Screen2.text = question.option2
        radioButton3Screen2.text = question.option3
        radioButton4Screen2.text = question.option4

        buttonAnserScreen2.setOnClickListener {
            buttonAnserScreen2.visibility = View.INVISIBLE
            buttonNextScreen2.visibility = View.VISIBLE

            val id = groupRadioButtonScreen2.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifuTheCorrectanser(radio.text.toString())) {
                toast("${baseContext.getString(R.string.acertou)}")
                getScore()
                acertou()
            } else {
                toast("${baseContext.getString(R.string.errou)}")
                errou()
            }
        }

        buttonNextScreen2.setOnClickListener {
            startActivity(Intent(this@ScreenQuis2, ActivityScreen3::class.java))
            finish()
        }


    }


    fun getScore() {
        textViewScore2.text = Quiz.score().toString()
    }

    fun errou() {
        mediaPlayer2 = MediaPlayer.create(this@ScreenQuis2, R.raw.errou)
        mediaPlayer2.start()
        play(R.raw.errou)
    }

    fun play(sound: Int) {
        mediaPlayer2 = MediaPlayer.create(this@ScreenQuis2, sound)
        mediaPlayer2.start()
    }

    fun acertou() {
        mediaPlayer2 = MediaPlayer.create(this@ScreenQuis2, R.raw.acertoumizeravi)
        mediaPlayer2.start()
        play(R.raw.acertoumizeravi)
    }
}