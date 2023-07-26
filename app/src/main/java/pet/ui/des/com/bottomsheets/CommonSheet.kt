package pet.ui.des.com.bottomsheets

import android.os.Handler
import android.os.Looper
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class CommonSheet : BottomSheetDialogFragment() {

    val handler = Handler(Looper.getMainLooper())

    protected fun customizeBottomSheetBehavior(view : View) {
        val behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        behavior.isDraggable = false
        behavior.isHideable = false
    }

    protected fun runOnUiThread(function : () -> Unit) {
        handler.post {
           function()
        }
    }

    fun showError(error : String) {
        handler.post {

        }
    }

}