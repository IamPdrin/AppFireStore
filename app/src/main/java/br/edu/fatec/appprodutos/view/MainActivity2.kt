package br.edu.fatec.appprodutos.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.fatec.appprodutos.R
import br.edu.fatec.appprodutos.adapter.ProdutoAdapter
import br.edu.fatec.appprodutos.dao.ProdutoDaoImpl
import br.edu.fatec.appprodutos.databinding.ActivityMain2Binding
import com.google.api.Distribution.BucketOptions.Linear

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    val dao = ProdutoDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val produtos = dao.obterProduto()

        binding.rvProdutos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvProdutos.adapter = ProdutoAdapter(produtos)

    }
}