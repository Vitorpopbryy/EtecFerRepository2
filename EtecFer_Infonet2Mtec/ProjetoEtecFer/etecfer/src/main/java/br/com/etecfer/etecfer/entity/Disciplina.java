package br.com.etecfer.etecfer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Disciplina {
      //Classe de modelagem
    // definição dos atributos da entidade Disciplina
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idDisciplina;

    @Column(nullable = false, length = 40)
    private String nomeDisciplina;

    @Column(length = 5)
    private String siglaDisciplina;

    @Column(length = 20)
    private Integer chDisciplina;

    @ManyToOne
    @JoinColumn(name = "idCurso_fk")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "idProfessor_fk")
    private Professor professor;

}
