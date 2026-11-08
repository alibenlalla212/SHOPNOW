# ShopNow

ShopNow est une application de gestion de boutique en ligne écrite en Kotlin. Elle permet de gérer un catalogue de produits, des clients et des commandes, avec un suivi complet du cycle de vie d'une commande : création, paiement, expédition et annulation.

## Fonctionnalités

- Gestion des produits et du stock.
- Deux types de produits : électroniques (TVA 20 %) et alimentaires (TVA 10 %).
- Calcul du prix TTC et du montant total d'une commande.
- Application de remises sur les produits électroniques.
- Gestion des clients et des commandes.
- Cycle de vie d'une commande : `CREATED` → `PAID` → `SHIPPED`, ou `CANCELLED`.
- Restitution automatique du stock lors de l'annulation d'une commande payée.
- Gestion du catalogue : recherche, ajout et suppression de produits.
- Analyse des ventes : filtrage, tri, regroupement par ville, totaux des commandes payées ou annulées.
- Validation de numéros de téléphone et formatage des montants en dirhams (DH).
- Export de l'historique d'un client dans un fichier texte.

## Structure du projet

| Fichier | Description |
|---|---|
| `Produit.kt` | Classe abstraite qui représente un produit. |
| `ProduitElectronique.kt` | Produits électroniques : TVA et garantie. |
| `ProduitAlimentaire.kt` | Produits alimentaires : TVA et date limite. |
| `Remisable.kt` | Interface pour les produits pouvant bénéficier d'une remise. |
| `Client.kt` | Représentation d'un client (data class). |
| `StatutCommande.kt` | Énumération des statuts d'une commande. |
| `Commande.kt` | Commandes et leurs opérations (payer, expédier, annuler). |
| `Boutique.kt` | Gestion du catalogue de produits. |
| `Main.kt` | Point d'entrée, scénarios de démonstration, analyses des commandes et fonctions d'extension. |

## Concepts Kotlin utilisés

- **Programmation orientée objet** : classes, héritage et polymorphisme.
- **Classes abstraites et interfaces** : partager des comportements entre plusieurs classes.
- **Encapsulation** : `private set`, `val` et `var`.
- **Redéfinition de méthodes** : `override`.
- **Data classes** : représenter simplement les données d'un client.
- **Énumérations** : `enum class` pour les statuts.
- **Collections** : `filter`, `map`, `forEach`, `groupBy`, `sumOf`, `sortedBy`, etc.
- **Lambdas et fonctions d'ordre supérieur** : passer une fonction en paramètre.
- **Fonctions d'extension** : ajouter des fonctionnalités à des classes existantes.
- **Fichiers** : écriture dans un fichier texte.

## Lancer le projet

1. Cloner le dépôt.
2. Ouvrir le projet dans Android Studio ou IntelliJ IDEA.
3. Exécuter la fonction `main()` du fichier `Main.kt`.

Les résultats s'affichent dans la console. Un fichier `Client2.txt` est généré par la démonstration de l'historique.
