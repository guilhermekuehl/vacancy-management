package br.com.guilhermekellermann.gestao_vagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.guilhermekellermann.gestao_vagas.exceptions.UserFoundException;
import br.com.guilhermekellermann.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.guilhermekellermann.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.guilhermekellermann.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCases;
import jakarta.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/candidate")

public class CandidateController {

    @Autowired
    private CreateCandidateUseCases createCandidateUseCase;
    
    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = this.createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
