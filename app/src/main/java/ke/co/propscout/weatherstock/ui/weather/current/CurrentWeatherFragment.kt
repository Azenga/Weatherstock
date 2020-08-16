package ke.co.propscout.weatherstock.ui.weather.current

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import ke.co.propscout.weatherstock.R
import ke.co.propscout.weatherstock.data.network.WeatherApiService
import ke.co.propscout.weatherstock.data.network.response.CurrentWeatherResponse
import ke.co.propscout.weatherstock.databinding.CurrentWeatherFragmentBinding
import ke.co.propscout.weatherstock.ui.BaseFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CurrentWeatherFragment :
    BaseFragment<CurrentWeatherFragmentBinding, CurrentWeatherViewModel>() {
    override fun getViewModel() = CurrentWeatherViewModel::class.java
    override fun getFragmentLayout() = R.layout.current_weather_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val weatherApiService = WeatherApiService()

        lifecycleScope.launch(Dispatchers.IO) {


            val currentWeatherResponse = weatherApiService
                .getCurrentWeather("Nairobi").body()

            withContext(Dispatchers.Main) {

                updateUI(currentWeatherResponse)

            }

        }

    }

    private fun updateUI(currentWeatherResponse: CurrentWeatherResponse?) {
        binding.response = currentWeatherResponse.toString()
    }
}