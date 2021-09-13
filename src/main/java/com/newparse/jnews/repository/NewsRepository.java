package com.newparse.jnews.repository;

import com.newparse.jnews.entity.News;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface NewsRepository extends CrudRepository<News, String> { }