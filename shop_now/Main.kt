package com.example.shopnnow

import java.io.File

fun main() {
    jalon2a()
    jalon2b()
    jalon3()
    jalon4()
    partie2()
    partie3()
    partie4a()
    partie4b()
    bonus1()
    bonus2()
    bonus3()
}

fun jalon2a() {
    println("Jalon 2.a")
    val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 10, 24)
    val riz = ProduitAlimentaire("A1", "Riz", 20.0, 100, "2027-01-01")

    println(laptop.prixTTC())
    println(riz.prixTTC())

    val catalogue: List<Produit> = listOf(laptop, riz)
    for (p in catalogue) {
        println("${p.nom} : ${p.prixTTC()}")
    }
}

fun jalon2b() {
    println("Jalon 2.b")
    val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 10, 24)

    laptop.appliquerRemise(10.0)
    println(laptop.prixHT)
    println(laptop.prixTTC())

    println(laptop.retirerStock(3))
    println(laptop.stock)
    println(laptop.retirerStock(50))
    println(laptop.stock)
    laptop.ajouterStock(3)
    println(laptop.stock)
}

fun jalon3() {
    println("Jalon 3")
    val sara = Client(2, "Sara", "Marrakech")
    println(sara)

    val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 10, 24)

    val c1 = Commande(101, "2026-10-10", sara, laptop, 2)
    println(c1.statut)
    println(c1.montantTotal())
    println(c1.payer())
    println(c1.statut)
    println(laptop.stock)
    println(c1.payer())
    println(c1.expedier())
    println(c1.statut)
    println(c1.annuler())
    println(c1.statut)

    val c2 = Commande(102, "2026-10-11", sara, laptop, 20)
    println(c2.payer())
    println(c2.statut)
    println(laptop.stock)

    val c3 = Commande(103, "2026-10-12", sara, laptop, 3)
    println(c3.payer())
    println(laptop.stock)
    println(c3.annuler())
    println(laptop.stock)
    println(c3.statut)

    val c4 = Commande(104, "2026-10-13", sara, laptop, 1)
    println(c4.annuler())
    println(laptop.stock)
}

fun jalon4() {
    println("Jalon 4")
    val amine = Client(1, "Amine", "Safi")
    val sara = Client(2, "Sara", "Marrakech")
    val hicham = Client(3, "Hicham", "Rabat")

    val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 10, 24)
    val phone = ProduitElectronique("E2", "Phone", 2000.0, 5, 12)
    val riz = ProduitAlimentaire("A1", "Riz", 20.0, 100, "2027-01-01")

    val c1 = Commande(1, "2026-10-01", amine, laptop, 2)
    val c2 = Commande(2, "2026-10-02", sara, phone, 10)
    val c3 = Commande(3, "2026-10-03", hicham, riz, 20)
    val c4 = Commande(4, "2026-10-04", amine, laptop, 3)
    val c5 = Commande(5, "2026-10-05", sara, riz, 5)
    val c6 = Commande(6, "2026-10-06", hicham, phone, 1)

    println("Paiement c1 : " + c1.payer())
    println("Stock Laptop : " + laptop.stock)

    println("Paiement c2 : " + c2.payer())
    println("Statut c2 : " + c2.statut)
    println("Stock Phone : " + phone.stock)

    println("Paiement c3 : " + c3.payer())
    println("Stock Riz : " + riz.stock)

    println("Paiement c4 : " + c4.payer())
    println("Stock Laptop : " + laptop.stock)

    println("Paiement c6 : " + c6.payer())
    println("Stock Phone : " + phone.stock)

    println("Expedition c1 : " + c1.expedier())
    println("Statut c1 : " + c1.statut)

    println("Annulation c1 : " + c1.annuler())
    println("Statut c1 : " + c1.statut)

    println("Annulation c4 : " + c4.annuler())
    println("Statut c4 : " + c4.statut)
    println("Stock Laptop : " + laptop.stock)

    println("Annulation c5 : " + c5.annuler())
    println("Stock Riz : " + riz.stock)
}

fun partie2() {
    println("Partie 2")
    val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 10, 24)
    val riz = ProduitAlimentaire("A1", "Riz", 20.0, 100, "2027-01-01")
    val phone = ProduitElectronique("E2", "Phone", 2000.0, 20, 12)

    val boutique = Boutique()
    println(boutique.ajouter(laptop))
    println(boutique.ajouter(laptop))
    println(boutique.ajouter(riz))
    println(boutique.ajouter(phone))

    println(boutique.indiceProduit("A1"))
    println(boutique.indiceProduit("ZZ"))
    println(boutique.nombreProduitsElectroniques())

    println(boutique.supprimer("A1"))
    println(boutique.supprimer("A1"))
    println(boutique.supprimer(laptop))
    println(boutique.nombreProduitsElectroniques())
    println(boutique.indiceProduit("E2"))
}

