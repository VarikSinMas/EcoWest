package com.example.eco.UsuarioServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.eco.models.Eventos;
import com.example.eco.models.Participante;
import com.example.eco.repositories.EventoRepositorio;
import com.example.eco.repositories.PartRepositorio;

@Service
public class EventoServiceImpl implements EventoService{
	@Autowired
	EventoRepositorio eventoRepositorio;
	
	@Autowired
	PartRepositorio partRepositorio;
	
	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public List<Eventos> findAllEvents() {
		// TODO Auto-generated method stub
		return eventoRepositorio.findAll();
	}

	@Override
	public Optional<Eventos> findbyId(int id) {
		// TODO Auto-generated method stub
		return eventoRepositorio.findById(id);
	}

	@Override
	public Eventos saveEvento(Eventos eventoNuevo) {
		if (eventoNuevo != null) {
		return eventoRepositorio.save(eventoNuevo);
	}
	return eventoNuevo;
	}
	
	@Override
	public Participante savePart(Participante partNuevo) {
		if (partNuevo != null) {
		return partRepositorio.save(partNuevo);
	}
	return partNuevo;
	}

	@Override
	public String deleteEventos(int id_event) {

	      String SQL = "delete from eventos where id_event = ?";
	      jdbcTemplateObject.update(SQL, id_event);
	      
	      return "Evento eliminado";
		
		//return "Error! El evento no existe";
	}

	@Override
	public String updateEventos(Eventos eventoCambiado) {
		int num = eventoCambiado.getId_event();
		if(eventoRepositorio.findById(num).isPresent()) {
			Eventos eventosParaCambiar = new Eventos();
			eventosParaCambiar.setId_event(eventoCambiado.getId_event());
			eventosParaCambiar.setName(eventoCambiado.getName());
			eventosParaCambiar.setType(eventoCambiado.getType());
			eventosParaCambiar.setCreated_by_user(eventoCambiado.getCreated_by_user());
			eventosParaCambiar.setEvent_date(eventoCambiado.getEvent_date());
			eventosParaCambiar.setDuration(eventoCambiado.getDuration());
			eventosParaCambiar.setNumber_of_participants(eventoCambiado.getNumber_of_participants());
			eventosParaCambiar.setMaps_location(eventoCambiado.getMaps_location());
			eventosParaCambiar.setProvince(eventoCambiado.getProvince());
			eventosParaCambiar.setCreation_date(eventoCambiado.getCreation_date());
			return "Success!";
		}
		return "Failed";
	}
	
	@Override
	public String updatePart(int id_user, int id_event){
		
	      String SQL = "update eventos_participantes set attendance = 1 where id_user = ? and id_event = ?";
	      jdbcTemplateObject.update(SQL, id_user, id_event);
	      
	      return "Asistencia Actualizada";
	   }
	
	@Override
	public String deletePart(int id_user, int id_event){
		
	      String SQL = "delete from eventos_participantes where id_user = ? and id_event = ?";
	      jdbcTemplateObject.update(SQL, id_user, id_event);
	      
	      return "Asistencia eliminada";
	   }



	


}
