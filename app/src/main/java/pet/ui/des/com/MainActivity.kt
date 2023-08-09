package pet.ui.des.com

import com.google.android.material.dialog.MaterialAlertDialogBuilder
import pet.ui.des.com.Starter.Companion.DYNAMIC
import pet.ui.des.com.Starter.Companion.MENUS
import pet.ui.des.com.Starter.Companion.TEST
import pet.ui.des.com.bottomsheets.RecyclerSettings
import pet.ui.des.com.databinding.ActivityMainBinding
import pet.ui.des.com.helpers.RecyclerHelper
import pet.ui.des.com.models.MenuLayout

class MainActivity : BaseActivity() {

  val menuLayoutList = arrayListOf(
    MenuLayout("Dynamic Layouts" , R.drawable.dynamic , DYNAMIC) ,
    MenuLayout("Menu Activities" , R.drawable.bottom_sheets , MENUS) ,
    MenuLayout("Bottom Sheets" , R.drawable.bottom_sheets , MENUS) ,
    MenuLayout("Dialog" , R.drawable.dialogs , MENUS) ,
    MenuLayout("Vertical List" , R.drawable.view_list , MENUS) ,
    MenuLayout("Grid List" , R.drawable.grid_view , MENUS) ,
    MenuLayout("Slide View" , R.drawable.viewpager , MENUS) ,
    MenuLayout("Tab View" , R.drawable.tabs , MENUS) ,
    ///////////////////////////////
  )
  private val binding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
  private val recyclerHelper : RecyclerHelper by lazy { RecyclerHelper(this , binding.recycler , menuLayoutList) }

  override fun initializeActivity() {

    TEST.start(this)
    return


    binding.recsetting.setOnClickListener {
      RecyclerSettings(this@MainActivity){
        recyclerHelper.update(it)
      }.show(supportFragmentManager,"recycler settings")
    }

    recyclerHelper.gridListView()
    MaterialAlertDialogBuilder(this)
      // Add customization options here
      .setTitle("Welcome").setMessage("Hi, this is some example views.").setPositiveButton("contact me") { b , k -> }
      .setNegativeButton("dismiss") { b , k -> }.show()
  }

  override fun getCurrentViewBinding() : ActivityMainBinding {
    return binding
  }

}

