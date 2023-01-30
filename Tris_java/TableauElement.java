import java.util.Random; // Import l'outil Random 
import java.util.Scanner; // Import l'outil Scanner 

public class TableauElement { // Création d'une class TableauElement 
    
    private int taille; // Taille du tableau d'élément

    private Element [] elements; // Eléments du tableau d'élément 

    final int VALEUR_MAXIMUM = 15000; // Valeur maximum pour le tableau d'élément

    private static Scanner scanner = new Scanner (System.in); // Création d'un nouveau scanner statique, qui scanne la valeur de la clé de l'élément et de la taille du tableau d'élément

    private static int operationElementaireTriBulle = 0; // Nombre d'opération élémentaire du tri à bulle

    private static int operationElementaireTriInsertion = 0; // Nombre d'opération élémentaire du tri à insertion 

    private static int operationElementaireTriRapide = 0; // Nombre d'opération élémentaire du tri rapide

    private static int operationElementaireTriFusion = 0; // Nombre d'opération élémentaire du tri fusion 

    private static int operationElementaireTriDenombrement = 0; // Nombre d'opération élémentaire du tri à dénombrement 

    public TableauElement () { // Création d'un constructeur de TableauElement sans paramètres taille et elements, qui sont la taille et les éléments du tableau d'élément

        System.out.println ("Saisissez la \"taille\" que les tableaux manuelles vont prendre : "); // Affiche manuellement la taille des tableaux 

        this.taille = scanner.nextInt (); // Scanne la nouvelle valeur de la taille du tableau d'élément
        
        if (this.taille == 0) { // Si la taille du tableau d'élément est à 0

            this.elements = new Element [0]; // Création de nouveaux éléments pour le tableau d'élément à 0
        }

        this.elements = new Element [this.taille]; // Création de nouveaux éléments pour le tableau d'élément

        int cle; // Clé de l'élément 
        
        for (int i = 0; i < this.taille; i++) { // Compte la taille de la clé de l'élément

            System.out.println ("Entrez la cle entre 0 et " + this.VALEUR_MAXIMUM); // Affiche la valeur maximum de la clé de l'élément

            cle = scanner.nextInt (); // Scanne la nouvelle valeur de la clé de l'élément

            while (cle <= 0 || cle > this.VALEUR_MAXIMUM) { // Tant que la clé est comprise entre 0 et la valeur maximum

                System.out.println ("Nombre incorrect. Entrez la cle entre et " + this.VALEUR_MAXIMUM); // Affiche nombre incorrect et on redonne une valeur maximum pour la clé 

                cle = scanner.nextInt (); // Scanne la nouvelle valeur de la clé de l'élément
            }

            this.elements [i] = new Element (cle, genereValeur ()); // Création de nouveaux éléments avec une clé et génère une valeur
        }
    }

    public TableauElement (int taille) { // Création d'un constructeur de TableauElement avec le paramètre taille, qui est la taille du tableau d'éléments

        this.taille = taille; // Taille du tableau d'élément

        this.elements = new Element [taille]; // Création de nouveaux éléments pour le tableau d'élément
    }

    public TableauElement (TableauElement tableauElement) { // Création d'un constructeur par recopie de TableauElement avec le paramètre tableauElement, qui est le tableauElement à copier
        
        this.taille = tableauElement.taille; // Taille du tableau d'élément
        
        this.elements = new Element [this.taille]; // Création de nouveaux éléments pour le tableau d'élément

        if (tableauElement.taille >= 0) { // Si la taille du tableau d'élément est supérieur à 0
        
            System.arraycopy (tableauElement.elements, 0, this.elements, 0, tableauElement.taille); // Affiche la copie des éléments du tableau d'élément 
        }
    }

    public int getTaille () { // Création d'un accesseur Taille, qui retourne la taille du tableau d'élément

        return this.taille;
    }

