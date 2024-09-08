package com.example.mycomposeapp.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoviesModel(
    val movieId : Int = 0,
    val movieName : String = "",
    @DrawableRes
    val poster : Int = 0,
    val description :String = "",
):Parcelable
