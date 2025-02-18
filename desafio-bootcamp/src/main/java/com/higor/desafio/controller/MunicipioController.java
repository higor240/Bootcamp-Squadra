package com.higor.desafio.controller;

import com.higor.desafio.entidades.Municipio;
import com.higor.desafio.repository.MunicipioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/municipios")
public class MunicipioController {
    @Autowired
    private MunicipioRepository municipioRepository;

    @GetMapping
    public ResponseEntity<List<Municipio>> getAllMunicipios() {
        return new ResponseEntity<>(municipioRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Municipio> createMunicipio(@RequestBody Municipio municipio) {
        try {
            return new ResponseEntity<>(municipioRepository.save(municipio), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Municipio> updateMunicipio(@PathVariable("id") long id, @RequestBody Municipio municipio) {
        Optional<Municipio> municipioData = municipioRepository.findById(id);
        if (municipioData.isPresent()) {
            Municipio _municipio = municipioData.get();
            _municipio.setNome(municipio.getNome());
            _municipio.setStatus(municipio.getStatus());
            return new ResponseEntity<>(municipioRepository.save(_municipio), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}



