package com.trmedia.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CustomSimpleAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var fragments : ArrayList<Fragment> = ArrayList()
    private var labels: ArrayList<String> = ArrayList()


    fun addFragment(fragment: Fragment, label: String){
        fragments.add(fragment)
        labels.add(label)
    }

    override fun getItem(position: Int): Fragment = fragments.get(position)

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence?  = labels.get(position)
}