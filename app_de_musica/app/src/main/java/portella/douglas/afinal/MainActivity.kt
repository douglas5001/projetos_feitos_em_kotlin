package portella.douglas.afinal

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var buttonPlay: Button
    private lateinit var buttonPause: Button


    private val framentManeger : FragmentManager = supportFragmentManager
    private  lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment()






    }



    private fun fragment() {


        tab_layout.setSelectedTabIndicatorColor(Color.RED)
        tab_layout.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        tab_layout.tabTextColors = ContextCompat.getColorStateList(this, android.R.color.white)


        val numberOfTabs = 2

        tab_layout.isInlineLabel = true

        val adapter = TabsPagerAdapter(supportFragmentManager, lifecycle, numberOfTabs)

        view_pager2.adapter = adapter
        view_pager2.isUserInputEnabled = true

        TabLayoutMediator(tab_layout, view_pager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "${baseContext.getString(R.string.musicas)}"
                    // tab.setIcon(android.R.drawable.ic_dialog_info)
                }
                1 -> {
                    tab.text = "${baseContext.getString(R.string.favoritos)}"
                    // tab.setIcon(android.R.drawable.ic_dialog_info)
                }
            }

            tab.icon?.colorFilter =
                BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                    Color.WHITE,
                    BlendModeCompat.SRC_ATOP
                )

        }.attach()


    }




    }






