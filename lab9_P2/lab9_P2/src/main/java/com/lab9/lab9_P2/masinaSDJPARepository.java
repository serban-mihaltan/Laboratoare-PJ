package com.lab9.lab9_P2;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface masinaSDJPARepository extends JpaRepository<Masina, String>
{
    List<Masina> findByNumarInmatriculare(String numarInamtriculare);
    List<Masina> findByNrKMGreaterThan(int nrKM);
    List<Masina> findByMarcaOrderByAnulFabricatieiDesc(String marca);
    int countByAnulFabricatiei(int anulFabricatiei);
    List<Masina> findByAnulFabricatieiGreaterThan(int anulFabricatiei);

    @Modifying
    @Query("DELETE FROM Masina m WHERE m.numarInmatriculare = :numarInmatriculare")
    void deleteByNrInmatriculare(@Param("numarInmatriculare") String numarInmatriculare);

    @Modifying
    @Query("UPDATE Masina m SET m.marca = :#{#masina.marca}, m.anulFabricatiei = :#{#masina.anulFabricatiei}, m.culoare = :#{#masina.culoare}, m.nrKM = :#{#masina.nrKM} WHERE m.numarInmatriculare = :numarInmatriculare")
    int updateMasinaByNumarInmatriculare(@Param("numarInmatriculare") String numarInmatriculare, @Param("masina") Masina masina);

    @Query("FROM Masina m WHERE m.nrKM < 100000")
    List<Masina> getMasiniCuKilometriPutini();

    @Query("FROM Masina m WHERE YEAR(CURRENT_DATE) - m.anulFabricatiei <= 5")
    List<Masina> getMasiniMaiNoiDe5Ani();

    List<Masina> findByMarca(String marca);

    List<Masina> findByNrKMLessThan(int i);
}
