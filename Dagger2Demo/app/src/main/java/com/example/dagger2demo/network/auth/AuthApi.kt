package com.example.dagger2demo.network.auth

import com.example.dagger2demo.models.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {

    @GET("users/{id}")
    fun getUser(@Path("id") userId: Int): Flowable<User>
}