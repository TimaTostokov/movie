package com.example.my.movie57.presenter

import com.example.my.movie57.model.MovieApi
import com.example.my.movie57.model.MovieModel
import com.example.my.movie57.view.MovieView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Presenter @Inject constructor(private val movieApi: MovieApi) {

    private lateinit var movieView: MovieView

    fun getMovieDetails(name: String) {
        movieApi.getMovie(name).enqueue(object : Callback<MovieModel> {
            override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                response.body()?.let {
                    movieView.showMovie(it)
                }
            }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                movieView.showError(t.message.toString())
            }
        })
    }

    fun attachView(movieView: MovieView) {
        this.movieView = movieView
    }

}