    public int genereCle (int grandeur) { // Création d'un int (méthode) genereCle, qui génère une clé de l'élément avec la paramètre grandeur

        Random random = new Random (); // Création d'une nouvelle valeur aléatoire

        return random.nextInt (grandeur); // Retourne une grandeur aléatoire
    }

    public String genereValeur () { // Création d'un String (méthode) genereValeur, qui génère une valeur de l'élément

        Random random = new Random (); // Création d'une nouvelle valeur aléatoire

        char caractere = (char) (random.nextInt (26) + 65); // Caractère aléatoire (lettre alphabétique)

        return "" + caractere; // Retourne le caractère aléatoire
    }

    public static int demanderBorne () { // Création d'un int (méthode statique) demanderBorne, qui demande la grandeur de la clé de l'élément  

        System.out.println ("\n" + "Saisissez la \"grandeur\" des valeurs que les cles d'un element va prendre : "); // Affiche la grandeur des valeurs pour la clé de l'élément

        int grandeur = scanner.nextInt (); // Scanne la nouvelle grandeur de la clé de l'élément

        return grandeur; // Retourne la grandeur de la clé de l'élément
    }

    public static int demanderTaille () { // Création d'un int (méthode statique) demanderTaille, qui demande la taille du tableau d'élément

        System.out.println ("\n" + "Saisissez la \"taille\" que les tableaux aleatoires vont prendre : "); // Affiche aléatoirement la taille des tableaux 

        int tailleTableau = scanner.nextInt (); // Scanne la nouvelle valeur de la taille du tableau d'élément

        return tailleTableau; // Retourne la taille du tableau d'élément
    }

    public void afficherDuree (String triNom, double dureeDebut, double dureeFin) { // Création d'une méthode AfficherDuree, qui calcul la durée d'exécution du tri avec les paramètres triNom, dureeDebut, dureeFin 

        double duree = dureeFin - dureeDebut; // Calcul la durée du tri 

        System.out.println (triNom + " => Temps ecoule en secondes = " + (duree / 1000000)); // Afffiche le nom du tri avec le temps que l'on divise par 1000000 pour mettre en millisecondes 
    }

    public void triBulle () { // Création d'une méthode triBulle sans paramètres, qui utilise le tri bulle

        Element temporaire; // Element temporaire
        
        for(int i = 0; i < this.taille; i++){
        
            for(int j = 1; j < (this.taille - i); j++) {
        
                if(this.elements [j - 1].getCle () > this.elements [j].getCle ()){
                    
                    //permutation
                    temporaire = new Element (this.elements [j - 1]);
        
                    this.elements [j - 1] = this.elements [j];
        
                    this.elements [j] = temporaire;
        
                    operationElementaireTriBulle = operationElementaireTriBulle + 4;
                }
            }
        }
    }

    public void afficherTriBulle () { 
    
        if (this.taille > 0 ) {
            
            System.out.println("tableau Bulle avant triBulle : \n" + this);
            
            double debutTempsBulle = System.nanoTime ();
            
            this.triBulle();
            
            double finTempsBulle = System.nanoTime ();
            
            System.out.println("tableau Bulle apres triBulle    : \n" + this);
            
            afficherDuree("Tri Bulle",debutTempsBulle, finTempsBulle);
            
            System.out.println("nombre operation elementaire tri bulle : " + operationElementaireTriBulle);
        
        } else {
            
            System.out.println("tableau Bulle de taille <= 0");

            }
        }

    public void triInsertion () { // Création d'une méthode triInsertion sans paramètres, qui utilise le tri insertion

        for (int i = 1; i < this.taille; i++) { // Compte la taille de la clé de l'élément
    
            Element index; // Elément index
            
            index = this.elements [i]; // L'élément index est la clé de l'élément
    
            int j = i - 1; // J est permuté
    
            while (j >= 0 && this.elements [j].getCle () > index.getCle ()) { // Tant que j permuté est supérieur à 0 et la clé de l'élément est supérieur à l'index de l'élément
    
                this.elements [j + 1] = this.elements [j]; // Clé de l'élément permuté est la clé de l'élément
    
                j--; // J diminue
            }
    
            this.elements [j + 1] = index; // Clé de l'élément est l'élément index
    
            operationElementaireTriInsertion = operationElementaireTriInsertion + 4; // Nombre d'opération élémentaire du tri insertion
        }
    }
    
