package br.com.loginReact.login.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Dados")
@Getter
@Setter
public class InfoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private String email;
    private String okEmail;
    private String senha;
    private String okSenha;
}