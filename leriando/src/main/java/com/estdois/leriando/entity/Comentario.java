package com.estdois.leriando.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Comentario {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @NotNull
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id",referencedColumnName = "id")
    @JsonIgnore
    private Post post;

    @ManyToOne
    @JoinColumn(name = "Usuario_id",referencedColumnName = "id")
    @JsonIgnore
    private Usuario usuario;


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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getPostId(){
        return this.post.id;
    }

    /*@Override
    public String toString() {
        return "Comentario [text=" + text + "]";
    }*/
}
