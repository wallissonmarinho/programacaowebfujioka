package dev.fujioka.java.avancado.web.repository;

import dev.fujioka.java.avancado.web.domain.Product;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
     extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p WHERE p.id = :id")
	public Product buscarPorId(Long id);

	@Query("SELECT p FROM Product p WHERE p.name = :name")
	public List<Product> buscarProdutoPorNome(@Param("name") String name);
	
	@Query("SELECT p FROM Product p Where p.name like %:string%")
	public List<Product> buscarProdutoPorSubstring(String string);
	
	@Query("SELECT p FROM Product p WHERE description like '%Dell%'")
		Product buscarProdutosDell();
	
	
}
