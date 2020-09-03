package com.example.newsletter.activities

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newsletter.R
import kotlinx.android.synthetic.main.activity_home.*



class ProfileActivity : AppCompatActivity () {
    private var PRIVATE_MODE = 0
    private val PREF_NAME = "ALFATIN"
    val KEY_username = "user-name"
    val KEY_email = "user-email"

    var sharedPref : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        sharedPref = this.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        user_profile_name.setText(sharedPref?.let{
            it.getString("user-name","")}
        )
        user_profile_email.setText(sharedPref?.let{
            it.getString("user-email","")}
        )

    }
}