package com.example.dagger2demo.ui.main.posts

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dagger2demo.SessionManager
import com.example.dagger2demo.network.main.MainApi
import javax.inject.Inject

class PostsViewModel @Inject constructor(val sessionManager: SessionManager,val mainApi: MainApi): ViewModel() {

    init{
        Log.d("MainActivity","PostsViewModel is working...")
    }


}