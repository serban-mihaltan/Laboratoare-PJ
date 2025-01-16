package com.lab11.lab11_p1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/jpa/evenimente")
public class EvenimentController {

    @Autowired
    private EvenimentRepository evenimentRepository;

    @GetMapping
    public List<Eveniment> getAllEvenimente() {
        return evenimentRepository.findAll();
    }

    @GetMapping("/locatie/{locatie}")
    public List<Eveniment> getEvenimenteByLocatie(@PathVariable String locatie) {
        return evenimentRepository.findByLocatie(locatie);
    }

    @GetMapping("/data/{data}")
    public List<Eveniment> getEvenimenteByData(@PathVariable String data) {
        return evenimentRepository.findByData(LocalDate.parse(data));
    }

    @PostMapping
    public ResponseEntity<Eveniment> createEveniment(@RequestBody Eveniment eveniment) {
        Eveniment savedEveniment = evenimentRepository.save(eveniment);
        return ResponseEntity.ok(savedEveniment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eveniment> updateEveniment(@PathVariable Long id, @RequestBody Eveniment evenimentDetails) {
        Eveniment eveniment = evenimentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Eveniment not found with id " + id));

        eveniment.setDenumire(evenimentDetails.getDenumire());
        eveniment.setLocatie(evenimentDetails.getLocatie());
        eveniment.setData(evenimentDetails.getData());
        eveniment.setTimp(evenimentDetails.getTimp());
        eveniment.setPret(evenimentDetails.getPret());

        Eveniment updatedEveniment = evenimentRepository.save(eveniment);
        return ResponseEntity.ok(updatedEveniment);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteEveniment(@PathVariable Long id) {
        evenimentRepository.deleteById(id);
        return ResponseEntity.ok("Eveniment with id " + id + " has been deleted.");
    }
}
