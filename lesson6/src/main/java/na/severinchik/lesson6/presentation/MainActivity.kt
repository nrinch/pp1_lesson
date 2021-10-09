package na.severinchik.lesson6.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.flow.collect
import na.severinchik.lesson6.R
import na.severinchik.lesson6.data.ApiResponce
import na.severinchik.lesson6.data.entity.FoodishApi
import na.severinchik.lesson6.data.entity.ResponceFoodish
import na.severinchik.lesson6.data.entity.saveAndFinish
import na.severinchik.lesson6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        lifecycleScope.launchWhenCreated {
            viewModel.urlImage.collect { responce ->
                println("-->> $responce")
                when (responce) {
                    is ApiResponce.Error -> {
                        binding.amUrlImageTx.text = "We have some error: ${responce.message}"
                    }
                    ApiResponce.Loading -> {
                        binding.amImage.visibility = View.INVISIBLE
                        binding.amUrlImageTx.text = "Loading...."
                    }
                    is ApiResponce.Success<*> -> {
                        binding.amImage.visibility = View.VISIBLE
                        val imageUrl = (responce.data as ResponceFoodish).image
                        binding.amUrlImageTx.text = imageUrl
                        setImage(imageUrl, binding.amImage)
                    }
                }


            }
        }

        binding.amFetchButton.setOnClickListener {
            fetchImage()
        }
    }

    private fun fetchImage() {
        viewModel.fetchNewImage()
    }

    private fun setImage(url: String, imageView: ImageView) {
        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.image_search)
            .centerCrop()
            .into(imageView)
    }

    override fun onStop() {
        super.onStop()
        _binding = null
    }
}