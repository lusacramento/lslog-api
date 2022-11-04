package com.lusacramento.lslog.domain.repository;

import com.lusacramento.lslog.domain.model.entity.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {


}
