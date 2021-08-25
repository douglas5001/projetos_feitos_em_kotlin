package portella.douglas.quiz

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_quis_screen4.*
import kotlinx.android.synthetic.main.activity_screen1.*
import portella.douglas.quiz.extension.toast
import portella.douglas.quiz.model.Quiz
import java.util.concurrent.TimeUnit

class QuisScreen4 : AppCompatActivity() {
    private lateinit var mediaPlayer4: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quis_screen4)


        buttonNext5.visibility = View.INVISIBLE
        progressBar5.visibility = View.INVISIBLE



        Quiz.context= this@QuisScreen4
        Quiz.genarateQuestions()
        Quiz.questionsShuffle()
        val question = Quiz.questionArray.get(0)

        getScore()

        descricao5.text = question.questionDescription
        radioButton145.text = question.option1
        activityRadioButton25.text = question.option2
        activityRadioButton35.text = question.option3
        activityRadioButton45.text = question.option4

        buttonN5.setOnClickListener {


            buttonN5.visibility = View.INVISIBLE
            buttonNext5.visibility = View.VISIBLE


            val id = activityRadioGroup155.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)
            progressBar5.visibility = View.VISIBLE
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


        buttonNext5.setOnClickListener {
            startActivity(Intent(this@QuisScreen4, FinalaQuiz::class.java))
            finish()
        }


    }



    fun getScore(){
        textViewScore6.text = Quiz.score().toString()
    }
    fun carregar(){
        progressBar5.visibility = View.VISIBLE
        TimeUnit.SECONDS.sleep(1)


    }
    fun acertou(){
        mediaPlayer4 = MediaPlayer.create(this@QuisScreen4, R.raw.acertoumizeravi)
        mediaPlayer4.start()
        play(R.raw.acertoumizeravi)

    }

    fun errou(){
        mediaPlayer4 = MediaPlayer.create(this@QuisScreen4, R.raw.errou)
        mediaPlayer4.start()
        play(R.raw.errou)
    }

    fun play(sound: Int){
        mediaPlayer4 = MediaPlayer.create(this@QuisScreen4, sound)
        mediaPlayer4.start()
    }

    }
