package com.jaoafonso.testebackend.repositories;

import com.jaoafonso.testebackend.models.VendedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorModel, Long> {

}
