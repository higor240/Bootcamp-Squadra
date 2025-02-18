
package com.higor.desafio.repository;

import com.higor.desafio.entidades.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UFRepository extends JpaRepository<UF, Long> {}
