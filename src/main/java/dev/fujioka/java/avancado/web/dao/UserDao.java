package dev.fujioka.java.avancado.web.dao;

import java.util.List;

import javax.persistence.EntityManager;

import dev.fujioka.java.avancado.web.domain.User;



public class UserDao {

	 public void persist(User user) {
	        EntityManager em = JPAUtil.getEntityManager();
	        em.getTransaction().begin();
	        em.persist(user);
	        em.getTransaction().commit();
	    }

	    public void remove(User user) {
	        EntityManager em = JPAUtil.getEntityManager();
	        em.getTransaction().begin();
	        em.remove(user);
	        em.getTransaction().commit();
	    }

	    public void update(User user) {
	        EntityManager em = JPAUtil.getEntityManager();
	        em.getTransaction().begin();
	        em.merge(user);
	        em.getTransaction().commit();
	    }

	    public List<User> list() {
	        EntityManager em = JPAUtil.getEntityManager();

	        return em.createQuery("SELECT u FROM User u", User.class)
	                .getResultList();
	    }

	    public User get(long id) {
	        EntityManager em = JPAUtil.getEntityManager();
	        return em.getReference(User.class, id);
	    }
}
