package pet.ui.des.com

import android.app.Activity
import android.content.Context
import android.content.Intent
import pet.ui.des.com.acts.DynamicActivity
import pet.ui.des.com.acts.MenusActivity
import pet.ui.des.com.acts.menus.bottomnavs.MainBottomAppBarActivity
import pet.ui.des.com.acts.menus.bottomnavs.MainBottomNavActivity
import pet.ui.des.com.acts.menus.drawer.MainDrawerActivity

/**
 * copyright Pi Softwares
 * Created by Petros Woldemichael
 * on 25,07,2023
 * USA, MD
 */

class Starter(private val CLASS : Class<*>) {

  var bundle : Map<String , String> = hashMapOf()

  companion object {

    val MENUS = Starter(MenusActivity::class.java)
    val DRAWER = Starter(MainDrawerActivity::class.java)
    val DYNAMIC = Starter(DynamicActivity::class.java)
    val BOTTOMNAV = Starter(MainBottomNavActivity::class.java)
    val BOTTOMAPPBAR = Starter(MainBottomAppBarActivity::class.java)
  }

  fun setBundle(bundle : Map<String , String> = hashMapOf()) : Starter {
    this.bundle = bundle
    return this
  }

  fun startWithAnim(activity : Activity) : Starter {
    start(activity , Intent(activity , CLASS))
    return this
  }

  fun start(activity : Activity) {
    if(bundle.isEmpty()) start(activity , Intent(activity , CLASS))
    else start(activity , bundle)
  }

  fun start(activity : Activity , mapOf : Map<String , String>) {
    val i = Intent(activity , CLASS)
    mapOf.forEach {
      i.putExtra(it.key , it.value)
    }
    start(activity , i)
  }

  fun start(activity : Activity , intent : Intent) {
    activity.startActivity(intent)
    withSlideHorizintal(activity)
  }

  fun withFade(activity : Activity) : Starter {
    activity.overridePendingTransition(R.anim.activity_enter , R.anim.activity_exit)
    return this
  }

  fun withSlideHorizintal(activity : Activity) {
    activity.overridePendingTransition(R.anim.activity_enter , R.anim.no_change)
  }

  fun withSlideVertical(activity : Activity) {
    activity.overridePendingTransition(R.anim.slide_up , R.anim.no_change)
  }
}