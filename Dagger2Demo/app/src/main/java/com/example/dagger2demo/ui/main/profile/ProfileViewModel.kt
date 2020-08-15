package com.example.dagger2demo.ui.main.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.dagger2demo.Result
import com.example.dagger2demo.SessionManager
import com.example.dagger2demo.models.User
import javax.inject.Inject

class ProfileViewModel @Inject constructor(val sessionManager: SessionManager): ViewModel() {

    init {
        Log.d("MainActivity","ProfileViewModel is ready...")
    }

    fun getAuthenticatedUser(): LiveData<Result<User>>{
        return sessionManager.getAuthUser()
    }
}