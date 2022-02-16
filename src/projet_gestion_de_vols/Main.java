package projet_gestion_de_vols;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Path path = Paths.get("books.txt");
		System.out.println(Files.exists(path));
        /**
        Ville Meknes = new Ville("Meknes");
		Ville Fes = new Ville("Fes");
        LinkedList<Ville> villes = new LinkedList<Ville>();
		for(int i=0;i<Ville.getNbr_ville();i++) {
        		villes.add((Ville) ois.readObject());
        }

        System.out.println(villes.toString());
		
		Aeroport amir = new Aeroport("amir",Meknes);
		Aeroport mohamed6 = new Aeroport("mohamed6",Fes);
		Avion sputnik = new Avion("boeing747",100);
		Client lembarkiMohamed = new Client("lembarki","mohamed");
		Client elkhaldiIhsane = new Client("elkhaldi","ihsane");
		Vol v1 = new Vol(amir,mohamed6,"13/02/2021 14:30","13/02/2021 15:30",sputnik,150);
		v1.reserver(lembarkiMohamed);
		v1.reserver(elkhaldiIhsane);
		System.out.print(v1.getSiegeDispo());
		System.out.print(v1.getPassagers().toString());
		**/
	}

}
