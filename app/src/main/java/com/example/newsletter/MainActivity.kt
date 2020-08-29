package com.example.newsletter

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.Toast
import androidx.core.util.PatternsCompat.EMAIL_ADDRESS
import com.example.newsletter.activities.HomeActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern



class MainActivity : AppCompatActivity() {


    private var PRIVATE_MODE = 0
    private val PREF_NAME = "ALFATIN"

    var sharedPref : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPref = this.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        btn_submit.setOnClickListener {
            validate()
        }
    }

    fun validateName() : Boolean{
        if(edit_name.text.length == 0){
            error_name.setText("Name must be filled")
            return false
        }else{
            error_name.setText(null)
            return true
        }

    }

    fun validateEmail() : Boolean {
        if (edit_email.text.length == 0) {
            error_email.setText("Email must be filled")
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(edit_email.text).matches()) {
            error_email.setText("Must match email pattern")
            return false
        } else{
            error_email.setText(null)
            return true
        }

    }

    fun validatePassword() : Boolean {
        if (edit_password.text.length == 0) {
            error_password.setText("Password must be filled")
            return false
        } else if (edit_password.text.length < 8) {
            error_password.setText("panjang oy 7 atau lebeh")
            return false
        } else {
            error_password.setText(null)
            return true
        }
    }

    fun validateGender() : Boolean{
        if(radio_group.checkedRadioButtonId == -1){
            error_gender.setText("Gender must be selected")
            return false
        }else{
            error_gender.setText(null)
            return true
        }

    }

    fun validate() {
        if (validateName() && validateEmail() && validatePassword() && validateGender()){
            Toast.makeText(  this@MainActivity,  "Success", Toast.LENGTH_LONG).show()
            val intent = Intent ( this, HomeActivity::class.java)
            val editor = sharedPref?.edit()
            editor?.putString("user-name",edit_name.text.toString())
            editor?.putString("user-email",edit_email.text.toString())
            editor?.apply()
            startActivity(intent)
        }
    }
}