package com.vama.network

import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object NetworkManger {

    @Synchronized
    fun <S> createService(
        serviceClass: Class<S>,
        timeOut: Long = NetworkManagerConfigurations.configuration.readTimeOut
    ): S {
        return getRetrofitBuilder()
            .client(initOkHttpClientBuilder(timeOut).build())
            .build()
            .create(serviceClass)
    }

    private fun initOkHttpClientBuilder(timeOut: Long): OkHttpClient.Builder {
        return OkHttpClient.Builder().apply {
            if (NetworkManagerConfigurations.configuration.isDebug) {
                val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                if (!interceptors().contains(logging))
                    addInterceptor(logging)
            }
            readTimeout(timeOut, TimeUnit.SECONDS)
            connectTimeout(timeOut, TimeUnit.SECONDS)
            writeTimeout(NetworkManagerConfigurations.configuration.writeTimeOut, TimeUnit.SECONDS)
            connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
            retryOnConnectionFailure(true)
        }
    }

    private fun getRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(NetworkManagerConfigurations.configuration.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
    }
}