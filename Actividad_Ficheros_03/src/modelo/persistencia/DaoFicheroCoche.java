package modelo.persistencia;


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
	
	public boolean guardar(Coche coche) throws Exception{
		try(FileOutputStream file = new FileOutputStream(FICHERO_COCHES);
				ObjectOutputStream escritor = new ObjectOutputStream(file);) {
			List<Coche>lista = listar();
			coche.setId(++contadorID);
			lista.add(coche);
			for (Coche c : lista) {
				escritor.writeObject(c);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Coche obtener(int id) throws Exception {
		List<Coche>lista = listar();
		for (Coche c :lista) {
			if(c.getId() == id) {
				return c;
			}
		}
		return null;
	}
	
	public List<Coche> listar()throws Exception{
		List<Coche> listaCoches = new ArrayList<Coche>();
		
		try (FileInputStream file = new FileInputStream(FICHERO_COCHES);
				ObjectInputStream lector = new ObjectInputStream(file);){
			int bytesEnBuffer = file.available();
			Coche coche  = null;
			while (bytesEnBuffer > 0) {//mientras haya bytes que leer, sigo leyendo objetos
					coche = (Coche) lector.readObject();//leemos
					listaCoches.add(coche);
					bytesEnBuffer = file.available();
			}
			
		} catch (IOException e) {
			throw e;
		}
		return listaCoches;
	}

	public boolean borrar(int id) throws Exception{
		Coche c = obtener(id);
			List<Coche> lista = listar();
			boolean borrado = lista.remove(c);
			if(borrado) {
					try(FileOutputStream file = new FileOutputStream(FICHERO_COCHES);
							ObjectOutputStream escritor = new ObjectOutputStream(file);) {
						for (Coche coche : lista) {
							escritor.writeObject(coche);
						}
						return true;
					} catch (Exception e) {
						return false;
					}
				}else {
					return false;
			}
		}
	}



