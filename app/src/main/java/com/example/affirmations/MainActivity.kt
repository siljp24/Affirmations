package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = Datasource().loadAffirmations()//mi lista de Afirmaciones

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)//mi view RecyclerView
        recyclerView.adapter = ItemAdapter(this, myDataset)//a mi objeto recyclerView le indico que use como adaptador el ItemAdapter

        //Esta línea mejora el rendimiento, si sabemos que el contenido no va a afectar al tamaño del RecyclerView
        recyclerView.setHasFixedSize(true)
    }
}