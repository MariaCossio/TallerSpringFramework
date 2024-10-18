package com.contactApp.gestor_contactos.repository;

import com.contactApp.gestor_contactos.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    List<Usuario> findByNombre(String nombre);
}