fun partie3() {
    println("Partie 3")
    val commandes = jeuDeDonnees()

    println("Q1")
    commandes.forEach { println(it.client.nom + " : " + it.montantTotal()) }

    println("Q2")
    val montants = commandes.map { it.montantTotal() }
    println(montants)

    println("Q3")
    val grosses = commandes.filter { it.montantTotal() > 1000 }
    grosses.forEach { println("Commande" + it.numero) }

    println("Q4")
    val croissant = commandes.sortedBy { it.montantTotal() }
    val decroissant = commandes.sortedByDescending { it.montantTotal() }
    println(croissant.map { it.numero })
    println(decroissant.map { it.numero })

    println("Q5")
    println(commandes.any { it.statut == StatutCommande.CANCELLED })
    println(commandes.all { it.statut == StatutCommande.PAID })

    println("Q6")
    val totalSafi = commandes.filter { it.statut == StatutCommande.PAID && it.client.ville == "Safi" }.sumOf { it.montantTotal() }
    println(totalSafi)

    println("Q7")
    val meilleure = commandes.filter { it.statut == StatutCommande.PAID }.maxByOrNull { it.montantTotal() }
    println(meilleure?.client?.nom)

    println("Q8")
    val annulees = commandes.filter { it.statut == StatutCommande.CANCELLED }.map { it.client.nom }.distinct()
    println(annulees)

    println("Q9")
    val top3 = commandes.filter { it.statut == StatutCommande.PAID }.sortedByDescending { it.montantTotal() }.take(3)
    top3.map { it.client.nom + " : " + it.montantTotal() }.forEach { println(it) }

    println("Q10")
    val parVille = commandes.filter { it.statut == StatutCommande.PAID }.groupBy { it.client.ville }.mapValues { it.value.sumOf { c -> c.montantTotal() } }
    println(parVille)

    println("Q11")
    println(commandesDuClient(commandes, "Amine").map { it.numero })
    println(totalPayees(commandes))
    println(totalAnnulees(commandes))
}

fun commandesDuClient(commandes: List<Commande>, client: String): List<Commande> = commandes.filter { it.client.nom == client }

fun totalPayees(commandes: List<Commande>): Double = commandes.filter { it.statut == StatutCommande.PAID }.sumOf { it.montantTotal() }

fun totalAnnulees(commandes: List<Commande>): Double = commandes.filter { it.statut == StatutCommande.CANCELLED }.sumOf { it.montantTotal() }

fun jeuDeDonnees(): List<Commande> {
    val amine = Client(1, "Amine", "Safi")
    val sara = Client(2, "Sara", "Marrakech")
    val hicham = Client(3, "Hicham", "Rabat")
    val rania = Client(4, "Rania", "Agadir")

    val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 100, 24)
    val phone = ProduitElectronique("E2", "Phone", 2000.0, 100, 12)
    val riz = ProduitAlimentaire("A1", "Riz", 20.0, 1000, "2027-01-01")
    val lait = ProduitAlimentaire("A2", "Lait", 10.0, 500, "2026-12-01")

    val c1 = Commande(1, "2026-10-01", amine, laptop, 1); c1.payer()
    val c2 = Commande(2, "2026-10-02", sara, phone, 1); c2.payer()
    val c3 = Commande(3, "2026-10-03", amine, riz, 10); c3.payer()
    val c4 = Commande(4, "2026-10-04", hicham, laptop, 2); c4.payer(); c4.annuler()
    val c5 = Commande(5, "2026-10-05", sara, lait, 20)
    val c6 = Commande(6, "2026-10-06", rania, phone, 3); c6.payer()
    val c7 = Commande(7, "2026-10-07", amine, lait, 10); c7.annuler()
    val c8 = Commande(8, "2026-10-08", hicham, riz, 100); c8.payer()

    return listOf(c1, c2, c3, c4, c5, c6, c7, c8)
}

fun String.isValidPhoneNumber(): Boolean {
    if (this.length != 13) {
        return false
    }
    if (this[0] != '+') {
        return false
    }
    for (i in 1 until this.length) {
        if (!this[i].isDigit()) {
            return false
        }
    }
    return true
}

fun Double.toDh(): String {
    return "$this dhs"
}

fun partie4a() {
    println("Partie 4.a")
    println("+212600000000".isValidPhoneNumber())
    println("0600000000".isValidPhoneNumber())
    println("+212 600 000 000".isValidPhoneNumber())
    println("+21260000000".isValidPhoneNumber())
    println("+2126000000001".isValidPhoneNumber())
    println("+21260000000a".isValidPhoneNumber())

    println(1200.0.toDh())
}

fun filtrerCommandes(commandes: List<Commande>, critere: (Commande) -> Boolean): List<Commande> {
    val resultat = mutableListOf<Commande>()
    for (c in commandes) {
        if (critere(c)) {
            resultat.add(c)
        }
    }
    return resultat
}

fun estPayee(c: Commande): Boolean {
    return c.statut == StatutCommande.PAID
}

fun partie4b() {
    println("Partie 4.b")
    val commandes = jeuDeDonnees()

    val grosses = filtrerCommandes(commandes) { c -> c.montantTotal() > 1000 }
    println(grosses.size)

    val safi = filtrerCommandes(commandes) { it.client.ville == "Safi" }
    println(safi.size)

    val payees = filtrerCommandes(commandes, ::estPayee)
    println(payees.size)
}

fun bonus1() {
    println("Bonus 1")
    val sara = Client(2, "Sara", "Marrakech")
    val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 10, 24)
    val c = Commande(101, "2026-10-10", sara, laptop, 2)

    println(c.statut)
    c.payer()
    println(c.statut)
    println(c.statut == StatutCommande.PAID)
    println(StatutCommande.values().size)
}

fun ecrireHistorique(client: Client, commandes: List<Commande>) {
    var texte = ""
    for (c in commandes) {
        if (c.client.id == client.id) {
            texte = texte + c.numero + " | " + c.date + " | " + c.produit.nom + " | " + c.quantite + " | " + c.montantTotal() + " | " + c.statut + "\n"
        }
    }
    File("Client${client.id}.txt").writeText(texte)
}

fun bonus2() {
    println("Bonus 2")
    val sara = Client(2, "Sara", "Marrakech")
    val commandes = jeuDeDonnees()
    ecrireHistorique(sara, commandes)
    println("fichier Client2.txt")
}

fun bonus3() {
    println("Bonus 3")
    val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 10, 24)
    val r: Remisable = laptop
    r.appliquerRemise(20.0)
    println(laptop.prixHT)
}