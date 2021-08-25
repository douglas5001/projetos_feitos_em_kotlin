package portella.douglas.quiz.extension

import android.app.Activity
import android.widget.Toast

fun  Activity.toast(message: String){
    Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()

}

fun  Activity.toast(message: Int){
    Toast.makeText(baseContext, getText(message), Toast.LENGTH_LONG).show()

}


