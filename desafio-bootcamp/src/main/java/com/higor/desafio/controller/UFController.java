package com.higor.desafio.controller;

import com.higor.desafio.entidades.UF;
import com.higor.desafio.repository.UFRepository;
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
@RequestMapping("/ufs")
public class UFController {
    @Autowired
    private UFRepository ufRepository;

    @GetMapping
    public ResponseEntity<List<UF>> getAllUFs() {
        return new ResponseEntity<>(ufRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UF> createUF(@RequestBody UF uf) {
        try {
            return new ResponseEntity<>(ufRepository.save(uf), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UF> updateUF(@PathVariable("id") long id, @RequestBody UF uf) {
        Optional<UF> ufData = ufRepository.findById(id);
        if (ufData.isPresent()) {
            UF _uf = ufData.get();
            _uf.setNome(uf.getNome());
            _uf.setSigla(uf.getSigla());
            _uf.setStatus(uf.getStatus());
            return new ResponseEntity<>(ufRepository.save(_uf), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
