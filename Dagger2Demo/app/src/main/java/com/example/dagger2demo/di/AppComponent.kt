package com.example.dagger2demo.di

import android.app.Application
import com.example.dagger2demo.BaseApplication
import com.example.dagger2demo.SessionManager
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

//Application Scope olanları @Singleton olarak belirliyoruz.
@Singleton
@Component(
    modules =
    [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {
    /*Old Way to Inject Activity
    fun inject(activity: AuthActivity)*/

    //Uygulama boyunca erişilebilir olacak
    fun sessionManager(): SessionManager

    //Builder ı overrride ediyoruz.
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}