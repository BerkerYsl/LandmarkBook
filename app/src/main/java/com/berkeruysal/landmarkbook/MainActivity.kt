package com.berkeruysal.landmarkbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.berkeruysal.landmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private  lateinit var landmarkList:ArrayList<Landmark>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        landmarkList=ArrayList()
        //DATA
        var pisa=Landmark("Pisa Tower","Italy",R.drawable.pisa)
        var bogaz=Landmark("Boğaz Köprüsü","Turkey",R.drawable.bogaz)
        var londonBridge=Landmark("London Bridge","England",R.drawable.londonbridge)
        var eyfel=Landmark("Eiffel Tower","France",R.drawable.eyfel)
        landmarkList.add(pisa)
        landmarkList.add(bogaz)
        landmarkList.add(londonBridge)
        landmarkList.add(eyfel)
        //ADAPTER: LAYOUT & DATA ADAPTER LİSTVİEW'DE TEK SATIRDA YAZILABİLİR DATAYI VE LAYOYUT'U BİRBİRİNE BAĞLAR VERİLERİ GÖSTERMEMİZİ SAĞLAR. BU SAYEDE VERİLERİ
        //LİSTVİEW'DE GÖSTEREBİLİRİZ.
        var adapter=ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,landmarkList.map { landmark -> landmark.name })
        binding.listView.adapter=adapter
        binding.listView.onItemClickListener=AdapterView.OnItemClickListener { adapterView, view, i, l ->
            var intent=Intent(this@MainActivity,DetailsActivity::class.java)
            intent.putExtra("landmark",landmarkList.get(i))

            startActivity(intent)
        }
    }
}