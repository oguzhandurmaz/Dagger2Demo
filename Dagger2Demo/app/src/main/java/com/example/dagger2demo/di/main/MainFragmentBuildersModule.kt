package com.example.dagger2demo.di.main

import com.example.dagger2demo.ui.main.posts.PostsFragment
import com.example.dagger2demo.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {


    @ContributesAndroidInjector
    abstract fun contributesProfileFragment(): ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributesPostsFragment(): PostsFragment

}