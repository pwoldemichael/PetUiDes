package pet.ui.des.com

import android.R
import android.content.res.Configuration
import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.widget.TextView

fun TextView.set(s : String) {
  this.text = s
}
fun doNothing() = Unit

fun <T> IsDarkMode(configuration : Configuration , function : () -> T) : T? {
  return if(configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES) {
    function()
  } else null
}


fun dpToPx(dp : Float) : Int {
  return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP , dp , Resources.getSystem().displayMetrics).toInt()
}

fun dpToPx(dp : Int) : Float {
  return (dp * Resources.getSystem().displayMetrics.density)
}


fun View.addRipple() = with(TypedValue()) {
  context.theme.resolveAttribute(R.attr.selectableItemBackground , this , true)
  setBackgroundResource(resourceId)
}

fun View.addCircleRipple() = with(TypedValue()) {
  context.theme.resolveAttribute(R.attr.selectableItemBackgroundBorderless , this , true)
  setBackgroundResource(resourceId)
}
