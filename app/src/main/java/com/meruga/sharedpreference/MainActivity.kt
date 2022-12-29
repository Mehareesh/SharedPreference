package com.meruga.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("my_pref", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        save_btn.setOnClickListener {
            val name = name_et.text.toString()
            val age = age_et.text.toString().toInt()
            val isAdult = adult_cb.isChecked

            editor.apply {
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                apply()
            }
        }

        load_btn.setOnClickListener {
            val name = sharedPreferences.getString("name", null)
            val age = sharedPreferences.getInt("age", 0)
            val isAdult = sharedPreferences.getBoolean("isAdult", false)

            name_et.setText(name)
            age_et.setText(age.toString())
            adult_cb.isChecked = isAdult
        }
    }
}