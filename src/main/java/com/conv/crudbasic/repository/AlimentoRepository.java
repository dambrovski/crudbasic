package com.conv.crudbasic.repository;

import org.springframework.data.repository.CrudRepository;

import com.conv.crudbasic.models.Alimento;

public interface AlimentoRepository extends CrudRepository<Alimento, String> {
	Alimento findByCodigo(long codigo);

}
