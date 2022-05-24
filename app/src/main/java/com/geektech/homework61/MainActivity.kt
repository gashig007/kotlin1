package com.geektech.homework61

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.homework61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var text: String
    val startActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        text = intent.getStringExtra("text1").toString()
        val intent = Intent(this, SecondActivity::class.java)
        if (text == "null"){
        }else{
            binding.etText.hint = text
        }
        binding.btnClick.setOnClickListener(View.OnClickListener {
            if (binding.etText.text.toString().isEmpty()) {
                Toast.makeText(this, "Введите слово", Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra("text", binding.etText.text.toString())
                startActivityResult.launch(intent)
            }
        })
    }
}