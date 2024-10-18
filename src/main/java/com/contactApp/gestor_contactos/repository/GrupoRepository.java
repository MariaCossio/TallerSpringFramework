package com.contactApp.gestor_contactos.repository;

import com.contactApp.gestor_contactos.model.Grupo;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface GrupoRepository extends CrudRepository<Grupo, Long> {
    List<Grupo> findByNombre(String Nombre);
}
