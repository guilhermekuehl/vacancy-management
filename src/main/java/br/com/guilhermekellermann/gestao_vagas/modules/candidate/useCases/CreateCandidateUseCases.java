package br.com.guilhermekellermann.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilhermekellermann.gestao_vagas.exceptions.UserFoundException;
import br.com.guilhermekellermann.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.guilhermekellermann.gestao_vagas.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCases {
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) -> {
            throw new UserFoundException();
        });
        return this.candidateRepository.save(candidateEntity);
    }
}
