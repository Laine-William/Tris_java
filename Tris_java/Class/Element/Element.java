public class Element { // Création d'une class Element

    private int cle; // Clé de l'élément 

    private String valeur; // Valeur de l'élément 

    public Element () { // Création d'un constructeur de l'Element sans paramètres cle et valeur, qui sont la clé et la valeur de l'élément

        this.cle = 0;

        this.valeur = null;
    }

    public Element (int cle, String valeur) { // Création d'un constructeur de l'Element avec des paramètres cle et valeur, qui sont la clé et la valeur de l'élément
        
        this.cle = cle;

        this.valeur = valeur;
    }

    public Element (Element element) { // Création d'un constructeur par recopie de l'Element avec un paramètre element, qui est l'élément à recopier 
        
        this.cle = element.cle;
        
        this.valeur = element.valeur;
    }

    public int getCle () { // Création d'un accesseur Cle, qui retourne la clé de l'élément 

        return this.cle;
    }

    public void setCle (Element element) { // Création d'une méthode Cle, qui modifie la clé de l'élément avec le paramètre element 

        this.cle = element.cle;
    }
    
    public String getValeur () { // Création d'un accesseur Valeur, qui retourne la valeur de l'élément 

        return this.valeur;
    }


    public void setValeur (Element element) { // Création d'une méthode Valeur, qui modifie la valeur de l'élément avec le paramètre element
    
        this.valeur = element.valeur;
    }

    public String toString () { // Création d'un String (méthode) toString, qui affiche le contenu de la cellule sous forme de chaine de caractère

        String string; // Affiche la chaine de caractère 

        string = this.cle + " " + this.valeur; // Clé et valeur de l'élément
        
        return string; // Retourne la clé et la valeur de l'élément
    }
}