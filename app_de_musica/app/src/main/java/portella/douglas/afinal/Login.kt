package portella.douglas.afinal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class Login : AppCompatActivity() {
    private lateinit var buttonEnter : Button
    private lateinit var textViewEmail : TextView
    private lateinit var textViewUsuario : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initializer()
        buttonEnter.setOnClickListener (){

            var name = textViewEmail.text.toString()
            var age = textViewUsuario.text.toString()
            if (name.equals("Douglas") && age.equals("goiaba123")){

             startActivity(Intent(this@Login, MainActivity::class.java))

         }else{

             var alert = AlertDialog.Builder(this@Login)
             val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
             val milliseconds: Long = 1000
             vibrator.vibrate(milliseconds)

             alert.setMessage(getText(R.string.usersenha))
             alert.setTitle(getText(R.string.erro))
             alert.setIcon(ContextCompat.getDrawable(this@Login, R.drawable.xxxx))
             alert.setNeutralButton(getText(R.string.ok), null)
             alert.show()
         }






            }


    }
    private fun initializer(){
        buttonEnter = findViewById(R.id.button_Enter_Login)
        textViewEmail = findViewById(R.id.textViweUsuario)
        textViewUsuario = findViewById(R.id.textViewPassawor)

    }


}