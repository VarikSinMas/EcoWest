package com.example.eco.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.eco.UsuarioServices.EventoService;
import com.example.eco.models.EventImg;
import com.example.eco.models.Eventos;
import com.example.eco.models.PartCheck;
import com.example.eco.models.Participante;

@RestController
public class EventoController {

	@Autowired
	private EventoService EventoService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

//		@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = "application/json")
//		public List<Usuarios> getUsuarios() {
//			return usuarioService.findAllUsers();
//		}

	@GetMapping("/eventos")
	public List<Eventos> getEventos() {
		return EventoService.findAllEvents();
	}
 
	@GetMapping("/eventos/{id}")
	public Optional<Eventos> getEventosById(@PathVariable int id) {
		return EventoService.findbyId(id);
	}

	@PostMapping("/eventos/addEvent")
	public Eventos addEventos(@RequestBody Eventos evento) {
		return EventoService.saveEvento(evento);
	}
	
//	@GetMapping("/participantes/{id_event}")
//	public List<Participante> getParticipantes(@RequestParam int id_event) {
//		return EventoService.findAllParts(id_event);
//	}
	
	@PostMapping("/eventos/addPart")
	public Participante addPart(@RequestBody Participante part) {
		return EventoService.savePart(part);
	}
	
	@GetMapping("part/update/{id_user}/{id_event}")
	
	public String updateParticipante(@PathVariable int id_user, @PathVariable int id_event) {
	
	return EventoService.updatePart(id_user, id_event);
	}
	
	@GetMapping("part/delete/{id_user}/{id_event}")
	
	public String deleteParticipante(@PathVariable int id_user, @PathVariable int id_event) {
	
	return EventoService.deletePart(id_user, id_event);

	
	}

	@GetMapping("/usuarios/deleteEvent/{id_event}")
	public String deleteEvento(@PathVariable int id_event) {
		return EventoService.deleteEventos(id_event);
	}

	@PatchMapping("eventos/update")
	public String updateEvento(Eventos eventoNuevo) {
		return EventoService.updateEventos(eventoNuevo);
	}
	
	
	
		
	@GetMapping("/getEvents/{id}")
	@ResponseBody
	public List<EventImg> eventoImagen(@PathVariable int id) {
		String sql = "call getEvents("+id+")";
		List<Map<String, Object>> listMapQuery = jdbcTemplate.queryForList(sql);
		List<EventImg> listEventImg = new ArrayList<EventImg>();
		EventImg eventImg;

		for (Map<String, Object> map : listMapQuery) {

			eventImg = new EventImg();
			int id_event = (int) map.get("id_event");
			eventImg.setId_event(id_event);
			String name = (String) map.get("name");
			eventImg.setName(name);
			String description = (String) map.get("description");
			eventImg.setDescription(description);
			String type = (String) map.get("type");
			eventImg.setType(type);
			int created_by_user = (int) map.get("created_by_user");
			eventImg.setCreated_by_user(created_by_user);
			
			String creation_date = (String) map.get("creation_date").toString();
			eventImg.setCreation_date(creation_date);
			String event_date = (String) map.get("event_date").toString();
			eventImg.setEvent_date(event_date);
			String duration = (String) map.get("duration").toString();
			eventImg.setDuration(duration);
			
			int number_of_participants = (int) map.get("number_of_participants");
			eventImg.setNumber_of_participants(number_of_participants);
			String maps_location = (String) map.get("maps_location");
			eventImg.setMaps_location(maps_location);
			String province = (String) map.get("province");
			eventImg.setProvince(province);
			String image = (String) map.get("image");
			eventImg.setImage(image);
			String nickname = (String) map.get("nickname");
			eventImg.setNickname(nickname);
			String name_user = (String) map.get("name_user");
			eventImg.setName_user(name_user);
			String surname_user = (String) map.get("surname_user");
			eventImg.setSurname_user(surname_user);
			String image_user = (String) map.get("image_user");
			eventImg.setImage_user(image_user);

			listEventImg.add(eventImg);

		}

		return listEventImg;
	}
	
	@GetMapping("/partcheck/{id_event}")
	@ResponseBody
	public List<PartCheck> eventoById(@PathVariable int id_event) {
		String sql = "call getParticipants("+id_event+")";
		List<Map<String, Object>> listMapQuery = jdbcTemplate.queryForList(sql);
		List<PartCheck> listParticipante = new ArrayList<PartCheck>();
		PartCheck part;

		for (Map<String, Object> map : listMapQuery) {

			part = new PartCheck();
			int id_evento = (int) map.get("id_event");
			part.setId_event(id_evento);
			int id_user = (int) map.get("id_user");
			part.setId_user(id_user);
			String inscription_date = (String) map.get("inscription_date").toString();
			part.setInscription_date(inscription_date);
			String nickname = (String) map.get("nickname");
			part.setNickname(nickname);
			String name = (String) map.get("name");
			part.setName(name);
			String surname = (String) map.get("surname");
			part.setSurname(surname);
			String mail = (String) map.get("mail");
			part.setMail(mail);
			String image = (String) map.get("image");
			part.setImage(image);
			Boolean attendace = (Boolean) map.get("attendance");
			part.setAttendace(attendace);
		

			listParticipante.add(part);

		}

		return listParticipante;
	}
	
		@GetMapping("rank/update/{id_event}/{id_creator}/{arrayUsers}")
			
			public String updateRanking(@PathVariable int id_event, @PathVariable int id_creator, @PathVariable String arrayUsers) {
			
			String sql = "call updateAttendanceAndRanking("+id_event+","+id_creator+",'"+arrayUsers+"')";
			jdbcTemplate.update(sql);
			
			return "Usuarios actualizados";	
		}
		
		@GetMapping("image/post/{eventOrUser}/{image}")
		
		public String updateImage(@PathVariable String eventOrUser, @PathVariable String image) {
		
		String sql = "call updateImage("+eventOrUser+","+image+")";
		jdbcTemplate.update(sql);
		
		return "Imagenes actualizadas";
		
	}
}
