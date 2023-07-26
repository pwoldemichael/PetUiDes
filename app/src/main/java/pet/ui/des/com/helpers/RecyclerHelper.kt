package pet.ui.des.com.helpers

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import pet.ui.des.com.adapters.MainMenuAdapter
import pet.ui.des.com.enums.ListOrientation
import pet.ui.des.com.models.MenuLayout

/**
 * copyright Pi Softwares
 * Created by Petros Woldemichael
 * on 26,07,2023
 * USA, MD
 */
class RecyclerHelper(private val context : AppCompatActivity ,
                     private val recycler : RecyclerView ,
                     private val menuLayoutList : ArrayList<MenuLayout>) {

  fun update(or:ListOrientation){
    when(or){
      ListOrientation.GRID->gridListView()
      ListOrientation.HORIZONTAL->horizontalListView()
      ListOrientation.VERTICAL->virticalListView()
    }
  }

  fun gridListView() {
    recycler.layoutManager = StaggeredGridLayoutManager(3 , StaggeredGridLayoutManager.VERTICAL)
    recycler.adapter = MainMenuAdapter(context , menuLayoutList , ListOrientation.GRID)
  }

  fun virticalListView() {
    recycler.layoutManager = LinearLayoutManager(context)
    recycler.adapter = MainMenuAdapter(context , menuLayoutList , ListOrientation.VERTICAL)
  }

  fun horizontalListView() {
    recycler.layoutManager = LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , false)
    recycler.adapter = MainMenuAdapter(context , menuLayoutList , ListOrientation.HORIZONTAL)
  }

}