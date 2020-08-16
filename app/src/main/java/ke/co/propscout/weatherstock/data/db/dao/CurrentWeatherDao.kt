package ke.co.propscout.weatherstock.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ke.co.propscout.weatherstock.data.db.entity.CURRENT_WEATHER_RECORD_ID
import ke.co.propscout.weatherstock.data.db.entity.CurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(currentWeatherEntry: CurrentWeatherEntry)

    @Query("SELECT * FROM current_weather WHERE id = $CURRENT_WEATHER_RECORD_ID")
    fun getCurrentWeather(): LiveData<CurrentWeatherEntry>
}