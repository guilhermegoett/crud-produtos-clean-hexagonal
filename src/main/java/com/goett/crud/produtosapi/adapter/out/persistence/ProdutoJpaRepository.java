package com.goett.crud.produtosapi.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goett.crud.produtosapi.infrastructure.persistence.entity.ProdutoEntity;

@Repository
public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, Long> {
}
