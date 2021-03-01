package com.estagio2.folders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estagio2.folders.model.Post;

public interface Posts extends JpaRepository<Post, Long> {

}
