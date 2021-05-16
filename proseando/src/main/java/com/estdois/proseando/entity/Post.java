package com.estdois.proseando.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

@Entity
public class Post {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    protected Long id;

    @NotNull
    private String text;

    @NotNull
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "usuario_id",referencedColumnName = "id")
    private Usr usuario;


    @OneToMany(mappedBy = "post")
    private List<Comentario> comentarios = new ArrayList<>();

    public Post() {

    }

    public Post(Long id, String text, String tipo) {
        this.id = id;
        this.text = text;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usr getUsuario() {
        return usuario;
    }

    public void setUsuario(Usr usuario) {
        this.usuario = usuario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
	

}
