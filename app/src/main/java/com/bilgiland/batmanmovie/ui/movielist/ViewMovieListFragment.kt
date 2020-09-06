package com.bilgiland.batmanmovie.ui.movielist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bilgiland.batmanmovie.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.movie_list_fragment.*
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ViewMovieListFragment : Fragment(R.layout.movie_list_fragment),
    ViewMovieListFragmentInterface {


    private val viewModel: MovieListVieModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObj()

        getData()

    }

    override fun initObj() {
        rec_movies.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(requireContext())
            adapter = MovieListAdapter()
        }

    }

    override fun getData() {
        lifecycleScope.launch {
            viewModel.fetchData()
        }
    }
}