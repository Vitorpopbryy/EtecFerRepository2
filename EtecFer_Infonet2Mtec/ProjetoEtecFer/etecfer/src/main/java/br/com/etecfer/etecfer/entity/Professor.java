package br.com.etecfer.etecfer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Professor {
      //Classe de modelagem
    // definição dos atributos da entidade Professor
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProfessor;

    @Column(nullable = false, length = 40)
    private String nomeProfessor;

    @Column(length = 11)
    private String telefoneProfessor;

    @Column(nullable = false, length = 11)
    private String cpfProfessor;

    @Column(nullable = false, length = 40)
    private String graduacaoProfessor;
}
