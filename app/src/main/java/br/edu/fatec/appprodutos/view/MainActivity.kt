package br.edu.fatec.appprodutos.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatec.appprodutos.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Firebase.firestore


        binding.btnCadastrar.setOnClickListener {
            val nome = binding.edtNome.text.toString()
            val categoria = binding.edtCategoria.toString()
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
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Falha!", Toast.LENGTH_SHORT).show()
                }

            binding.edtNome.text.clear()
            binding.edtCategoria.text.clear()
            binding.edtPreco.text.clear()

        }



    }
}