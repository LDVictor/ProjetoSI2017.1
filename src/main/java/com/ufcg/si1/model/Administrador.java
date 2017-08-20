package com.ufcg.si1.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_admin")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin", nullable = false, unique = true)
    private Long id;

    @Column(name = "nome_admin")
    private String login;

    @Column(name = "email_admin")
    private String senha;

    public Administrador() {

    }

    public Administrador(String login, String senha) {
        this.login = login;
        this.senha = senha;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Administrador)) return false;

        Administrador that = (Administrador) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

