package com.example.dagger2demo.di.auth

import com.example.dagger2demo.models.User
import com.example.dagger2demo.network.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class AuthModule {

    companion object {

        @AuthScope
        @Provides
        fun provideAuthApi(retrofit: Retrofit): AuthApi{
            return retrofit.create(AuthApi::class.java)
        }

        @Singleton
        @Provides
        @Named("auth_user")
        fun someUser(): User {
            return User()
        }
    }

}