    public void afficherTriInsertion () { // Création d'une méthode afficherTriInsertion sans paramètres, qui affiche le tri insertion 
            
        if (this.taille > 0) { // Si la taille du tableau est supérieur à 0
    
            System.out.println ("Tableau Insertion avant triInsertion    : \n" + this); // Affiche les éléments du tableau avant le tri à insertion
    
            double debutTempsTriInsertion = System.nanoTime (); // Début du temps pour le tri insertion donné en nanosecondes
    
            this.triInsertion (); // Tri insertion
    
            double finTempsTriInsertion = System.nanoTime (); // Fin du temps pour le tri insertion donné en nanosecondes
    
            System.out.println ("Tableau Insertion apres triInsertion    : \n" + this); // Affiche les éléments du tableau après le tri à insertion
    
            afficherDuree ("Tri Insertion", debutTempsTriInsertion, finTempsTriInsertion); // Affiche la durée du tri bulle
    
            System.out.println ("Nombre d'operations elementaires tri insertion : " + operationElementaireTriInsertion); // Affiche le nombre d'opérations élémentaires du tri insertion
    
        } else { // Sinon on retourne, que le tableau par tri insertion est inférieur à 0 
    
            System.out.println ("Tableau Insertion de taille <= 0"); // Affiche que le tableau par tri insertion est inférieur à 0 
        }
    }

    public void triFusion (Element [] tableau, int indiceDebut, int indiceFin) { // Création d'une méthode triFusion sans paramètres, qui utilise le tri fusion avec des paramètres tableau, indiceDebut et indiceFin 

        if (indiceDebut < indiceFin) { // Si l'indiceDebut est inférieur à l'indiceFin du tableau d'élément

            int indiceMilieu = (indiceDebut + indiceFin) / 2; // Indice du milieu est une fusion de l'indice du début et de fin

            triFusion (tableau, indiceDebut, indiceMilieu); // Indice du début et du milieu ne bouge pas dans le tri fusion 

            triFusion (tableau, indiceMilieu + 1, indiceFin); // Indice du milieu augmente et l'indice de fin bouge pas dans le tri fusion 

            fusion (tableau, indiceDebut, indiceMilieu, indiceFin); // Fusion de l'indice du début, milieu et de fin

            operationElementaireTriFusion = operationElementaireTriFusion + 4; // Nombre d'opérations élémentaire du tri fusion
        }
    }

