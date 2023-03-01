import java.util.Scanner; // Import l'outil Scanner

public class Test { // Création d'une class Test  
    public static void main (String [] arguments) { // Création d'une méthode statique main, qui renvoit une chaine de caractère en arguments

        TableauElement tableauBulleEntree        = new TableauElement(); // Création d'un nouveau tableauBulleEntree, qui entre les éléments du tableau bulle
        TableauElement tableauInsertionEntree    = new TableauElement (tableauBulleEntree); // Création d'un nouveau tableauInsertionEntree, qui entre les éléments du tableau insertion dans le tableau bulle
        TableauElement tableauRapideEntree       = new TableauElement (tableauInsertionEntree); // Création d'un nouveau tableauRapideEntree, qui entre les éléments du tableau rapide dans le tableau insertion
        TableauElement tableauFusionEntree       = new TableauElement (tableauRapideEntree); // Création d'un nouveau tableauFusionEntree, qui entre les éléments du tableau fusion dans le tableau rapide
        TableauElement tableauDenombrementEntree = new TableauElement (tableauFusionEntree); // Création d'un nouveau tableauDenombrementEntree, qui entre les éléments du tableau fusion dans le tableau dénombrement

        int tailleAleatoire = TableauElement.demanderTaille (); // Taille aléatoire des tableaux insertion, fusion, dénombrement 

        TableauElement tableauBulle        = new TableauElement (tailleAleatoire); // Création d'un nouveau tableauBulle, qui donne une taille aléatoire du tableau bulle

        int grandeur = TableauElement.demanderBorne (); // Demande la grandeur de la clé d'élément 

        tableauBulle.remplir (grandeur); // Rempli le tri bulle par la grandeur de la clé d'élément 

        TableauElement tableauInsertion    = new TableauElement (tableauBulle); // Création d'un nouveau tableauInsertion, qui donne les éléments du tableau insertion dans le tableau bulle 
        TableauElement tableauRapide       = new TableauElement (tableauInsertion); // Création d'un nouveau tableauRapide, qui donne les éléments du tableau rapide dans le tableau insertion 
        TableauElement tableauFusion       = new TableauElement (tableauRapide); // Création d'un nouveau tableauFusion, qui donne les éléments du tableau fusion dans le tableau rapide 
        TableauElement tableauDenombrement = new TableauElement (tableauRapide); // Création d'un nouveau tableauDenombrement, qui donne les éléments du tableau dénombrement  dans le tableau rapide

        System.out.println ("\n" + "*************** Tableaux remplis au clavier ***************" + "\n"); // Affiche les tableaux remplis au clavier, pour les petites valeurs (100) 

        tableauBulleEntree.afficherTriBulle (); // Affiche le tri bulle

        tableauInsertionEntree.afficherTriInsertion (); // Affiche le tri insertion

        tableauFusionEntree.afficherTriFusion (); // Affiche le tri fusion

        tableauRapideEntree.afficherTriRapide (); // // Affiche le tri rapide

        tableauDenombrementEntree.afficherTriDenombrement (); // Affiche le tri par dénombrement

        System.out.println ("\n" + "*************** Tableaux remplis aleatoirement ***************" + "\n"); // Affiche les tableaux remplis aléatoirement, pour les grandes valeurs (15000) 
        
        tableauBulle.afficherTriBulle (); // Affiche le tri bulle

        tableauInsertion.afficherTriInsertion (); // Affiche le tri insertion

        tableauFusion.afficherTriFusion (); // Affiche le tri fusion

        tableauRapide.afficherTriRapide (); // Affiche le tri rapide

        tableauDenombrement.afficherTriDenombrement (); // Affiche le tri par dénombrement
    }
}