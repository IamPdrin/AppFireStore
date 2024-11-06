package br.edu.fatec.appprodutos.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatec.appprodutos.dao.ProdutoDaoImpl
import br.edu.fatec.appprodutos.databinding.ActivityMainBinding
import br.edu.fatec.appprodutos.model.Produto
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Firebase.firestore

        val dao = ProdutoDaoImpl()


        binding.btnCadastrar.setOnClickListener {
            val nome = binding.edtNome.text.toString()
            val categoria = binding.edtCategoria.text.toString()
            val preco = binding.edtPreco.text.toString().toDouble()

            val produto = hashMapOf(
                "nome" to nome,
                "categoria" to categoria,
                "preco" to preco
            )

            db.collection("produtos")
                .add(produto)
                .addOnSuccessListener {
                    Toast.makeText(this, "Sucesso!", Toast.LENGTH_SHORT).show()

                    val itemProduto = Produto(nome, categoria, preco)
                    dao.addProduto(itemProduto)
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Falha!", Toast.LENGTH_SHORT).show()
                }

            binding.edtNome.text.clear()
            binding.edtCategoria.text.clear()
            binding.edtPreco.text.clear()

        }

        binding.fabLista.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}