package ke.co.propscout.weatherstock.ui.weather.current

import ke.co.propscout.weatherstock.R
import ke.co.propscout.weatherstock.databinding.CurrentWeatherFragmentBinding
import ke.co.propscout.weatherstock.ui.BaseFragment

class CurrentWeatherFragment :
    BaseFragment<CurrentWeatherFragmentBinding, CurrentWeatherViewModel>() {
    override fun getViewModel() = CurrentWeatherViewModel::class.java
    override fun getFragmentLayout() = R.layout.current_weather_fragment
}