package br.edu.fatec.appprodutos.dao

import br.edu.fatec.appprodutos.model.Produto

class ProdutoDaoImpl:ProdutoDao {
    companion object {
        private val produtos = mutableListOf<Produto>()
    }

    override fun addProduto(produto: Produto) {
        produtos.add(produto)
    }

    override fun obterProduto(): List<Produto> {
        return produtos
    }

}