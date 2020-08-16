package ke.co.propscout.weatherstock.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ke.co.propscout.weatherstock.data.db.dao.CurrentWeatherDao
import ke.co.propscout.weatherstock.data.db.entity.CurrentWeatherEntry

@Database(
    entities = [CurrentWeatherEntry::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(WeatherConverters::class)
abstract class WeatherstackDatabase : RoomDatabase() {

    abstract fun getCurrentWeatherDao(): CurrentWeatherDao

    companion object {

        @Volatile
        private var INSTANCE: WeatherstackDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            WeatherstackDatabase::class.java,
            "weatherstack.db"
        ).build()
    }
}