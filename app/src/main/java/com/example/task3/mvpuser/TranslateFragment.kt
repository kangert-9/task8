package com.example.task3.mvpuser

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task3.R
import com.example.task3.databinding.ViewTranslateBinding
import com.example.task3.recycler.TranslateAdapter
import com.example.task3.viewById
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.*

class TranslateFragment: Fragment() {

    private val wordAdapter = TranslateAdapter()
    private lateinit var viewBinding: ViewTranslateBinding
    private lateinit var model: TranslateViewModel
    private val recyclerView by viewById<RecyclerView>(R.id.users_recycler)


    private val word: String by lazy {
        arguments?.getString(ARG_WORD).orEmpty()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = ViewTranslateBinding.bind(view)
        iniViewModel()
    }


    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                viewBinding.loadingLayout.visibility = View.GONE
                //val recyclerView = viewBinding.usersRecycler
                val layoutManager = LinearLayoutManager(context)
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = wordAdapter
                wordAdapter.submitList(appState.data)
            }
            is AppState.Loading -> {
                viewBinding.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                viewBinding.loadingLayout.visibility = View.GONE
                Snackbar
                    .make(viewBinding.root, "Error: ${appState.error}", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload") { model.getData(word, true) }
                    .show()
            }
        }
    }

    companion object {
        private const val ARG_WORD = "arg_word"

        fun newInstance(word: String): TranslateFragment =
            TranslateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_WORD, word)
                }
            }
    }

    private fun iniViewModel() {
        val viewModel: TranslateViewModel by requireScopeActivity<ScopeActivity>().inject()

        model = viewModel
        model.subscribe().observe(this.viewLifecycleOwner) { renderData(it) }
    }
}