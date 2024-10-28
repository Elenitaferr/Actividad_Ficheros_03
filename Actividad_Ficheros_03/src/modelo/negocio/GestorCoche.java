package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.DaoFicheroCoche;

public class GestorCoche {
	private DaoFicheroCoche dc;
	
	public GestorCoche() {
		dc = new DaoFicheroCoche();
	}
	
	public int guardar(Coche c) throws Exception {
		
		if(c.getMarca().isBlank() && c.getModelo().isEmpty()) {
			return 3;
		}else
		if (c.getMarca().isBlank()) {
			return 1;
		} else {
			if(c.getModelo().isEmpty()) {
				return 2;
			}
			boolean persistido = dc.guardar(c);
			if (persistido) {
				return 4;
				}else {
					return 5;
				}
			}
			
		}

	
	public boolean borrar(int id) {
		try {
		return dc.borrar(id);
		}catch(Exception e) {
		return false;
		}
		}
	
	public List<Coche> listar(){
		try {
			return dc.listar();
		} catch (Exception e) {
			return null;
			}
		}
		
	public Coche getById(int id) {
		try {
			return dc.obtener(id);
		} catch (Exception e) {
			return null;
		}
		
	
	}
	
	
	}
	

