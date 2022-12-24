package com.bolsadeideas.springboot.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Repository
@SessionAttributes("cliente")
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		if( cliente.getId() != null && cliente.getId() != 0) {
			em.merge(cliente);
		}else {
			em.persist(cliente);
		}
		
	}

	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}

}
