package modelo.negocio;

import modelo.entidad.Coche;
import modelo.persistencia.DaoFicheroCoche;

public class GestorCoche {
	private DaoFicheroCoche dc;
	
	public int guardar(Coche c) {
		if (c == null) {
			return 0;
		}

		dc = new DaoFicheroCoche();

		if (c.getMarca().isEmpty()||c.getModelo().isEmpty()) {
			return 1;
		} else {
			if(dc.guardar(c)) {
				return 2;
			}else {
				return 3;
			}
			
		}

	}
	
	public boolean borrar(int id) throws Exception {
		dc = new DaoFicheroCoche();
		if (id < 0) {
			throw new Exception("No puede ser negativo");
		}
		return dc.borrar(id);

		}
	}
	

