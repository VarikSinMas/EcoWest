package com.example.eco.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.eco.UsuarioServices.UsuarioService;
import com.example.eco.models.DAOUsuarios;
import com.example.eco.models.PartCheck;
import com.example.eco.models.UserImg;
import com.example.eco.models.UserRank;

@RestController
public class UsuarioController {
	
	 @Autowired
	 private UsuarioService usuarioService;
	 
	 @Autowired
		private JdbcTemplate jdbcTemplate;
	 
	 
//		@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = "application/json")
//		public List<Usuarios> getUsuarios() {
//			return usuarioService.findAllUsers();
//		}
		
		@GetMapping("/usuarios")
		public List<DAOUsuarios> getUsuarios() {
			return usuarioService.findAllUsers();
		}
		
		@GetMapping("/usuarios/{id}")
		public Optional<DAOUsuarios> getUsuariosById(@PathVariable int id){
			return usuarioService.findbyId(id);
		}
		
		@PostMapping("/usuarios/addUser")
		public DAOUsuarios addUsuarios(@RequestBody DAOUsuarios usuario) {
			return  usuarioService.saveUsuario(usuario);
		}
		
		@PostMapping("/usuarios/deleteUser/{id}")
		public String deleteUsuario(@PathVariable int id) {
			return usuarioService.deleteUsuarios(id);
		}
		
		@PutMapping("/usuarios/update/{id}")
		public ResponseEntity<Object> updateUsuario(@RequestBody DAOUsuarios usuarioNuevo, @PathVariable int id) {
			
			usuarioService.updateUsuarios(usuarioNuevo, id);
			return ResponseEntity.ok(Boolean.TRUE);
			
		}
		
		@GetMapping("/points")
		@ResponseBody
		public List<UserRank> userRank() {
			String sql = "select distinct  u.id_user, u.nickname, r.points, i.image\n"
					+ "	from usuarios u \n"
					+ "inner join ranking r\n"
					+ "	on u.id_user = r.id_user\n"
					+ "left join imagenes_usuarios i\n"
					+ "	on r.id_user = i.user order by r.points DESC;";
			List<Map<String, Object>> listMapQuery = jdbcTemplate.queryForList(sql);
			List<UserRank> listUsersRanking = new ArrayList<UserRank>();
			UserRank userRank;
			
			for (Map<String, Object> map : listMapQuery) {
				
				userRank = new UserRank();
				int id = (int) map.get("id_user");
				userRank.setId_user(id);
				String nickname = (String) map.get("nickname");
				userRank.setNickname(nickname);
				int points = (int) map.get("points");
				userRank.setPoints(points);
				String image = (String) map.get("image");
				userRank.setImage(image); 
				
				listUsersRanking.add(userRank);
				
			}
			
			return listUsersRanking;
		}
		
		@GetMapping("/getuserimg")
		public List<UserImg> getUsuariosImg() {
			return usuarioService.findAllUserImg();
		}
		
		@GetMapping("/getuserimg/{id}")
		public Optional<UserImg> getUsuariosImgbyId(@PathVariable int id) {
			return usuarioService.findUserImgbyId(id);
		}

}
