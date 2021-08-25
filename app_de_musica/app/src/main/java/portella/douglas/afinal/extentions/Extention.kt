package portella.douglas.afinal.extentions

import android.app.Activity
import android.widget.Toast
import portella.douglas.afinal.Fragment1

fun Activity.toast(message: String){
    Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
}

fun Activity.toast(message: Int){
    Toast.makeText(baseContext, getText(message), Toast.LENGTH_LONG).show()
}