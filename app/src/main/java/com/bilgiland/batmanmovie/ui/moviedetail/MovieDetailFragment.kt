package com.bilgiland.batmanmovie.ui.moviedetail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.bilgiland.batmanmovie.R
import com.bilgiland.batmanmovie.data.model.MovieModel
import com.bilgiland.batmanmovie.utility.ConstValue.MOVIE_ID
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.detail_fragment.*
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MovieDetailFragment : Fragment(R.layout.detail_fragment) {

    private val viewModel: MovieDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieId = arguments?.getString(MOVIE_ID) ?: ""
        if (movieId == "")
            errorOperation()

        manageData(movieId)
    }

    private fun manageData(movieId: String) {
        lifecycleScope.launch {
            viewModel.fetchData(movieId)
        }

        viewModel.error.observe(viewLifecycleOwner, Observer {
            errorOperation()
        })

        viewModel.movie.observe(viewLifecycleOwner, {
            showData(it)
        })

    }

    private fun showData(model: MovieModel) {
        Glide.with(this).load(model.poster)
            .into(img_poster)

        movie_content.visibility = View.VISIBLE

        tv_movie_name.text = model.title

        tv_language.text = model.language

        tv_overview.text = model.plot

        tv_status.text = model.released

        progress_vote.progress = model.ratings[0].value.split("/")[0].toFloat().toInt()

        tv_progress_text.text = model.ratings[0].value.split("/")[0]
    }

    private fun errorOperation() {
        Toast.makeText(requireContext(), R.string.error_occurred, Toast.LENGTH_SHORT).show()
        activity?.onBackPressed()
    }
}