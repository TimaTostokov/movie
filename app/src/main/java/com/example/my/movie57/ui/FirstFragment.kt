package com.example.my.movie57.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.my.movie57.R
import com.example.my.movie57.databinding.FragmentFirstBinding
import com.example.my.movie57.model.MovieModel
import com.example.my.movie57.presenter.Presenter
import com.example.my.movie57.view.MovieView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

//    @Inject
//    lateinit var presenter: Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        binding.btnSend.setOnClickListener {
//            presenter.getMovieDetails(binding.etMovie.text.toString())
            if (binding.etMovie.length() != 0) {
                navigateTo(binding.etMovie.text.toString())
            } else {
                Toast.makeText(requireActivity(), "Null Movie", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateTo(movieTitle: String) {
        val titleMovie = movieTitle
        findNavController().navigate(R.id.secondFragment, bundleOf("key_search" to titleMovie))
    }

}


