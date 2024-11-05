package br.edu.fatec.appprodutos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatec.appprodutos.R
import br.edu.fatec.appprodutos.databinding.ActivityMain2Binding
import br.edu.fatec.appprodutos.model.Produto

class ProdutoAdapter (private val produtos:List<Produto>):RecyclerView.Adapter<ProdutoAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private lateinit var binding: ActivityMain2Binding

        val txvNome = binding.txvNome.text.toString()
        val txvCategoria = binding.txvCategoria.text.toString()
        val txvPreco = binding.txvPreco.text.toString().toDouble()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.txvNome.text = produto.titulo
        holder.txvCategoria.text = produto.diretor
        holder.txvPreco.text = produto
    }

    override fun getItemCount(): Int {
        return produtos.size
    }
}