package com.example.task3.word

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.task3.App.Companion.router
import com.example.task3.databinding.FragmentWordBinding
import com.example.task3.mvpuser.TranslateScreen


class WordFragment : Fragment() {

    private lateinit var viewBinding: FragmentWordBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentWordBinding.bind(view)
        viewBinding.button.setOnClickListener {
            router.navigateTo(TranslateScreen(viewBinding.textIn.text.toString()))
        }
    }

    companion object {
        fun newInstance(): Fragment = WordFragment()
    }
}