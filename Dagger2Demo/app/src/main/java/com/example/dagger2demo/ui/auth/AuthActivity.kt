package com.example.dagger2demo.ui.auth

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.dagger2demo.R
import com.example.dagger2demo.models.User
import com.example.dagger2demo.ui.main.MainActivity
import com.example.dagger2demo.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject
import javax.inject.Named

class AuthActivity : DaggerAppCompatActivity() {

    private lateinit var viewModel: AuthViewModel

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var logo: Drawable

    @Inject
    lateinit var requestManager: RequestManager

    @Inject
    @Named("app_user")
    lateinit var user1: User

    @Inject
    @Named("auth_user")
    lateinit var user2: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        /*Old Way - Artık yapmaya gerek yok.
        AndroidInjection.inject(this)*/

        viewModel = ViewModelProvider(this,providerFactory).get(AuthViewModel::class.java)

        login_button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            //viewModel.authenticateWithId(user_id_input.text.toString().toInt())
        }

        setLogo()

        subscribeObservers()

    }

    private fun setLogo(){
        requestManager.load(logo).into(login_logo)
    }
    private fun subscribeObservers(){
        viewModel.observeUser().observe(this, Observer {
            it?.let { Log.d("AuthActivity",it.toString()) }
        })
    }
}
