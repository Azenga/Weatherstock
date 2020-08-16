package ke.co.propscout.weatherstock.data.network.response

import com.google.gson.annotations.SerializedName
import ke.co.propscout.weatherstock.data.db.entity.CurrentWeatherEntry
import ke.co.propscout.weatherstock.data.db.entity.Location

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location
)