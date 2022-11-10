package com.cevdetyilmaz.invitefriendcase.feature.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.cevdetyilmaz.invitefriendcase.R
import com.cevdetyilmaz.invitefriendcase.common.viewBinding
import com.cevdetyilmaz.invitefriendcase.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setNavGraph()
    }

    private fun setNavGraph() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.layFragmentContainer) as NavHostFragment?
                ?: return

        with(navHostFragment.navController) {
            appBarConfiguration = AppBarConfiguration(graph)
            supportActionBar?.hide()
            setupActionBarWithNavController(this, appBarConfiguration)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        navHostFragment.navController.navigateUp()
        return super.onSupportNavigateUp()
    }
}