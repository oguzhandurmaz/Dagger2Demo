package com.example.dagger2demo.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.dagger2demo.BaseActivity
import com.example.dagger2demo.R
import com.example.dagger2demo.ui.main.posts.PostsFragment
import com.example.dagger2demo.ui.main.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Toast.makeText(this,"Main Activity", Toast.LENGTH_SHORT).show()
        val navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this,navController,drawer_layout)
        NavigationUI.setupWithNavController(nav_view,navController)
        //nav_view.setNavigationItemSelectedListener(this)

        findNavController(R.id.nav_host_fragment).navigate(R.id.nav_profile)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController,drawer_layout)
    }

}