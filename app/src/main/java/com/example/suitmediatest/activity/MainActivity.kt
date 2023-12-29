package com.example.suitmediatest.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.suitmediatest.R
import com.example.suitmediatest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCheck.setOnClickListener(this)
        binding.btnNext.setOnClickListener(this)
    }

    private fun isPalindrome(sentence: String): Boolean {
        val clearText = sentence.lowercase().replace("\\s".toRegex(), "")
        val reversedText = clearText.reversed()
        return clearText == reversedText
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_check -> {
                val sentence = binding.etSentence.text.toString()

                if (sentence.isEmpty()) {
                    binding.tilSentence.error = "Please input sentence here"
                } else {
                    if (isPalindrome(sentence)) {
                        Toast.makeText(this, "isPalindrome", Toast.LENGTH_SHORT).show()
                        binding.tilSentence.error = null
                    } else {
                        Toast.makeText(this, "not palindrome", Toast.LENGTH_SHORT).show()
                        binding.tilSentence.error = null
                    }
                }
            }

            R.id.btn_next -> {
                val name = binding.etName.text.toString()

                if (name.isEmpty()) {
                    binding.tilName.error = "Please input name here"
                } else {
                    binding.tilName.error = null
                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    intent.putExtra("name", name)
                    startActivity(intent)
                }
            }
        }
    }
}