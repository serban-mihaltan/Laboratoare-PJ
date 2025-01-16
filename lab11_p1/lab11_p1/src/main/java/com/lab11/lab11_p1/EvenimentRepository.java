package com.lab11.lab11_p1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EvenimentRepository extends JpaRepository<Eveniment, Long> {
    List<Eveniment> findByLocatie(String locatie);
    List<Eveniment> findByData(LocalDate data);
}
