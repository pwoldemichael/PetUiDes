package pet.ui.des.com.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import pet.ui.des.com.MainActivity
import pet.ui.des.com.R
import pet.ui.des.com.databinding.MainUiListViewBinding
import pet.ui.des.com.dpToPx
import pet.ui.des.com.enums.ListOrientation
import pet.ui.des.com.models.MenuLayout

/**
 * copyright Pi Softwares
 * Created by Petros Woldemichael
 * on 26,07,2023
 * USA, MD
 */

class MainMenuAdapter(var c : AppCompatActivity , var list : ArrayList<MenuLayout> , var o : ListOrientation) :
  RecyclerView.Adapter<MainMenuAdapter.MainMenuViewHolder>() {

  override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : MainMenuViewHolder {
    val view : View = LayoutInflater.from(parent.context).inflate(R.layout.main_ui_list_view , parent , false)
    return MainMenuViewHolder(view)
  }

  override fun getItemCount() : Int = list.size

  override fun onBindViewHolder(holder : MainMenuViewHolder , position : Int) {
    var param = when(o) {
      ListOrientation.HORIZONTAL -> ViewGroup.LayoutParams( dpToPx(300f) ,  ViewGroup.LayoutParams.MATCH_PARENT)
      ListOrientation.VERTICAL -> ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , dpToPx(100f))
      ListOrientation.GRID -> ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT ,  dpToPx(150f))
    }
    val marginLayoutParams = LinearLayout.LayoutParams(param)
    marginLayoutParams.setMargins(dpToPx(5f) , dpToPx(5f) , dpToPx(5f) , dpToPx(5f))

    holder.binding.menuselect.layoutParams = param
    holder.binding.menuselect.layoutParams = marginLayoutParams
    holder.binding.menuname.text = list[position].text
    holder.binding.imageView2.setImageDrawable(ContextCompat.getDrawable(c , list[position].drawable))
    holder.binding.itemselect.setOnClickListener {
      list[position].starter.start(c)
    }
  }

  class MainMenuViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val binding by lazy { MainUiListViewBinding.bind(view) }
  }
}