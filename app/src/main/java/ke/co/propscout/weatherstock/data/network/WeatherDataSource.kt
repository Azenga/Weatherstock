package ke.co.propscout.weatherstock.data.network

import androidx.lifecycle.LiveData
import ke.co.propscout.weatherstock.data.network.response.CurrentWeatherResponse

interface WeatherDataSource {
    val response: LiveData<CurrentWeatherResponse>
    suspend fun getCurrentWeather(location: String)
}