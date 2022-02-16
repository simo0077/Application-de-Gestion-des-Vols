package projet_gestion_de_vols;

import java.io.Serializable;

public class Avion implements Serializable{
	private int avionId;
	private String modele;
	private int capacite;
	private boolean status;
	private static int nbr_Avion =0;
	public Avion(String modele, int capacite) {
		this.modele =  modele ;
        this.avionId = ++nbr_Avion;
        this.status = true;
        this.capacite = capacite;
	}
	public int getCapacite() {
		return capacite;
	}
	public String getModele() {
		return modele;
	}
	public int getAvionId() {
		return avionId;
	}
	public void modify(String modele, int capacite) {
		this.modele =  modele ;
        this.capacite = capacite;
	}
	public void delete() {
		this.status = false;
	}
public static void setNbr_Avion(int nbr_Avion) {
	Avion.nbr_Avion = nbr_Avion;
}
}
