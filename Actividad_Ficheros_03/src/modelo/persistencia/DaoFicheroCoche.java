package modelo.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;

public class DaoFicheroCoche {
	private static final String FICHERO_COCHES = "coches.dat";
	private static int contadorID = 1;
	
	public boolean guardar(Coche coche) {
		try(FileOutputStream file = new FileOutputStream(FICHERO_COCHES, true);
				ObjectOutputStream escritor = new ObjectOutputStream(file);) {
			coche.setId(contadorID);
			escritor.writeObject(coche);
			contadorID++;
			return true;
		} catch (IOException e) {
			return false;
		}			
	}
	
	public Coche obtener(int id) {
		try (FileInputStream file = new FileInputStream(FICHERO_COCHES);
				ObjectInputStream lector = new ObjectInputStream(file);){
			int bytesEnBuffer = file.available();
			Coche coche  = null;
			while (bytesEnBuffer > 0) {//mientras haya bytes que leer, sigo leyendo objetos
				try {
					coche = (Coche) lector.readObject();//leemos
					if(coche.getId() == id) {
						return coche;
					}else {
						bytesEnBuffer = file.available();
					}
				} catch (Exception e2) {
					return null;
				} 				
			}
			return null;
		} catch (IOException e) {
			return null;
		}
	}
	
	public List<Coche> listar(){
		List<Coche> listaCoches = new ArrayList<Coche>();
		
		try (FileInputStream file = new FileInputStream(FICHERO_COCHES);
				ObjectInputStream lector = new ObjectInputStream(file);){
			int bytesEnBuffer = file.available();
			Coche coche  = null;
			while (bytesEnBuffer > 0) {//mientras haya bytes que leer, sigo leyendo objetos
				try {
					coche = (Coche) lector.readObject();//leemos
					listaCoches.add(coche);
				} catch (Exception e2) {
					return null;
				} 				
			}
			return listaCoches;
		} catch (IOException e) {
			return null;
		}
	}
	
	public boolean borrar(int id) {
		List<Coche> lista = listar();
		boolean encontrado = false;
		List<Coche> listaAuxiliar = new ArrayList<Coche>();
		
		
		for(Coche c : lista) {
			if(c.getId() == id) {
				encontrado = true;
			}else {
				listaAuxiliar.add(c);
			}
		}
		
		if(encontrado) {
			for(Coche c : listaAuxiliar) {
				File file = new File(FICHERO_COCHES);
				file.delete();
				guardar(c);
			}
			return true;
		}else {
			return false;
		}
	}
	

}
