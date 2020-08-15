package com.example.dagger2demo.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.dagger2demo.R
import com.example.dagger2demo.models.User
import com.example.dagger2demo.util.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

//Application boyunca hiç değişmeyecek obje örneklerini buraya koyuyoruz.
//Acitivity ile ilgili olmayanları buraya ekliyoruz.
@Module
class AppModule {

    companion object{

        @Singleton
        @Provides
        fun provideRetrofitInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }

        @Singleton
        @Provides
        fun provideRequestOptions(): RequestOptions{
            return RequestOptions.placeholderOf(R.drawable.background)
                .error(R.drawable.background)
        }
        @Singleton
        @Provides
        fun provideGlideInstance(application: Application,requestOptions: RequestOptions): RequestManager{
            return Glide.with(application)
                .setDefaultRequestOptions(requestOptions)
        }
        @Singleton
        @Provides
        fun provideAppDrawable(application: Application): Drawable {
            return ContextCompat.getDrawable(application,R.drawable.login_logo)!!
        }

        @Singleton
        @Provides
        @Named("app_user")
        fun someUser(): User{
            return User()
        }
    }


}