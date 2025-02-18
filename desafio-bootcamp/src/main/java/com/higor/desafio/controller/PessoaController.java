package com.higor.desafio.controller;

import com.higor.desafio.entidades.Pessoa;
import com.higor.desafio.repository.PessoaRepository;
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
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        return new ResponseEntity<>(pessoaRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) {
        try {
            return new ResponseEntity<>(pessoaRepository.save(pessoa), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable("id") long id, @RequestBody Pessoa pessoa) {
        Optional<Pessoa> pessoaData = pessoaRepository.findById(id);
        if (pessoaData.isPresent()) {
            Pessoa _pessoa = pessoaData.get();
            _pessoa.setNome(pessoa.getNome());
            _pessoa.setSobrenome(pessoa.getSobrenome());
            _pessoa.setIdade(pessoa.getIdade());
            _pessoa.setLogin(pessoa.getLogin());
            _pessoa.setSenha(pessoa.getSenha());
            _pessoa.setStatus(pessoa.getStatus());
            return new ResponseEntity<>(pessoaRepository.save(_pessoa), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


