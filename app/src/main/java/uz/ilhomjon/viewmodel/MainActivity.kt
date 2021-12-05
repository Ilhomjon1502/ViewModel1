package uz.ilhomjon.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import uz.ilhomjon.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var myViewModel: MyViewModel
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            myViewModel = ViewModelProvider(this@MainActivity).get(MyViewModel::class.java)

            myViewModel.getUsers().observe(this@MainActivity, Observer {
                Log.d(TAG, "onCreate: $it")
                Log.d(TAG, "onCreate: ================================")
                it.forEach{
                    Log.d(TAG, "onCreate: $it")
                }
            })
        }

    }
}