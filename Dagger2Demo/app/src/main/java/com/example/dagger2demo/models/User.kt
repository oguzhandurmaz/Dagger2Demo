package com.example.dagger2demo.models

import com.google.gson.annotations.Expose

data class User(
    @Expose
    val id: Int=0,
    val userName: String="",
    val email: String="",
    val website: String=""
)