package com.lab10.lab10_p1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarteRepository extends JpaRepository<Carte, String> {
    //@Query("SELECT c FROM Carte c WHERE c.autor = :autor")
    List<Carte> findByAutor(@Param("autor") String autor);
}
