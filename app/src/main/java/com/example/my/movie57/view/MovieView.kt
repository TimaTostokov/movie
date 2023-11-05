package com.example.my.movie57.view

import com.example.my.movie57.model.MovieModel

interface MovieView {

    fun showMovie(movieModel: MovieModel)
    fun showError(message:String)

}