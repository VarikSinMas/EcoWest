package com.example.eco.UsuarioServices;

import java.util.List;
import java.util.Optional;

import com.example.eco.models.Eventos;
import com.example.eco.models.Participante;

public interface EventoService {

	public List<Eventos> findAllEvents();

	public Optional<Eventos> findbyId(int id);

	public Eventos saveEvento(Eventos eventoNuevo);
	
	public Participante savePart(Participante partNuevo);

	public String deleteEventos(int id);

	public String updateEventos(Eventos eventoNuevo);
	
	public String updatePart(int id_user, int id_event);

	public String deletePart(int id_user, int id_event);
	

}
