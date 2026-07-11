package com.littleapp.meals.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.littleapp.meals.pojo.Meal

@Database(entities = [Meal::class], version = 1, exportSchema = false)
abstract class MealDatabase : RoomDatabase() {
    abstract fun mealDao(): MealDao
}