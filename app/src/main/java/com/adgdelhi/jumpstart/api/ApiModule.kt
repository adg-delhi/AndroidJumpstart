package com.adgdelhi.jumpstart.api

import com.adgdelhi.android.BuildConfig
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by abhishek
 * on 05/04/16.
 */
class ApiModule {

    companion object {
        fun providesApiService(moshi: Moshi): ApiService {
            val builder = OkHttpClient.Builder()
            // TODO: 08/04/16 might want to remove this in prod
            builder.hostnameVerifier { str, sslSession -> true }

            builder.connectTimeout(30, TimeUnit.SECONDS)
            builder.readTimeout(30, TimeUnit.SECONDS)
            builder.writeTimeout(30, TimeUnit.SECONDS)

            // Add headers
            builder.interceptors().add(Interceptor { chain ->
                var request = chain.request()

                request = request.newBuilder()
                    // // TODO: 08/04/16 add project specific stuff here
                    .build()
                chain.proceed(request)
            })

            // Logging
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.interceptors().add(interceptor)

            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(builder.build())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}