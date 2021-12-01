package com.example.yemektarifleri

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_yemek_details.view.*
import kotlinx.android.synthetic.main.mylayout.view.*

class MainActivity : AppCompatActivity() {



    var adapter : YemekAdapter? = null
    var yemeklist = ArrayList<yemek>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        yemeklist.add(yemek("Somon","  4 parça somon dilim fileto  3 yemek kaşığı zeytinyağı 2 diş sarımsak İnce kıyılmışTuz 1 yemek kaşığı tereyağı 200 ml krema",R.drawable.somon))
        yemeklist.add(yemek("İstavrit","  5800 gr istavrit, temizlenmiş1 adet havuç 1 adet patates 4 diş sarımsak 3 yemek kaşığı zeytinyağı 1 adet domates 1 adet soğan 1 su bardağı su",R.drawable.istavrit))
        yemeklist.add(yemek("Nigde Tava","  250 gr koyun eti250 gr domates180 gr sivri biber 1,5 yemek kaşığı tereyağı 1 çay kaşığı pul biber ½ çay kaşığı karabiber1 çay kaşığı tuz",R.drawable.nigde_tava))
        yemeklist.add(yemek("Soslu Tavuk","  500 gram tavuk göğsü1 adet kuru soğan1 adet yeşil biber3 diş sarımsak 2 yemek kaşığı zeytinyağı7 adet mantar1,5 tatlı kaşığı köri2 çay bardağı süt",R.drawable.soslu_tavuk))

        adapter = YemekAdapter(this,yemeklist)
        gridview.adapter = adapter
    }

    class YemekAdapter : BaseAdapter{
        var yemeklist = ArrayList<yemek>()
        var context:Context? = null

        constructor(context: Context?,yemeklist: ArrayList<yemek>) : super() {
            this.yemeklist = yemeklist
            this.context = context
        }


        override fun getCount(): Int {
            return yemeklist.size
        }

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(index: Int, convertView: View?, parent: ViewGroup?): View {
            var yemek = this.yemeklist[index]
            var inflater = context!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var yemekview = inflater.inflate(R.layout.mylayout,null)
            yemekview.imageView.setImageResource(yemek.image!!)
            yemekview.textView.text = yemek.name!!



            yemekview.imageView.setOnClickListener {
                var intent = Intent(context,  yemekDetailsActivity::class.java)
                intent.putExtra("name",yemek.name!!)
                intent.putExtra("des",yemek.des!!)
                intent.putExtra("image",yemek.image!!)

                context!!.startActivity(intent)
            }
            return yemekview
        }

    }
}