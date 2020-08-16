package ke.co.propscout.weatherstock.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ke.co.propscout.weatherstock.data.network.response.CurrentWeatherResponse
import ke.co.propscout.weatherstock.internal.NoInternetException

class WeatherDataSourceImpl(private val weatherApiService: WeatherApiService) : WeatherDataSource {

    private val _response = MutableLiveData<CurrentWeatherResponse>()
    override val response: LiveData<CurrentWeatherResponse>
        get() = _response

    override suspend fun getCurrentWeather(location: String) {

        try {
            _response.postValue(weatherApiService.getCurrentWeather(location).body())
        } catch (e: NoInternetException) {
            Log.e("Connectivity", "getCurrentWeather: error", e)
        }
    }
}