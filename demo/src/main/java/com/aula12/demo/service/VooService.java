package com.aula12.demo.service;

import com.aula12.demo.model.Voo;
import com.aula12.demo.repository.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class VooService {

    @Autowired
    private VooRepository vooRepository;

    public List<Voo> listarTodos() {
        return vooRepository.findAll();
    }

    public Page<Voo> listarPagiado(Pageable pageable) {
        return vooRepository.findAll(pageable);
    }

    public List<Voo> buscarCompanhia (String companhia) {
        return vooRepository.findByCompanhiaisContainingIgnoreCase(companhia);
    }

    public List<Voo> buscarPorOrigem(String cidade) {
        return vooRepository.buscarPorOrigemCidade(cidade);
    }

    public Voo salvar(Voo voo) {
        return vooRepository.save(voo);
    }

    public void deletar(Long id) {
        vooRepository.deleteById(id);
    }
}
