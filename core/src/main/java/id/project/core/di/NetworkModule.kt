package id.project.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.project.core.data.source.remote.network.ApiService
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    private val hostName = "thesportsdb.com"
    private val certificatePinner = CertificatePinner.Builder()
        .add(hostName, "sha256/DCoQXF3ZpGiA5jbtT8w6fLZxMoh1PpJ3Nhh7PCE+eQ0=")
        .add(hostName, "sha256/yDu9og255NN5GEf+Bwa9rTrqFQ0EydZ0r1FCh9TdAW4=")
        .add(hostName, "sha256/hxqRlPTu1bMS/0DITB1SSu0vd4u/8l8TjPgfaAp63Gc=")
        .build()

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }

    @Provides
    fun provideApiService(client: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com//api/v1/json/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }
}