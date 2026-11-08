package com.example.shopnnow

class ProduitAlimentaire(code: String, nom: String, prixHT: Double, stock: Int, val dateLimite: String) : Produit(code, nom, prixHT, stock) {
    override fun prixTTC(): Double {
        return prixHT + prixHT * 10 / 100
    }
}
