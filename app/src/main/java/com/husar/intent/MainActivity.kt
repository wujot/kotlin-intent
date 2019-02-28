package com.husar.intent

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.husar.intent.model.Item

class MainActivity : AppCompatActivity() {

    // Items
    private val item1 = Item("Item 1", "An \"off the shelf\" component offers compelling functionality that you would like to reuse, but its \"view of the world\" is not compatible with the philosophy and architecture of the system currently being developed.")
    private val item2 = Item("Item 2", "A segment of the client community needs a simplified interface to the overall functionality of a complex subsystem.")
    private val item3 = Item("Item 3", "Define an object that is the \"keeper\" of the data model and/or business logic (the Subject). Delegate all \"view\" functionality to decoupled and distinct Observer objects. Observers register themselves with the Subject as they are created.")
    private val listOfItems = mutableListOf<Item>(item1, item2, item3)

    // Buttons
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var listOfButtons: MutableList<Button>
    private lateinit var mapButtonsWithItems: MutableMap<Button, Item>

    // TextViews
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var listOfTextViews: MutableList<TextView>

    // ImageViews
    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var imageView3: ImageView
    private lateinit var listOfImageViews: MutableList<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assign icons
        imageView1 = findViewById(R.id.imageView1)
        imageView2 = findViewById(R.id.imageView2)
        imageView3 = findViewById(R.id.imageView3)
        listOfImageViews = mutableListOf(imageView1, imageView2, imageView3)

        // assign text views
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        listOfTextViews = mutableListOf(textView1, textView2, textView3)

        // assign buttons
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        listOfButtons = mutableListOf(button1, button2, button3)

        mapButtonsWithItems = mutableMapOf(button1 to item1, button2 to item2, button3 to item3)

        setContent(listOfTextViews, listOfItems)

        mapButtonsWithItems(mapButtonsWithItems)
    }

    // Set content
    private fun setContent(listOfTextViews: List<TextView>, listOfItems: List<Item>) {
        var i = 0
        do {
            listOfTextViews[i].setText(listOfItems[i].title)
            i++
        }while (i < listOfItems.size)
    }

    // Map buttons with items
    private fun mapButtonsWithItems(mapButtonsWithItems: MutableMap<Button, Item>) {
        mapButtonsWithItems.forEach { map ->
            map.key.setOnClickListener {
                val intent = Intent(this, Detail1Activity::class.java)
                intent.putExtra("item", map.value)
                startActivity(intent)
            }
        }
    }
}
