package com.example.shopnnow

class ProduitElectronique(code: String, nom: String, prixHT: Double, stock: Int, val garantieMois: Int) : Produit(code, nom, prixHT, stock), Remisable {
    override fun prixTTC(): Double {
        return prixHT + prixHT * 20 / 100
    }

    override fun appliquerRemise(pourcentage: Double) {
        prixHT = prixHT - prixHT * pourcentage / 100
    }
}