    public void fusion (Element [] tableau, int indiceDebut, int indiceMilieu, int indiceFin) { // Création d'une méthode fusion, qui utilise la fusion avec des paramètres tableau, indiceDebut, indiceMilieu et indiceFin 

        int indice1 = indiceMilieu - indiceDebut + 1; // Indice1 est l'indice du milieu moins celui du debut
        int indice2 = indiceFin - indiceMilieu; // Indice2 est l'indice de la fin moins celui du milieu
 
        Element Gauche [] = new Element [indice1]; // Création d'un nouvel indice1 à gauche
        Element Droite [] = new Element [indice2]; // Création d'un nouvel indice2 à droite

        operationElementaireTriFusion = operationElementaireTriFusion + 4; // Nombre d'opérations élémentaire du tri fusion
 
        for (int i = 0; i < indice1; i++) { // Compte l'indice1

            Gauche [i] = tableau [indiceDebut + i]; // L'élément gauche est l'indiceDebut augmente

            operationElementaireTriFusion++; // Nombre d'opération élémentaire du tri fusion augmente
        }

        for (int j = 0; j < indice2; j++) { // Compte l'indice2

            Droite [j] = tableau [indiceMilieu + 1 + j]; // L'élément droit est l'indiceMilieu augmente

            operationElementaireTriFusion++; // Nombre d'opération élémentaire du tri fusion augmente
        }
        
        int i = 0; // Initialise i
        int j = 0; // Initialise j

        int k = indiceDebut; // K est l'indice du début

        while (i < indice1 && j < indice2) { // Tant que i est inférieur à l'indice1 et que j est inférieur à l'indice2
            
            if (Gauche [i].getCle () <= Droite [j].getCle ()) { // Si la clé de l'élément gauche est inférieur à celle de droite 

                tableau [k] = Gauche [i]; // Tableau k est l'élément gauche
                
                i++; // I augmente
            
            } else { // Sinon on retourne
                
                tableau [k] = Droite [j]; // Tableau k est l'élément droit

                j++; // J augmente

                operationElementaireTriFusion = operationElementaireTriFusion + 3; // Nombre d'opérations élémentaire du tri fusion
            }

            k++; // K augmente
        }
 
        while (i < indice1) { // Tant que i est inférieur à l'indice1

            tableau [k] = Gauche [i]; // Tableau k est l'élément gauche

            i++; // I augmente
            
            k++; // K augmente

            operationElementaireTriFusion = operationElementaireTriFusion + 2; // Nombre d'opérations élémentaire du tri fusion
        }
 
        while (j < indice2) { // Tant que j est inférieur à l'indice2

            tableau [k] = Droite [j]; // Tableau k est l'élément droit

            j++; // J augmente
            
            k++; // K augmente

            operationElementaireTriFusion = operationElementaireTriFusion + 2; // Nombre d'opérations élémentaire du tri fusion
        }
    }

    public void afficherTriFusion () { // Création d'une méthode afficherTriFusion sans paramètres, qui affiche le tri fusion 
        
        if (this.taille > 0) { // Si la taille du tableau est supérieur à 0

            System.out.println ("Tableau Fusion avant triFusion : \n" + this); // Affiche les éléments du tableau avant le tri fusion

            double debutTempsTriFusion = System.nanoTime (); // Début du temps pour le tri fusion donné en nanosecondes

            this.triFusion (this.elements, 0, this.getTaille () - 1); // Tri fusion 

            double finTempsTriFusion = System.nanoTime (); // Fin du temps pour le tri fusion donné en nanosecondes

            System.out.println ("Tableau Fusion apres triFusion : \n" + this); // Affiche les éléments du tableau après le tri fusion

            afficherDuree ("Tri Fusion", debutTempsTriFusion, finTempsTriFusion); // Affiche la durée du tri fusion

            System.out.println ("Nombre d'operations elementaires tri fusion : " + operationElementaireTriFusion); // Affiche le nombre d'opérations élémentaires du tri fusion

        } else { // Sinon on retourne, que le tableau par tri fusion est inférieur à 0 

            System.out.println ("Tableau Fusion de taille <= 0"); // Affiche que le tableau par tri fusion est inférieur à 0 
        }
    }

    public void triRapide (int debut, int fin) { 

        if (debut < fin) {

            int indicePivot = partition (debut, fin);

            triRapide (debut, indicePivot - 1);

            triRapide (indicePivot + 1, fin);

            operationElementaireTriRapide= operationElementaireTriRapide + 4;
        }
    }

