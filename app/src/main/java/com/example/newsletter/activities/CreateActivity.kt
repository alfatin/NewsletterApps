package com.example.newsletter.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.newsletter.R
import com.example.newsletter.entity.News
import com.example.newsletter.helper.NewsletterDBHelper
import kotlinx.android.synthetic.main.activity_creat_news.*


class CreateActivity : AppCompatActivity () {

    private val db = NewsletterDBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creat_news)
        if (intent.getStringExtra("id-extra") == ""){
            btn_insert.setOnClickListener {
                insert()
                Toast.makeText(this, "succsess Insert Data", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@CreateActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }else{
            title_create.setText(R.string.update_title)
            input_title.setText(intent.getStringExtra("title-extra"))
            input_body.setText(intent.getStringExtra("title-body"))
            input_date.setText(intent.getStringExtra("title-date"))
            btn_insert.setOnClickListener {
                update()
                Toast.makeText(this, "succsess Insert Data", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@CreateActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun insert() {
        val news = News(
            input_title.text.toString(),
            input_body.text.toString(),
            input_date.text.toString()
        )
        db.insertNews(news)
    }
    private fun update() {
        val news = News(
            input_title.text.toString(),
            input_body.text.toString(),
            input_date.text.toString()
        )
        db.updateNews(news, intent.getIntExtra("id-extra", 0))
    }

}