package ke.co.propscout.weatherstock.data.network.response

import com.google.gson.annotations.SerializedName
import ke.co.propscout.weatherstock.data.CurrentWeatherEntry
import ke.co.propscout.weatherstock.data.Location

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location
)