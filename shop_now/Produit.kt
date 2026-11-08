package com.example.shopnnow

abstract class Produit(val code: String, val nom: String, var prixHT: Double, stock: Int) {
    var stock: Int = stock
        private set

    abstract fun prixTTC(): Double

    fun retirerStock(quantite: Int): Boolean {
        if (quantite <= stock) {
            stock = stock - quantite
            return true
        } else {
            return false
        }
    }

    fun ajouterStock(quantite: Int) {
        stock = stock + quantite
    }
}
