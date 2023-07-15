package com.myapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.snackbar.Snackbar
import com.myapp.R
import com.myapp.databinding.ActivityMainBinding
import com.myapp.databinding.ProductItemBinding
import com.myapp.presentation.viewmodels.ScreenActivityVm

class ScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val productLst = mutableListOf<String>()
    private val productAdapter = MyAdapter(productLst)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ViewModel initialisation
        val vm = ViewModelProvider(this)[ScreenActivityVm::class.java]

        // ProductAdapter initialisation
        vm.productList.observe(this){
            productLst.clear()
            productLst.addAll(it)
            productAdapter.notifyDataSetChanged()
        }

        binding.action.setOnClickListener {
            Snackbar.make(binding.root,"Action",Snackbar.LENGTH_SHORT).show()
        }


        // Create adapter
        binding.recyclerProduct.adapter = productAdapter
        binding.recyclerProduct.layoutManager =LinearLayoutManager(baseContext)

    }
}

class MyAdapter(private val data:List<String>):Adapter<ProductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false)
        return ProductViewHolder(viewItem)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(data[position])
    }
}

class ProductViewHolder(private val view:View):ViewHolder(view){
    private val binding:ProductItemBinding = ProductItemBinding.inflate(LayoutInflater.from(view.context))

    fun bind(productName:String){
        binding.productName.text = productName
        val txt = view.findViewById<TextView>(R.id.product_name)
        txt.text = productName
    }
}