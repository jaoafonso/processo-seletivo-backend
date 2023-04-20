package com.jaoafonso.testebackend.repositories;

import com.jaoafonso.testebackend.models.VendaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface VendaRepository extends JpaRepository<VendaModel, Long> {

    @Query(value = "SELECT ROUND(CAST(COUNT(v.*) AS DOUBLE) / (DATEDIFF('DAY', :dataInicial, :dataFinal) + 1), 2) " +
                   "FROM TB_VENDA v " +
                   "WHERE v.vendedor_id = :idVendedor " +
                   "AND v.venda_data BETWEEN :dataInicial AND :dataFinal", nativeQuery = true)
    Double calcularMediaVendasDiariaPorVendedor(@Param("idVendedor") Long idVendedor,
                                                @Param("dataInicial") LocalDate dataInicial,
                                                @Param("dataFinal") LocalDate dataFinal);

    @Query(value = "SELECT COUNT(v.*) " +
                   "FROM TB_VENDA v " +
                   "WHERE v.vendedor_id = :idVendedor " +
                   "AND v.venda_data BETWEEN :dataInicial AND :dataFinal", nativeQuery = true)
    Integer calcularTotalVendasPorVendedor(@Param("idVendedor") Long idVendedor,
                                          @Param("dataInicial") LocalDate dataInicial,
                                          @Param("dataFinal") LocalDate dataFinal);

}
