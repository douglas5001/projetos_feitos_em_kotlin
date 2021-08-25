package portella.douglas.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*
import portella.douglas.quiz.model.Quiz

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Quiz.context= this@MainActivity
        Quiz.questionsShuffle()
        Quiz.genarateQuestions()

        Quiz.clearALL()
        button2.setOnClickListener{startActivity(Intent(this@MainActivity, Screen1::class.java))}

         }



    }


