package com.geektech.homework61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.homework61.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    lateinit var etText: String

    companion object{
        private const val KEY1 = "text1"
        private const val KEY2 = "text2"
    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result -> }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        etText = intent.getStringExtra(KEY1).toString()
        binding.etText.hint = etText

        val intent = Intent(this, MainActivity::class.java)

        binding.btnClick.setOnClickListener(View.OnClickListener {
            if (binding.etText.text.toString().isEmpty()) {
                Toast.makeText(this, getString(R.string.text), Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra(KEY2, binding.etText.text.toString())
                resultLauncher.launch(intent)
            }
        })
    }
}