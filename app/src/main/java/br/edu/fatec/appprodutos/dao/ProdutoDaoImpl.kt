package br.edu.fatec.appprodutos.dao

import br.edu.fatec.appprodutos.model.Produto

class ProdutoDaoImpl:ProdutoDao {
    companion object {
        private val produtos = mutableListOf<Produto>()
    }

    override fun obterFilme(): List<Produto> {
        return produtos
    }

}