package com.husar.intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.husar.intent.model.Item


class Detail1Activity : AppCompatActivity() {

    private lateinit var item: Item
    private lateinit var icon: ImageView
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail1)

        // Get object
        item = intent.getParcelableExtra("item")

        // Assign textView
        icon = findViewById(R.id.imageView1)
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)

        // Set text

        textView1.setText(item.title)
        textView2.setText(item.description)
    }
}
