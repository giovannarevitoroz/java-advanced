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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O livro deve ter um título") String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank(message = "O livro deve ter um título") String titulo) {
        this.titulo = titulo;
    }

    public @NotBlank(message = "O livro precisa ter  um autor") String getAutor() {
        return autor;
    }

    public void setAutor(@NotBlank(message = "O livro precisa ter  um autor") String autor) {
        this.autor = autor;
    }

    @NotBlank(message = "O livro precisa ter uma data de lançamento")
    public int getAnoPublicacao() {

        return anoPublicacao;
    }

    public void setAnoPublicacao(@NotBlank(message = "O livro precisa ter uma data de lançamento") int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public @NotBlank(message = "O número isbn deve ser preenchido") String getIsbn() {
        return isbn;
    }

    public void setIsbn(@NotBlank(message = "O número isbn deve ser preenchido") String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
