//package com.example.eco.repositories;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
//
//import com.example.eco.models.Usuarios;
//
//public class UsuarioRepositorioImpl implements UsuarioRepositorio{
//
//	@Override
//	public List<Usuarios> getUsuarios() {
//		return repos;
//	}
//
//	@Override
//	public void registrar(Usuarios usuario) {		
//	}
//
//	@Override
//	public void eliminar(Long id) {		
//	}
//
//	@Override
//	public List<Usuarios> findbyId() {
//		return null;
//	}
//
//	@Override
//	public List<Usuarios> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Usuarios> findAll(Sort sort) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Usuarios> findAllById(Iterable<Long> ids) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Usuarios> List<S> saveAll(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void flush() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public <S extends Usuarios> S saveAndFlush(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Usuarios> List<S> saveAllAndFlush(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void deleteAllInBatch(Iterable<Usuarios> entities) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAllByIdInBatch(Iterable<Long> ids) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAllInBatch() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Usuarios getOne(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Usuarios getById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Usuarios> List<S> findAll(Example<S> example) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Usuarios> List<S> findAll(Example<S> example, Sort sort) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Page<Usuarios> findAll(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Usuarios> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Optional<Usuarios> findById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean existsById(Long id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public long count() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void deleteById(Long id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(Usuarios entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAllById(Iterable<? extends Long> ids) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAll(Iterable<? extends Usuarios> entities) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public <S extends Usuarios> Optional<S> findOne(Example<S> example) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Usuarios> Page<S> findAll(Example<S> example, Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Usuarios> long count(Example<S> example) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public <S extends Usuarios> boolean exists(Example<S> example) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public <S extends Usuarios, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void save(Optional<Usuarios> UsuarioToUpdate) {
//		// TODO Auto-generated method stub
//		
//	}
//	
///*
//	 @PersistenceContext
//	    EntityManager entityManager;
//
//	public List<Usuarios> getUsuarios() {
//        String query = "FROM usuarios";
//        return entityManager.createQuery(query).getResultList();
//	}
//	
//	@Override
//    public void registrar(Usuarios usuario) {
//        entityManager.merge(usuario);
//    }
//	
//	@Override
//    public void eliminar(Long id) {
//        Usuarios usuario = entityManager.find(Usuarios.class, id);
//        entityManager.remove(usuario);
//    }
//    */
//}
