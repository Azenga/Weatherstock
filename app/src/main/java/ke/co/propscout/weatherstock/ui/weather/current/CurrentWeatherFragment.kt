package ke.co.propscout.weatherstock.ui.weather.current

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import ke.co.propscout.weatherstock.R
import ke.co.propscout.weatherstock.data.network.ConnectivityInterceptorImpl
import ke.co.propscout.weatherstock.data.network.WeatherApiService
import ke.co.propscout.weatherstock.data.network.WeatherDataSourceImpl
import ke.co.propscout.weatherstock.data.network.response.CurrentWeatherResponse
import ke.co.propscout.weatherstock.databinding.CurrentWeatherFragmentBinding
import ke.co.propscout.weatherstock.ui.BaseFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CurrentWeatherFragment :
    BaseFragment<CurrentWeatherFragmentBinding, CurrentWeatherViewModel>() {
    override fun getViewModel() = CurrentWeatherViewModel::class.java
    override fun getFragmentLayout() = R.layout.current_weather_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val weatherApiService = WeatherApiService(ConnectivityInterceptorImpl(requireContext()))

        val dataSourceImpl = WeatherDataSourceImpl(weatherApiService)

        dataSourceImpl.response.observe(viewLifecycleOwner, Observer { currentWeatherResponse ->
            updateUI(currentWeatherResponse)
        })

        lifecycleScope.launch(Dispatchers.IO) {
            dataSourceImpl.getCurrentWeather("Mombasa")
        }

    }

    private fun updateUI(currentWeatherResponse: CurrentWeatherResponse?) {
        binding.response = currentWeatherResponse.toString()
    }
}