package pet.ui.des.com.acts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewbinding.ViewBinding
import pet.ui.des.com.BaseActivity
import pet.ui.des.com.MainActivity
import pet.ui.des.com.R
import pet.ui.des.com.Starter
import pet.ui.des.com.adapters.MainMenuAdapter
import pet.ui.des.com.databinding.ActivityMainBinding
import pet.ui.des.com.databinding.ActivityMenusBinding
import pet.ui.des.com.enums.ListOrientation
import pet.ui.des.com.helpers.RecyclerHelper
import pet.ui.des.com.models.MenuLayout
import pet.ui.des.com.set

class MenusActivity : BaseActivity() {

  val menuLayoutList = arrayListOf(
    MenuLayout("Drawer Menu" , R.drawable.menu_drawer, Starter.DRAWER) ,
    MenuLayout("Bottom Navigation" , R.drawable.bottom_navigation, Starter.BOTTOMNAV) ,
    MenuLayout("Bottom App Bar" , R.drawable.bottom_app_bar,  Starter.BOTTOMAPPBAR)
  )

  private val binding : ActivityMenusBinding by lazy { ActivityMenusBinding.inflate(layoutInflater) }
  private val recyclerHelper : RecyclerHelper by lazy { RecyclerHelper(this , binding.recycler, menuLayoutList) }

  override fun initializeActivity() {
    binding.toolbar.title.set("Menus")
    binding.toolbar.back.setOnClickListener {
      callOnBackPressed()
    }
    recyclerHelper.virticalListView()
  }

  override fun getCurrentViewBinding() : ActivityMenusBinding {
    return binding
  }


}