package br.com.fiap.cp01.checkpoint01.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O livro deve ter um título")
    private String titulo;

    @NotBlank(message = "O livro precisa ter  um autor")
    private String autor;

    @NotBlank(message = "O livro precisa ter uma data de lançamento")
    private int anoPublicacao;

    @NotBlank(message = "O número isbn deve ser preenchido")
    private String isbn;

    private boolean disponivel;






}
