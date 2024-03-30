package com.project.liceriabakery

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.project.liceriabakery.data.entity.MainEntity
import com.project.liceriabakery.databinding.ActivityMainBinding
import com.project.liceriabakery.login.LoginActivity
import com.project.liceriabakery.rvlistbakery.ListAdapter
import java.net.URLEncoder

class MainActivity : AppCompatActivity(), MenuItem.OnMenuItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels {
        ViewModelFactory((application as MyApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutManager = GridLayoutManager(this,2)
        binding.rvLits.layoutManager = layoutManager
        mainViewModel.getBakery().observe(this){
            val adapter = ListAdapter(it, onPhoneClick)

            binding.rvLits.adapter = adapter
        }
    }

    private val onPhoneClick: (MainEntity)->Unit= { mainEntity ->
        try {
            val phoneNumber = " +6285235636369"
            val message = "Min, ${mainEntity.name} apakah masih ada?"
            val url = "https://api.whatsapp.com/send?phone=$phoneNumber&text=${URLEncoder.encode(message, "UTF-8")}"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)

            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "WhatsApp is not installed", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error opening WhatsApp", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        val logout = menu.findItem(R.id.logout)
        logout.setOnMenuItemClickListener(this)

        return true
    }

    override fun onMenuItemClick(p0: MenuItem): Boolean {
        return when(p0.itemId) {
            R.id.logout -> {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
                true
            }
            else -> true
        }

    }
}