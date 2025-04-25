package com.aula12.demo.dto;

import com.aula12.demo.model.Voo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.boot.jaxb.hbm.internal.RepresentationModeConverter;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@AllArgsConstructor
public class VooDto extends RepresentationModel<VooDto> {

    private Long id;

    private String codigo;

    private String companhia;

    private String origem;

    private String destino;

    public VooDto(Voo voo) {
        this.id= voo.getId();
        this.codigo = voo.getCodigo();
        this.companhia = voo.getCompanhia();
        this.origem = voo.getOrigem().getCidade();
        this.destino = voo.getDestino().getCidade();
    }


}
