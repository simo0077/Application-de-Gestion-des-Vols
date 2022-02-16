package projet_gestion_de_vols;

import java.io.Serializable;

public class Aeroport implements Serializable{
	private int AeroportId;
	private String nom ;
    private Ville ville ;
    private boolean status;
    private static int nbr_Aeroport =0;

    // Constructeur
    public Aeroport(String nom ,Ville ville){
        this.nom =  nom ;
        this.AeroportId = ++nbr_Aeroport;
        this.ville = ville ;
        this.status = true;
        ville.addAeroport(this);
    }

    //getters des attributs
    public String get_nom (){
        return nom ;
    }
    public int get_AeroportId (){
        return AeroportId ;
    }
    public Ville getVille(){
        return ville ;
    }public static void setNbr_Aeroport(int nbr_Aeroport) {
		Aeroport.nbr_Aeroport = nbr_Aeroport;
	}
    public void modify(String nom ,Ville ville){
        this.nom =  nom ;
        this.ville = ville ;
        
    }
    public void delete() {
    	this.status = false;
    }

}
