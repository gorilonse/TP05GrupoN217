package ar.edu.unju.fi.service;
import java.util.List;
import ar.edu.unju.fi.model.Docente;

	public interface IDocenteService {
	
		public void agregarDocente(Docente docente);
	public List<Docente> listarDocentes();
	public Docente buscarDocente(int id);
	public void modificarDocente(Docente docente, int id);
	public void eliminarDocente(int id);
	
}
