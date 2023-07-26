package pet.ui.des.com.acts.menus.drawer

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import pet.ui.des.com.BaseActivity
import pet.ui.des.com.R
import pet.ui.des.com.databinding.ActivityMainDrawerBinding

class MainDrawerActivity : BaseActivity() {

  private lateinit var appBarConfiguration : AppBarConfiguration
  private val binding : ActivityMainDrawerBinding by lazy { ActivityMainDrawerBinding.inflate(layoutInflater) }

  override fun initializeActivity() {
    setSupportActionBar(binding.appBarMain.toolbarcontainer.toolbar)
    binding.appBarMain.fab.setOnClickListener { view ->
      Snackbar.make(view , "Replace with your own action" , Snackbar.LENGTH_LONG).setAction("Action" , null).show()
    }
    val drawerLayout : DrawerLayout = binding.drawerLayout
    val navView : NavigationView = binding.navView
    val navController = findNavController(R.id.nav_host_fragment_content_main)
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home , R.id.nav_gallery , R.id.nav_slideshow) , drawerLayout)
    setupActionBarWithNavController(navController , appBarConfiguration)
    navView.setupWithNavController(navController)
  }

  override fun getCurrentViewBinding() : ActivityMainDrawerBinding {
    return binding
  }

  override fun onCreateOptionsMenu(menu : Menu) : Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.main , menu)
    return true
  }

  override fun onSupportNavigateUp() : Boolean {
    val navController = findNavController(R.id.nav_host_fragment_content_main)
    return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
  }
}