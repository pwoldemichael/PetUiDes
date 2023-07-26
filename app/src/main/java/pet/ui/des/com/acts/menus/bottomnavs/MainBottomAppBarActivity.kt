package pet.ui.des.com.acts.menus.bottomnavs

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomappbar.BottomAppBar
import pet.ui.des.com.BaseActivity
import pet.ui.des.com.R
import pet.ui.des.com.bottomsheets.BottomNavSettings
import pet.ui.des.com.databinding.ActivityMainBottomAppBarBinding
import pet.ui.des.com.databinding.ActivityMainBottomNavBinding
import pet.ui.des.com.enums.ListOrientation

class MainBottomAppBarActivity : BaseActivity() {

  private val binding : ActivityMainBottomAppBarBinding by lazy { ActivityMainBottomAppBarBinding.inflate(layoutInflater) }

  var current = ListOrientation.VERTICAL

  override fun initializeActivity() {
    setSupportActionBar(binding.toolbarcontainer.toolbar)
    setFabLocation()
    navigateInit()
  }

  private fun navigateInit() {
    val navController = findNavController(R.id.nav_host_fragment_activity_main_bottom_app_bar)
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_home , R.id.navigation_dashboard , R.id.navigation_notifications))
    setupActionBarWithNavController(navController , appBarConfiguration)
    binding.bottomAppBar.setupWithNavController(navController)
  }

  override fun getCurrentViewBinding() : ActivityMainBottomAppBarBinding {
    return binding
  }

  override fun onCreateOptionsMenu(menu : Menu?) : Boolean {
    menuInflater.inflate(R.menu.main , menu)
    return true
  }

  override fun onOptionsItemSelected(item : MenuItem) : Boolean {
    if(item.itemId == R.id.action_settings) {
      BottomNavSettings(current , this@MainBottomAppBarActivity) {
        current = it
        setFabLocation()
      }.show(supportFragmentManager , "Bottom app bar")
    }
    return super.onOptionsItemSelected(item)
  }

  private fun setFabLocation() {
    when(current) {
      ListOrientation.VERTICAL -> binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
      else -> binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
    }
  }
}