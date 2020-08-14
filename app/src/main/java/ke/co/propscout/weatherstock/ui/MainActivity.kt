package ke.co.propscout.weatherstock.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ke.co.propscout.weatherstock.R

class MainActivity : AppCompatActivity() {

    private lateinit var mAppBarConfiguration: AppBarConfiguration
    private lateinit var mNavController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        mAppBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.currentWeatherFragment,
                R.id.futureListFragment,
                R.id.settingsFragment
            )
        )

        mNavController = findNavController(R.id.fragment)

        val navView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        setupActionBarWithNavController(mNavController, mAppBarConfiguration)

        navView.setupWithNavController(mNavController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return mNavController.navigateUp(mAppBarConfiguration) || super.onSupportNavigateUp()
    }
}