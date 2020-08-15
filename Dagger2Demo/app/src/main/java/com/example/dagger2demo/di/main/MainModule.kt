package com.example.dagger2demo.di.main

import com.example.dagger2demo.network.main.MainApi
import com.example.dagger2demo.ui.main.posts.PostsRecyclerAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainModule {

    companion object{

        @MainScope
        @Provides
        fun provideMainApi(retrofit: Retrofit): MainApi{
            return retrofit.create(MainApi::class.java)
        }

        @MainScope
        @Provides
        fun provideAdapter(): PostsRecyclerAdapter{
            return PostsRecyclerAdapter()
        }
    }
}