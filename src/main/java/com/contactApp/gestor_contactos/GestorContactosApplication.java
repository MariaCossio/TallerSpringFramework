package com.contactApp.gestor_contactos;

import com.contactApp.gestor_contactos.model.Contacto;
import com.contactApp.gestor_contactos.model.Grupo;
import com.contactApp.gestor_contactos.model.Usuario;
import com.contactApp.gestor_contactos.repository.ContactoRepository;
import com.contactApp.gestor_contactos.repository.GrupoRepository;
import com.contactApp.gestor_contactos.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestorContactosApplication {

	private static final Logger log = LoggerFactory.getLogger(GestorContactosApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GestorContactosApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ContactoRepository contactoRepository, GrupoRepository grupoRepository, UsuarioRepository usuarioRepository) {
		return (args) -> {
			contactoRepository.save(new Contacto("Juan", "123-246-890", "Juan@example.com"));
			contactoRepository.save(new Contacto("Ana", "123-246-891", "Ana@example.com"));
			contactoRepository.save(new Contacto("Luis", "123-246-892", "Luis@example.com"));

			grupoRepository.save(new Grupo("Familia"));
			grupoRepository.save(new Grupo("Amigos"));
			grupoRepository.save(new Grupo("Trabajos"));

			usuarioRepository.save(new Usuario("Maria","Password1"));
			usuarioRepository.save(new Usuario("Paula","Password2"));
			usuarioRepository.save(new Usuario("Andrea","Password3"));


			log.info("Contactos encontrados con findAll():");
			log.info("--------------------------------");
			contactoRepository.findAll().forEach(contacto -> {
				log.info(contacto.toString());
			});
			log.info("");

			log.info("Grupos encontrados con findAll():");
			log.info("--------------------------------");
			grupoRepository.findAll().forEach(grupo -> {
				log.info(grupo.toString());
			});
			log.info("");

			log.info("Usuarios encontrados con findAll():");
			log.info("--------------------------------");
			usuarioRepository.findAll().forEach(usuario -> {
				log.info(usuario.toString());
			});
			log.info("");

			Contacto contacto = contactoRepository.findById(1L);
			log.info("Contacto encontrado con findById(1L):");
			log.info("--------------------------------");
			log.info(contacto.toString());
			log.info("");

			Grupo grupo = grupoRepository.findById(1L).orElse(null);
			log.info("Grupo encontrado con findById(1L):");
			log.info("--------------------------------");
			log.info(grupo != null ? contacto.toString() : "Grupo no encontrado");
			log.info("");

			log.info("Contactos encontrados con findByNombre('Juan'):");
			log.info("---------------------------------------------");
			contactoRepository.findByNombre("Juan").forEach(juan -> {
				log.info(juan.toString());
			});
			log.info("");

			log.info("Grupo encontrados con findByNombre('Familia'):");
			log.info("---------------------------------------------");
			grupoRepository.findByNombre("Familia").forEach(familia -> {
				log.info(familia.toString());
			});
			log.info("");

			};

		}
	}


