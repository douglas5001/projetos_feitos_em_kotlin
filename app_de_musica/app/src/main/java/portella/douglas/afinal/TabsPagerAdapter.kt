package portella.douglas.afinal

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabsPagerAdapter (fragmentManager: FragmentManager,
                    lifecycle: Lifecycle,
                        private var numberOfTabs: Int) : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                val fragment1 = Fragment1.newInstance("title fragment 1", "xxx")
                return fragment1
            }
            1 -> {
                val fragment2 = Fragment2.newInstance("title fragment 2", "zzz")
                return fragment2
            }
            else -> return Fragment1()

        }
    }




    override fun getItemCount(): Int {
        return numberOfTabs
    }

}