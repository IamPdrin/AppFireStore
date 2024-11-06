package br.edu.fatec.appprodutos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatec.appprodutos.R
import br.edu.fatec.appprodutos.model.Produto

class ProdutoAdapter (private val produtos:List<Produto>):RecyclerView.Adapter<ProdutoAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txvNome: TextView = itemView.findViewById(R.id.txv_nome)
        val txvCategoria: TextView = itemView.findViewById(R.id.txv_categoria)
        val txvPreco: TextView = itemView.findViewById(R.id.txv_preco)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.txvNome.text = produto.nome
        holder.txvCategoria.text = produto.categoria
        holder.txvPreco.text = produto.preco.toString()
    }

    override fun getItemCount(): Int {
        return produtos.size
    }
}