package com.example.mac.listviewdemo

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listView)
        listView.adapter = MyCustomAdapter(this)
    }
    private class MyCustomAdapter(context: Context): BaseAdapter() {

        private  val names = arrayListOf<String>(
                "Muhammed Azharudheen", "Sajeer" , "Arun" , "Ajeesh" , "Binoy" , "Annan"
        )

        private val mContext:Context
        init {
            mContext = context
        }

        override fun getCount(): Int {
            return names.size
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getItem(p0: Int): Any {
            return  "TEST STRING"
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflator = LayoutInflater.from(mContext)
            val rowMain = layoutInflator.inflate(R.layout.row_main , viewGroup , false)
            val positionTextView = rowMain.findViewById<TextView>(R.id.positionTextView)
            val nameTextView = rowMain.findViewById<TextView>(R.id.nameTextView)
            positionTextView.text = "Row number : $position"
            nameTextView.text = names.get(position)
            return rowMain


        }
    }
}
