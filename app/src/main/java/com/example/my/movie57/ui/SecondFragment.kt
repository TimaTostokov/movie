package com.example.my.movie57.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.my.movie57.databinding.FragmentSecondBinding
import com.example.my.movie57.model.MovieModel
import com.example.my.movie57.presenter.Presenter
import com.example.my.movie57.view.MovieView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondFragment : Fragment(), MovieView {

    @Inject
    lateinit var presenter: Presenter

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        setData()
    }

    private fun setData() {
        val text = arguments?.getString("key_search")
        presenter.getMovieDetails(text.toString())
    }

    override fun showMovie(movieModel: MovieModel) {
        binding.tvTitle.text = movieModel.Title
        binding.tvYear.text = movieModel.Year
        binding.tvGenre.text = movieModel.Genre
        binding.tvAwards.text = movieModel.Awards
        binding.tvDirector.text = movieModel.Director
        binding.tvWriter.text = movieModel.Writer
        binding.tvLanguage.text = movieModel.Language
        binding.tvCountry.text = movieModel.Country
        Glide.with(binding.imgPoster).load(movieModel.Poster).into(binding.imgPoster)
        Log.e("ololo", "showMovie:$movieModel ")
    }

    override fun showError(message: String) {
        Log.e("ololo", "showError: ${message}")
        Toast.makeText(requireActivity(), "Error service", Toast.LENGTH_SHORT).show()
    }

}