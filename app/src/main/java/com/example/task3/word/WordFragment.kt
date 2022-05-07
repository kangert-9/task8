package com.example.task3.word

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.task3.App.Companion.router
import com.example.task3.R
import com.example.task3.databinding.FragmentWordBinding
import com.example.task3.mvpuser.TranslateScreen
import com.example.task3.viewById


class WordFragment : Fragment() {

    private val button by viewById<Button>(R.id.button)
    private val word by viewById<EditText>(R.id.text_in)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            router.navigateTo(TranslateScreen(word.text.toString()))
        }
    }

    companion object {
        fun newInstance(): Fragment = WordFragment()
    }
}