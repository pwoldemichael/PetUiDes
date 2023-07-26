package pet.ui.des.com

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.viewbinding.ViewBinding

abstract class BaseActivity : AppCompatActivity() {


    abstract fun initializeActivity()
    abstract fun getCurrentViewBinding(): ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val b = getCurrentViewBinding()
        setContentView(b.root)
        initializeActivity()
        if (isFullScreen())
            fullScreen()
    }

    open fun isFullScreen(): Boolean {
        return false
    }


    fun fullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            window.attributes.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

            WindowCompat.setDecorFitsSystemWindows(window, false)
            val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
            // Configure the behavior of the hidden system bars.
            windowInsetsController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            windowInsetsController.hide(WindowInsetsCompat.Type.statusBars())
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION //|| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }

    open fun hasOnBackPressed(): Boolean {
        return true
    }

    fun callOnBackPressed(){
        if (hasOnBackPressed()) {
            onBackPressedDispatcher.onBackPressed()
            @Suppress("DEPRECATION") if(Build.VERSION.SDK_INT >= 34) {
                overrideActivityTransition(Activity.OVERRIDE_TRANSITION_CLOSE , R.anim.no_change , R.anim.right_to_left)
            } else overridePendingTransition(R.anim.no_change , R.anim.right_to_left)
        }
    }

    override fun onBackPressed() {
        if (hasOnBackPressed()) {
            onBackPressedDispatcher.onBackPressed()
            @Suppress("DEPRECATION") if(Build.VERSION.SDK_INT >= 34) {
                overrideActivityTransition(Activity.OVERRIDE_TRANSITION_CLOSE , R.anim.no_change , R.anim.right_to_left)
            } else overridePendingTransition(R.anim.no_change , R.anim.right_to_left)
        }
    }
}