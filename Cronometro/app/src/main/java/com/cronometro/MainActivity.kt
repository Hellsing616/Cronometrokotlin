package com.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    var running  = false
    var pause: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iniciar.setOnClickListener() {
            iniciarChronemetro()
        }

        binding.pausar.setOnClickListener() {
            pausarChronemetro()
        }

        binding.zerar.setOnClickListener() {
            zerarChronemetro()
        }
    }

    private fun iniciarChronemetro(){
      if (!running){
          binding.cronometro.base = SystemClock.elapsedRealtime() - pause
          binding.cronometro.start()
          running = true
      }
    }

    private fun pausarChronemetro(){
        if (running) {
            binding.cronometro.stop()
            pause = SystemClock.elapsedRealtime() - binding.cronometro.base
            running = false
        }
    }

    private fun  zerarChronemetro(){
        binding.cronometro.base = SystemClock.elapsedRealtime()
        pause = 0
       
    }
}