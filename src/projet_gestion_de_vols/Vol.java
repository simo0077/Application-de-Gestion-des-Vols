package projet_gestion_de_vols;

import java.io.Serializable;
import java.util.LinkedList;

public class Vol implements Serializable {
	private int volId;
	private Aeroport aeroDepart;
	private Aeroport aeroArrivee;
	private String dateDepart;
	private String dateArrivee;
	private LinkedList<Client> passagers = new LinkedList<Client>();
	private Avion avion;
	private int siegeDispo ;
	private int prix;
	private static int nbr_vols = 0;
	public Vol(Aeroport aeroDepart, Aeroport aeroArrivee,String dateDepart,String dateArrivee,Avion avion, int prix) {
		this.aeroDepart = aeroDepart;
		this.aeroArrivee = aeroArrivee;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.avion = avion;
		this.prix = prix;
		this.volId = ++nbr_vols;
		this.siegeDispo= avion.getCapacite();
	}
	public Aeroport getAeroArrivee() {
		return aeroArrivee;
	}
	public Aeroport getAeroDepart() {
		return aeroDepart;
	}
	public Avion getAvion() {
		return avion;
	}
	public String getDateArrivee() {
		return dateArrivee;
	}
	public String getDateDepart() {
		return dateDepart;
	}public LinkedList<Client> getPassagers() {
		return passagers;
	}
	public int getVolId() {
		return volId;
	}
	public int getSiegeDispo() {
		return siegeDispo;
	}
	public int getPrix() {
		return prix;
	}
	public void reserver(Client client) {
		this.passagers.add(client);
		this.siegeDispo --;
		
	}
	public void supprimerPassager(Client client) {
		for(int i=0;i<this.passagers.size();i++) {
			if(passagers.get(i).getClientId() == client.getClientId()) {
				passagers.remove(i);
			}
		}
	}
	public void modify(Aeroport aeroDepart, Aeroport aeroArrivee,String dateDepart,String dateArrivee,Avion avion, int prix) {
		this.aeroDepart = aeroDepart;
		this.aeroArrivee = aeroArrivee;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.avion = avion;
		this.prix = prix;
	}
	public static int getNbr_vols() {
		return nbr_vols;
	}
}
