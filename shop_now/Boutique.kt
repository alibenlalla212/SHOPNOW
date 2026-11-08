package com.example.shopnnow

class Boutique {
    private val produits = mutableListOf<Produit>()

    fun indiceProduit(code: String): Int {
        for (i in 0 until produits.size) {
            if (produits[i].code == code) {
                return i
            }
        }
        return -1
    }

    fun ajouter(p: Produit): Boolean {
        if (indiceProduit(p.code) == -1) {
            produits.add(p)
            return true
        }
        return false
    }

    fun supprimer(code: String): Boolean {
        val i = indiceProduit(code)
        if (i == -1) {
            return false
        }
        produits.removeAt(i)
        return true
    }

    fun supprimer(p: Produit): Boolean {
        return supprimer(p.code)
    }

    fun nombreProduitsElectroniques(): Int {
        var nombre = 0
        for (p in produits) {
            if (p is ProduitElectronique) {
                nombre++
            }
        }
        return nombre
    }
}
