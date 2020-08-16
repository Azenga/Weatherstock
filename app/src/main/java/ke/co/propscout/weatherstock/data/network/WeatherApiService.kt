package ke.co.propscout.weatherstock.data.network

import ke.co.propscout.weatherstock.data.network.response.CurrentWeatherResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "http://api.weatherstack.com/"
const val API_KEY = "fd9fc202f50076cc3a03eb45d0fd4dc4"

interface WeatherApiService {

    @GET("current")
    suspend fun getCurrentWeather(
        @Query("query") location: String
    ): Response<CurrentWeatherResponse>

    companion object {
        operator fun invoke(): WeatherApiService {

            val keyRequestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(keyRequestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(WeatherApiService::class.java)
        }
    }
}