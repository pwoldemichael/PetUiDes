package pet.ui.des.com.acts.menus.bottomnavs

import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import pet.ui.des.com.BaseActivity
import pet.ui.des.com.R
import pet.ui.des.com.databinding.ActivityMainBottomNavBinding

class MainBottomNavActivity : BaseActivity() {

  companion object{
    val key = "key"
    val appbar = "appbar"
  }

  private val binding : ActivityMainBottomNavBinding by lazy { ActivityMainBottomNavBinding.inflate(layoutInflater) }

  override fun initializeActivity() {
    setSupportActionBar(binding.toolbarcontainer.toolbar)
    val navView : BottomNavigationView = binding.navView
    navigateInit(navView)
  }

  private fun navigateInit(navView : BottomNavigationView) {
    val navController = findNavController(R.id.nav_host_fragment_activity_main_bottom_nav)
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_home , R.id.navigation_dashboard , R.id.navigation_notifications))
    setupActionBarWithNavController(navController , appBarConfiguration)
    navView.setupWithNavController(navController)
  }

  override fun getCurrentViewBinding() : ActivityMainBottomNavBinding {
    return binding
  }

  override fun onCreateOptionsMenu(menu : Menu?) : Boolean {
    menuInflater.inflate(R.menu.main , menu)
    return true
  }

  override fun onOptionsItemSelected(item : MenuItem) : Boolean {
    if(item.itemId == R.id.action_settings) {

    }
    return super.onOptionsItemSelected(item)
  }
}