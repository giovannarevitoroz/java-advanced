package com.aula12.demo.controller;

import com.aula12.demo.dto.VooDto;
import com.aula12.demo.service.VooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/voos")
public class VooController {
    @Autowired
    private VooService vooService;

    public VooController(VooService vooService) {
        this.vooService = vooService;
    }

//    //atualizar um voo existente
//    @PutMapping("/{id}")
//    public ResponseEntity<EntityModel<VooDto>> atualizar(@PathVariable Long id, @RequestBody VooDto dto){
//
//        VooDto atualizado = vooService.atualizar(id,dto);
//    }

    @GetMapping
    public List<VooDto> listarTodos() {
        return vooService.listarTodos().stream()
                .map(voo -> {
                    VooDto dto = new VooDto(voo);
                    dto.add(linkTo(methodOn(VooController.class).buscarPorId(voo.getId())).withSelfRel());
                    return dto;  // O retorno de cada VooDto
                })
                .collect(Collectors.toList());  // Necessário para coletar os elementos do stream em uma lista
    }

}
