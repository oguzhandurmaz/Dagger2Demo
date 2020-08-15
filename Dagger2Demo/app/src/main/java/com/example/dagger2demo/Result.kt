package com.example.dagger2demo

import android.location.GnssNavigationMessage
import java.lang.Exception

sealed class Result<out T> {

    data class Success<out T>(val data: T): Result<T>()
    data class Error<out T>(val exception: Throwable,val message: String): Result<T>()
    data class Loading<out T>(val message: String?): Result<T>()
    data class Authed<out T>(val message: String):Result<T>()
    data class NotAuthed<out T>(val message: String): Result<T>()

}