    public int partition (int debut, int fin) {

        Element valeurPivot = new Element (this.elements [debut]);
        
        int d = debut + 1;
        
        int f = fin;
        
        operationElementaireTriRapide = operationElementaireTriRapide + 3;
        
        while (d < f) {
            
            while (d < f && this.elements [f].getCle () >= valeurPivot.getCle ()){
                
                f--;
                
                operationElementaireTriRapide++;
            }

            while (d < f && this.elements [d].getCle () <= valeurPivot.getCle ()){
                
                d++;
                
                operationElementaireTriRapide++;
            }

            Element temporaire = new Element (this.elements[d]);

            this.elements [d]= this.elements [f];

            this.elements [f] = temporaire;

            operationElementaireTriRapide = operationElementaireTriRapide+3;
        }

        if (this.elements [d].getCle () > valeurPivot.getCle ()) {
            
            d--;

            operationElementaireTriRapide= operationElementaireTriRapide + 2;
        }

        this.elements [debut] = this.elements [d];

        this.elements [d] = valeurPivot;

        operationElementaireTriRapide = operationElementaireTriRapide+2;

        return d;
    }

    public void afficherTriRapide () { // Création d'une méthode afficherTriDenombrement sans paramètres, qui affiche le tri rapide

        if (this.taille > 0 ) { // Si la taille du tableau est supérieur à 0

            System.out.println ("tableau Rapide avant triRapide    : \n" + this);  // Affiche les éléments du tableau avant le tri rapide 

            double debutTempsRapide = System.nanoTime (); // Début du temps pour le tri rapide donné en nanosecondes

            this.triRapide (0, this.getTaille () - 1); // Tri rapide

            double finTempsRapide = System.nanoTime (); // Fin du temps pour le tri rapide donné en nanosecondes

            System.out.println ("tableau Rapide apres triRapide    : \n" + this); // Affiche les éléments du tableau après le tri rapide
            
            afficherDuree ("Tri Rapide",debutTempsRapide, finTempsRapide); // Affiche la durée du tri rapide
            
            System.out.println ("nombre operation elementaire tri rapide : " + operationElementaireTriRapide);  // Affiche le nombre d'opérations élémentaires du tri rapide
        
        } else { // Sinon on retourne, que le tableau de tri rapide est inférieur à 0 
            
            System.out.println ("tableau Rapide de taille <= 0"); // Affiche que le tableau de tri rapide est inférieur à 0 
        }
    }

    public void triDenombrement () { // Création d'une méthode triDenombrement sans paramètres, qui utilise le tri par dénombrement

        int maximum = valeurMaximale (); // Valeur maximale 
    
        Element [] reste = new Element [this.taille]; // Création de nouveaux éléments qui restent

        int [] tableauCompteur = new int [maximum + 1]; // Création d'un nouveau compteur de tableau pour la nouvelle valeur maximale 

        operationElementaireTriDenombrement = operationElementaireTriDenombrement + 4; // Nombre d'opération élémentaire du tri par dénombrement

        for (int i = 0; i < maximum; i++) { // Compte la valeur maximale de la clé de l'élément

            tableauCompteur [i] = 0; // Initialise le compteur de tableau
        
            operationElementaireTriDenombrement++; // Nombre d'opération élémentaire du tri par dénombrement
        }

        for (int i = 0; i < taille; ++i) { // Compte la taille de la clé de l'élément

            tableauCompteur [this.elements [i].getCle ()]++; // Compteur de tableau de la clé de l'élément

            operationElementaireTriDenombrement++; // Nombre d'opération élémentaire du tri par dénombrement
        }

        for (int i = 1; i <= maximum; ++i) { // Compte la valeur maximale de la clé de l'élément

            tableauCompteur [i] += tableauCompteur [i - 1]; // Compteur du tableau 

            operationElementaireTriDenombrement++; // Nombre d'opération élémentaire du tri par dénombrement augmente
        }

        for (int i = 0; i < taille; ++i) { // Compte la taille de la clé de l'élément

            reste [tableauCompteur [this.elements [i].getCle ()] - 1] = this.elements [i]; // Reste de la clé de l'élément du compteur de tableau 

            --tableauCompteur [this.elements [i].getCle ()]; // Diminue le compteur de tableau pour la clé de l'élément

            operationElementaireTriDenombrement = operationElementaireTriDenombrement + 2; // Nombre d'opération élémentaire du tri par dénombrement
        }

        for (int i = 0; i < taille; ++i) { // Compte la taille de la clé de l'élément

            this.elements [i] = reste [i]; // Reste les éléments de la clé de l'élément

            operationElementaireTriDenombrement++; // Nombre d'opération élémentaire du tri par dénombrement augmente
        }
    }

