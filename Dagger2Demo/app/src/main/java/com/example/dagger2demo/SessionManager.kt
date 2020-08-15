package com.example.dagger2demo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.example.dagger2demo.models.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(){

    private val cachedUser = MediatorLiveData<Result<User>>()


    fun authWithId(source: LiveData<Result<User>>){
        if(cachedUser.value != null){
            cachedUser.value = Result.Loading(null)
            cachedUser.addSource(source, Observer {
                cachedUser.value = it
                cachedUser.removeSource(source)
            })
        }
    }

    fun logOut(){
        cachedUser.value = Result.NotAuthed("out")
    }
    fun getAuthUser(): LiveData<Result<User>>{
        return cachedUser
    }


}