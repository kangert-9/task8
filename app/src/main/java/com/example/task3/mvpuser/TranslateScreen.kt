package com.example.task3.mvpuser

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class TranslateScreen(private val word: String): FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        TranslateFragment.newInstance(word)
}