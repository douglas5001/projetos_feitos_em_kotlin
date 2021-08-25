package portella.douglas.afinal

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Vibrator
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.fragment_2.*
import kotlinx.android.synthetic.main.rowmusicas.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
open class Fragment2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var button_i_wall_want: TextView
    private lateinit var buttonPause: Button
    private lateinit var take_on_me: TextView
    private lateinit var never_be_alone: TextView
    private lateinit var pompei : TextView
    private lateinit var sweater_weather : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)


        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view: View = inflater.inflate(R.layout.fragment_2, container, false)
        val started : Boolean = false
         //Inicializacao
        button_i_wall_want = view.findViewById(R.id.button_all_i_want)
        take_on_me = view.findViewById(R.id.textView2)
        never_be_alone = view.findViewById(R.id.textView3)
        pompei = view.findViewById(R.id.textView4)
        sweater_weather = view.findViewById(R.id.textView5)




        //AQUI NÂOOOO

        button_i_wall_want.setOnClickListener {
            startActivity(Intent(activity, I_wlall_want::class.java))

         }


       take_on_me.setOnClickListener {
           startActivity(Intent(activity, Take_on_me_Activity::class.java))

       }

        never_be_alone.setOnClickListener {
            startActivity(Intent(activity, NeverByAlone::class.java))

        }

        pompei.setOnClickListener {
            startActivity(Intent(activity, Pompei::class.java))

        }




        return view




    }









    //AQUI NÂOOOO
    private fun stop2(sound: Int){
        mediaPlayer = MediaPlayer.create(activity!!.applicationContext, sound)
        mediaPlayer.start()

    }



    private fun play(sound: Int) {
        mediaPlayer = MediaPlayer.create(activity!!.applicationContext, sound)

        if (mediaPlayer != null && mediaPlayer.isPlaying){
            mediaPlayer.stop()
            mediaPlayer.start()

        }else{
            mediaPlayer.start()
        }



    }

    private fun stop(sound: Int) {
            mediaPlayer = MediaPlayer.create(activity!!.applicationContext, sound)
            mediaPlayer.stop()


    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)


                }
            }


    }
/**
    private fun play(sond: Int) : Context? {
        mediaPlayer = MediaPlayer.create(context?.this@Fragment2, sond)
        mediaPlayer.start()
     return context

    }
    */



    }