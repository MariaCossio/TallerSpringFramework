package com.contactApp.gestor_contactos.repository;

import com.contactApp.gestor_contactos.model.Contacto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactoRepository extends CrudRepository<Contacto, Long> {
    List<Contacto> findByNombre(String nombre);
    Contacto findById(long id);
}
