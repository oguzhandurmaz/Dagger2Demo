package com.example.dagger2demo.di

import com.example.dagger2demo.di.auth.AuthModule
import com.example.dagger2demo.di.auth.AuthScope
import com.example.dagger2demo.di.auth.AuthViewModelsModule
import com.example.dagger2demo.di.main.MainFragmentBuildersModule
import com.example.dagger2demo.di.main.MainModule
import com.example.dagger2demo.di.main.MainScope
import com.example.dagger2demo.di.main.MainViewModelsModule
import com.example.dagger2demo.ui.auth.AuthActivity
import com.example.dagger2demo.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

//Sadece Activity'leri koyuyoruz.
@Module
abstract class ActivityBuildersModule {
    //Diğer bütün activityleri buranın içine bu şekilde tanımlamamız lazım.

    //Bunu kullanıyorsak class abstract olacak -- @ContributesAndroidInjector
    @AuthScope
    @ContributesAndroidInjector(
        modules =
        [
            AuthViewModelsModule::class,
            AuthModule::class
        ]
    )
    abstract fun contributeAuthActivity(): AuthActivity

    @MainScope
    @ContributesAndroidInjector(
        modules =
        [
            MainFragmentBuildersModule::class,
            MainViewModelsModule::class,
            MainModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity


}