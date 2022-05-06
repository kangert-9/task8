package com.example.task3.word

object WordScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        WordFragment.newInstance()
}