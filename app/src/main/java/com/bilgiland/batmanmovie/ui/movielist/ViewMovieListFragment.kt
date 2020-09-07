package com.bilgiland.batmanmovie.ui.movielist

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.bilgiland.batmanmovie.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.movie_list_fragment.*
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ViewMovieListFragment : Fragment(R.layout.movie_list_fragment),
    ViewMovieListFragmentInterface {

    private var movieAdapter = MovieListAdapter()

    private val viewModel: MovieListVieModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObj()

        getData()

        observeLiveData()

    }

    override fun initObj() {
        rec_movies.apply {
            hasFixedSize()
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = movieAdapter
        }

    }

    override fun getData() {
        lifecycleScope.launch {
            viewModel.fetchData()
        }
    }

    override fun observeLiveData() {
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            movieAdapter.submitList(it)
            progress_bar.visibility = View.GONE
        })

        viewModel.error.observe(viewLifecycleOwner, {
            Log.d("tag", "observeLiveData: ")
        })

    }
}