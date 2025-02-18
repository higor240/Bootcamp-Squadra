package com.higor.desafio.controller;

import com.higor.desafio.entidades.Bairro;
import com.higor.desafio.repository.BairroRepository;
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
@RequestMapping("/bairros")
public class BairroController {
    @Autowired
    private BairroRepository bairroRepository;

    @GetMapping
    public ResponseEntity<List<Bairro>> getAllBairros() {
        return new ResponseEntity<>(bairroRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bairro> createBairro(@RequestBody Bairro bairro) {
        try {
            return new ResponseEntity<>(bairroRepository.save(bairro), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bairro> updateBairro(@PathVariable("id") long id, @RequestBody Bairro bairro) {
        Optional<Bairro> bairroData = bairroRepository.findById(id);
        if (bairroData.isPresent()) {
            Bairro _bairro = bairroData.get();
            _bairro.setNome(bairro.getNome());
            _bairro.setStatus(bairro.getStatus());
            return new ResponseEntity<>(bairroRepository.save(_bairro), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


