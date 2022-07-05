package com.example.counter


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner=this
        binding.viewmodel=viewModel

        //데이터 바인딩을 사용하면 이제 필요 없음.
        //viewModel.countLiveData.observe(this@MainActivity, Observer {
        //   binding.counterText.text="$it"
        //})
        Log.d(TAG,"onCreate")
    }

    companion object{
        val TAG=MainActivity::class.java.simpleName
    }
}