    public int valeurMaximale () { // Création d'un int (méthode) valeurMaximale, qui donne la valeur maximale du tableau d'élément
    
        int maximum = this.elements [0].getCle (); // Valeur maximale de la clé de l'élément

        for (int i = 1; i < this.taille; i++) { // Compte la taille de la clé de l'élément

            if (this.elements [i].getCle () > maximum) { // Si la clé de l'élément est supérieur à la valeur maximale

                maximum = this.elements [i].getCle (); // Valeur maximale de la clé de l'élément
            }
        }

        return maximum; // Retourne la valeur maximale
    }

    public void afficherTriDenombrement () { // Création d'une méthode afficherTriDenombrement sans paramètres, qui affiche le tri par dénombrement
        
        if (this.taille > 0) { // Si la taille du tableau est supérieur à 0

            System.out.println ("Tableau Denombrement avant triDenombrement : \n" + this); // Affiche les éléments du tableau avant le tri par dénombrement 

            double debutTempsTriDenombrement = System.nanoTime (); // Début du temps pour le tri par dénombrement donné en nanosecondes

            this.triDenombrement (); // Tri par dénombrement

            double finTempsTriDenombrement = System.nanoTime (); // Fin du temps pour le tri par dénombrement donné en nanosecondes

            System.out.println ("Tableau Denombrement apres triDenombrement : \n" + this); // Affiche les éléments du tableau après le tri par dénombrement 

            afficherDuree ("Tri Denombrement", debutTempsTriDenombrement, finTempsTriDenombrement); // Affiche la durée du tri par dénombrement

            System.out.println ("Nombre d'operations elementaires tri denombrement : " + operationElementaireTriDenombrement); // Affiche le nombre d'opérations élémentaires du tri par dénombrement 

        } else { // Sinon on retourne, que le tableau de tri par dénombrement est inférieur à 0 

            System.out.println ("Tableau Denombrement de taille <= 0"); // Affiche que le tableau de tri par dénombrement est inférieur à 0 
        }
    }

    public void remplir (int grandeur) { // Création d'une méthode remplir, qui rempli le tableau avec le paramètre grandeur 

        for (int i = 0; i < this.taille; i++) { // Compte la taille de la clé de l'élément

            this.elements [i] = new Element (genereCle (grandeur), genereValeur ()); // Création d'un élément qui génère la grandeur de la clé et la valeur
        }
    }

    public String toString () { // Création d'un String (méthode) toString, qui affiche le tableau d'élément sous forme de chaine de caractère

        StringBuilder stringBuilder = new StringBuilder (); // Création d'un nouveau stringBuilder, qui génère une chaine de caractère vide avec synchronisation

        if (this.taille == 0) { // Si la taille du tableau d'élément est 0

            return "taille 0"; // Retourne la taille 0
        }

        for (int i = 0; i < this.taille; i++) { // Compte la taille de la clé de l'élément

            if (this.elements [i] == null) { // Si les éléments du tableau d'élément sont nuls

                stringBuilder.append (String.format ("%20s", "indice " + i + "=> null")).append ("\n"); // Ajoute une chaine de caractère que les éléments du tableau d'élément sont nuls

            } else { // Sinon on retourne une chaine de caractère avec la clé et la valeur des éléments du tableau d'élément

                stringBuilder.append (String.format ("%20s", this.elements [i].getCle () + " => " + this.elements [i].getValeur ())).append ("\n");
            }
        }

        return stringBuilder.toString (); // Retourne le tableau d'élément sous forme de chaine de caractère
    }
}
