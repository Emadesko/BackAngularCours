package com.emadesko.backangularcours.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Service <T> {
    T getById(Long id);
    List<T> findAll();
    Page<T> findAll(Pageable pageable);
    T create(T t);
    T update(Long id ,T t);
    Boolean delete(Long id);
}
