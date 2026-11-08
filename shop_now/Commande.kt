package com.example.shopnnow

class Commande(val numero: Int, val date: String, val client: Client, val produit: Produit, val quantite: Int) {
    var statut: StatutCommande = StatutCommande.CREATED
        private set

    fun montantTotal(): Double {
        return produit.prixTTC() * quantite
    }

    fun payer(): Boolean {
        if (statut == StatutCommande.CREATED) {
            if (produit.retirerStock(quantite)) {
                statut = StatutCommande.PAID
                return true
            }
        }
        return false
    }

    fun expedier(): Boolean {
        if (statut == StatutCommande.PAID) {
            statut = StatutCommande.SHIPPED
            return true
        }
        return false
    }

    fun annuler(): Boolean {
        if (statut == StatutCommande.SHIPPED) {
            return false
        }
        if (statut == StatutCommande.PAID) {
            produit.ajouterStock(quantite)
        }
        statut = StatutCommande.CANCELLED
        return true
    }
}
