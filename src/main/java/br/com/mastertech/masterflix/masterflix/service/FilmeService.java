package br.com.mastertech.masterflix.masterflix.service;

import br.com.mastertech.masterflix.masterflix.model.Filme;
import br.com.mastertech.masterflix.masterflix.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public Filme cadastrarFilme(Filme filme) {
        filme.setAtivo(Boolean.TRUE);
        filme.setDataCriacao(LocalDate.now());
        return repository.save(filme);
    }

    public Iterable<Filme> listarFilmes() {
        Iterable<Filme> filmes = repository.findAll();
        return filmes;
    }

    public Filme listarFilme(String nome) {
        Optional<Filme> filme = repository.findByNome(nome);
        if (filme.isPresent()) {
            return filme.get();
        }
        return null;
    }
}
