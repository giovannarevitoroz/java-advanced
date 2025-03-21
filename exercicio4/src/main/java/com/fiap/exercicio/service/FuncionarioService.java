package com.fiap.exercicio.service;

import com.fiap.exercicio.exception.DepartamentoNaoEncontradoException;
import com.fiap.exercicio.exception.FuncionarioNaoEncontradoException;
import com.fiap.exercicio.model.Funcionario;
import com.fiap.exercicio.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Page<Funcionario> listarFuncionario(Pageable pageable) {
        return funcionarioRepository.findAll(pageable);

    }

    public Funcionario buscarPorId(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionario nao encontrado com Id: " + id));
    }

    public Funcionario salvar(Funcionario funcionario) {
        if(funcionario.getDepartamento().getId() != null){
            return funcionarioRepository.save(funcionario);
        }else {
            throw new DepartamentoNaoEncontradoException("Departamento não encontrado para atualizar");
        }
    }

    public Funcionario atualizar(Long id, Funcionario funcionarioAtualizado) {

        Funcionario funcionario = buscarPorId(id);

        if (funcionarioAtualizado.getId() != null) {
            funcionario.setNome(funcionarioAtualizado.getNome());
            funcionario.setSalario(funcionarioAtualizado.getSalario());
            funcionario.setCargo(funcionarioAtualizado.getCargo());
            funcionario.setCpf(funcionarioAtualizado.getCpf());
            funcionario.setDepartamento(funcionarioAtualizado.getDepartamento());
            return funcionarioRepository.save(funcionarioAtualizado);
        }else {
            throw new FuncionarioNaoEncontradoException("Funcionário não encontrado no sistema para atualizar");
        }

    }

    public void deletar(Long id) {
        Funcionario funcionario = buscarPorId(id);
        funcionarioRepository.delete(funcionario);
    }

}
