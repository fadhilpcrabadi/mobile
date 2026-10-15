package com.example.fadhil3tie.Home.pertemuan_7

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.fadhil3tie.databinding.ActivitySevenBinding

class SevenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySevenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySevenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar & Back Button
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Pertemuan 7"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        replaceFragment(SatuFragment())

        // Setup event click untuk mengganti fragment
        binding.btnFragment1.setOnClickListener {
            replaceFragment(SatuFragment())
        }

        binding.btnFragment2.setOnClickListener {
            replaceFragment(DuaFragment())
        }

        binding.btnFragment3.setOnClickListener {
            replaceFragment(TigaFragment())
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
//            .addToBackStack(null)
            .commit()
    }
}
