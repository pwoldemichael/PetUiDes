package pet.ui.des.com.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import pet.ui.des.com.Disable
import pet.ui.des.com.Enable
import pet.ui.des.com.R
import pet.ui.des.com.databinding.ActivityProductTestBinding

class ProductTest : AppCompatActivity() {

  class Product(var name : String ,
                var description : String ,
                var dep : String ,
                var cat : String ,
                var subcat : String ,
                var detail : ArrayList<HashMap<String , Any>> ,
                var images : ArrayList<String> ,
                var shippingOnOff : Boolean ,
                var address : String)

  private var data : MutableLiveData<Product> = MutableLiveData(
    Product("" , "" , "" , "" , "" , arrayListOf(), arrayListOf() , false , ""))

  private lateinit var binding : ActivityProductTestBinding

  override fun onCreate(savedInstanceState : Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityProductTestBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.viewpager.isUserInputEnabled = false
    // The pager adapter, which provides the pages to the view pager widget.
    val pagerAdapter = ScreenSlidePagerAdapter(this)
    binding.viewpager.adapter = pagerAdapter
    binding.viewpager.setPageTransformer(ZoomOutPageTransformer())
    binding.chipback.Disable()
    binding.chipnext.Disable()
    binding.progressBar.max = NUM_PAGES


    data.observe(this) { data_e ->
      when(binding.viewpager.currentItem) {
        0 -> {
          if(data_e.name.isNotEmpty() && data_e.description.isNotEmpty()) binding.chipnext.Enable()
          else binding.chipnext.Disable()
        }

        1 -> {
          if(data_e.dep.isNotEmpty() && data_e.cat.isNotEmpty() && data_e.subcat.isNotEmpty() && data_e.detail.isNotEmpty()) binding.chipnext.Enable()
          else binding.chipnext.Disable()
        }

        2 -> {
          if(data_e.images.isNotEmpty()) binding.chipnext.Enable()
          else binding.chipnext.Disable()
        }

        3 -> {
          if(data_e.shippingOnOff) {
            if(data_e.address.isNotEmpty()) binding.chipnext.Enable()
            else binding.chipnext.Disable()
          }else binding.chipnext.Enable()
        }
        else -> {}
      }
    }

    binding.chipnext.setOnClickListener {
      val next = binding.viewpager.currentItem + 1
      requestNext(next)
    }
    binding.chipback.setOnClickListener {
      val back = onBackRequest()
      if(back == 0) binding.chipback.Disable()
    }
  }

  private fun requestNext(next : Int) {
    if(next < NUM_PAGES) {
      binding.viewpager.currentItem = next
      binding.progressBar.progress = next
      binding.chipback.Enable()
    }
  }

  private fun onBackRequest() : Int {
    val back = binding.viewpager.currentItem - 1
    if(back >= 0) {
      binding.viewpager.currentItem = back
      binding.progressBar.progress = back
    }
    return back
  }

  /**
   * The number of pages (wizard steps) to show in this demo.
   */
  val NUM_PAGES = 4

  /**
   * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
   * sequence.
   */
  private inner class ScreenSlidePagerAdapter(fa : FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() : Int = NUM_PAGES
    override fun createFragment(position : Int) : Fragment {
      return when(position) {
        0 -> NameDescriptionFragment()
        1 -> CategoryFragment()
        2 -> ImagesFragment()
        3 -> ShippingStagingFragment()
        else -> NameDescriptionFragment()
      }
    }
  }

  class ZoomOutPageTransformer : ViewPager2.PageTransformer {

    companion object {

      private const val MIN_SCALE = 0.85f
      private const val MIN_ALPHA = 0.5f
    }

    override fun transformPage(view : View , position : Float) {
      view.apply {
        val pageWidth = width
        val pageHeight = height
        when {
          position < - 1 -> { // [-Infinity,-1)
            // This page is way off-screen to the left.
            alpha = 0f
          }

          position <= 1 -> { // [-1,1]
            // Modify the default slide transition to shrink the page as well.
            val scaleFactor = Math.max(MIN_SCALE , 1 - Math.abs(position))
            val vertMargin = pageHeight * (1 - scaleFactor) / 2
            val horzMargin = pageWidth * (1 - scaleFactor) / 2
            translationX = if(position < 0) {
              horzMargin - vertMargin / 2
            } else {
              horzMargin + vertMargin / 2
            }

            // Scale the page down (between MIN_SCALE and 1).
            scaleX = scaleFactor
            scaleY = scaleFactor

            // Fade the page relative to its size.
            alpha = (MIN_ALPHA + (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))
          }

          else -> { // (1,+Infinity]
            // This page is way off-screen to the right.
            alpha = 0f
          }
        }
      }
    }
  }
}