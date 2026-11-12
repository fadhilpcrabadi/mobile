package com.example.fadhil3tie.Home.pertemuan_11

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fadhil3tie.R
import com.example.fadhil3tie.databinding.ActivityElevenBinding
import com.google.android.material.tabs.TabLayoutMediator

class ElevenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityElevenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityElevenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Pertemuan 11"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val tabsAdapter = ElevenTabsAdapter(this)

        binding.viewPager.adapter = tabsAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Tab A"
                    // Tambah Icon
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_login)
                    // Tambah Badge Tanpa nomor (hanya titik)
                    val badge = tab.orCreateBadge
                    badge.isVisible = true
                }
                1 -> {
                    tab.text = "Tab B"
                    // Tambah Icon
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_home)
                    // Tambah Badge dengan nomor
                    val badge = tab.orCreateBadge
                    badge.isVisible = true
                    badge.number = 5
                }
            }
        }.attach()

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
}
