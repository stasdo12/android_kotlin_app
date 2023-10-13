package ua.com.android_kotlin_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)


        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()


        items.add(Item(1, "sofa", "Sofa", "lorem  ipsum dolor sitlorem  " +
                "ipsum dolor sit", "lorem  ipsum dolor sitlorem  ipsum dolor sitlorem  " +
                "ipsum dolor sitlorem  ipsum dolor sitlorem  ipsum dolor sitlorem  ipsum dolor sitlorem  " +
                "ipsum dolor sit", 100))
        items.add(Item(2, "light", "Light", "lorem  ipsum dolor sitlorem  \" +\n" +
                "                \"ipsum dolor sit", "lorem  ipsum dolor sitlorem  \" +\n" +
                "                \"ipsum dolor sitlorem  ipsum dolor sitlorem  \" +\n" +
                "                \"ipsum dolor sit", 399))
        items.add(Item(3, "kitchen", "Kitchen", "lorem  ipsum dolor sitlorem  \" +\n" +
                "                \"ipsum dolor sit", "lorem  ipsum dolor sitlorem  \" +\n" +
                "                \"ipsum dolor sitlorem  ipsum dolor sitlorem  \" +\n" +
                "                \"ipsum dolor sit", 1000))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)

    }
}