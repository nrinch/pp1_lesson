package na.severinchik.lesson5

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.forEach
import na.severinchik.data.lesson5.UserDTO
import na.severinchik.lesson5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private var _binding: ActivityMainBinding? = null

    private val binding get() = _binding!!

    private val adapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(
            LayoutInflater.from(
                this
            )
        )

        setContentView(binding.root)

        binding.amList.adapter = adapter


//        val button: Button = findViewById(R.id.am_counter_btn)
        binding.amCounterBtn.setOnClickListener {
            viewModel.updateCounter()

            viewModel.insertUser(
                UserDTO(
                    "John ${viewModel.fetchCounter()}",
                    viewModel.fetchCounter(),
                    "Lenin str. 42"
                )
            )
        }

//        binding.amCounterTv.text = "Current value ${viewModel.fetchCounter()}"
        binding.amCounterTv.text = getString(R.string.counter_template, viewModel.fetchCounter())

        viewModel.counter.observe(this, { counter ->
            binding.amCounterTv.text = getString(R.string.counter_template, counter)
        })

        lifecycleScope.launchWhenCreated {
            viewModel.users.collect { list ->
                adapter.submitList(list)
                adapter.notifyDataSetChanged()
            }
        }

    }

    override fun onStop() {
        super.onStop()
        _binding = null
    }
}