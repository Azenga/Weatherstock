package ke.co.propscout.weatherstock.data.db

import androidx.room.TypeConverter

object WeatherConverters {
    @TypeConverter
    @JvmStatic
    fun listToString(list: List<String>): String = list.joinToString()

    @TypeConverter
    @JvmStatic
    fun stringToList(str: String?): List<String> = str?.split(",") ?: emptyList()
}
