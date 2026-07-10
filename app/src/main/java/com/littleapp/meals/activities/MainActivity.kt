package com.littleapp.meals.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.littleapp.meals.R
import com.littleapp.meals.utils.DATA
import com.littleapp.meals.utils.THEME
import com.littleapp.meals.databinding.ActivityMainBinding
import com.littleapp.meals.db.MealDatabase
import com.littleapp.meals.mvvm.HomeViewModel
import com.littleapp.meals.mvvm.HomeViewModelFactory

class MainActivity : AppCompatActivity() {

    val viewModel: HomeViewModel by lazy {
        val mealDatabase = MealDatabase.getInstance(this)
        val homeViewModelFactory = HomeViewModelFactory(mealDatabase)
        ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]
    }

    private lateinit var binding: ActivityMainBinding
    private val context = this@MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        THEME.setThemeOfApp(context)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.nameSpace.text = DATA.MEALS

        val bottomNavigationView = binding.btmNav
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)

        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}