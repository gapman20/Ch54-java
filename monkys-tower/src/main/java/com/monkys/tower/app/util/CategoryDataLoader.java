package com.monkys.tower.app.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.monkys.tower.app.model.Category;
import com.monkys.tower.app.repository.CategoryRepository;

@Component
@Order(2)
@Profile("h2")
public class CategoryDataLoader implements CommandLineRunner{

	@Autowired
	CategoryRepository categoryRepository;
	private static final Logger log = LoggerFactory.getLogger( CategoryDataLoader.class );

	
	@Override
	public void run(String... args) throws Exception {
		
		categoryRepository.save(new Category(null, "Technology", "Gadgets, computadoras, y accesorios electrónicos para la vida moderna."));
		categoryRepository.save(new Category(null, "Home & Garden","Artículos para decorar y mejorar tu casa, así como herramientas de jardinería."));
		categoryRepository.save(new Category(null, "Apparel", "Ropa, calzado y accesorios para hombres, mujeres y niños."));
		
		// Buscar todas las categorias que en su 'description' contenga
		// la palabra "accesorios"
		log.info("=== Mostrar categorias que en su nombre contenga ====");
		Iterable<Category> foundCategory = categoryRepository.findByDescriptionContainingIgnoreCase("accesorios");
		for(Category category : foundCategory) {			
			log.info("Categorias encontradas: {}", category);
		}
	}

}
