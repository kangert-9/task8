package com.example.task3.word

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object WordScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        WordFragment.newInstance()
}