package com.example.dagger2demo.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.dagger2demo.models.User
import com.example.dagger2demo.network.auth.AuthApi
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(val authApi: AuthApi): ViewModel() {

    private val authUser = MediatorLiveData<User>()

    init {
        Log.d("AuthActivity","ViewModel is working...")

    }

    fun authenticateWithId(userId: Int){
        val source = LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(userId)
                .subscribeOn(Schedulers.io())
        )
        authUser.addSource(source,object: androidx.lifecycle.Observer<User>{
            override fun onChanged(t: User?) {
                authUser.value = t
                authUser.removeSource(source)
            }

        })
    }

    fun observeUser(): LiveData<User>{
        return authUser
    }
}