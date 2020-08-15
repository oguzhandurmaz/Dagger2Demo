package com.example.dagger2demo

import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.Observer
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity: DaggerAppCompatActivity() {
    //Herhangi bir logout olduğunda subscribeObserverla onu algılıyoruz.


    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

    }

    private fun subscribeObservers(){
        sessionManager.getAuthUser().observe(this, Observer {


            //If not authed - AuthAcitivity i aç. Şeklinde.
        })
    }
}