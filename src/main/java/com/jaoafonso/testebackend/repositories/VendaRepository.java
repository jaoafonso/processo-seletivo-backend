package com.jaoafonso.testebackend.repositories;

import com.jaoafonso.testebackend.models.VendaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<VendaModel, Long> {

}
