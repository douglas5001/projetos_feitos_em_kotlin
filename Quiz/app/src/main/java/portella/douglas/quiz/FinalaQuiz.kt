package portella.douglas.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finala_quiz.*
import kotlinx.android.synthetic.main.activity_screen1.*
import portella.douglas.quiz.model.Quiz

class FinalaQuiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finala_quiz)


        Quiz.context= this@FinalaQuiz
        Quiz.questionsShuffle()
        Quiz.genarateQuestions()
        getScore()

        textViewPorcentagem.text = "correct answers: ${Quiz.checkAverageOfCorrectAnswers().toString()}%"

        textView3Masseger.text = Quiz.finalMessage()

        buttonfinalaquiz.setOnClickListener {
            Quiz.clearALL()
            startActivity(Intent(this@FinalaQuiz, Screen1::class.java))
            finish()
        }



    }
    fun getScore(){
        textFinalScore.text = "Final score: ${Quiz.score().toString()}"
    }
}