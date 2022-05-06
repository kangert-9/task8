package com.example.task3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task3.App.Companion.navigatorHolder
import com.example.task3.App.Companion.router
import com.example.task3.navigation.CustomNavigator
import com.example.task3.word.WordScreen

class MainActivity : AppCompatActivity() {
    private val navigator = CustomNavigator(activity = this, R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            router.navigateTo(WordScreen)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}