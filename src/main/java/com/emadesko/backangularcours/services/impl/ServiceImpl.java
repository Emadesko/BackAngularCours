package com.emadesko.backangularcours.services.impl;

import com.emadesko.backangularcours.services.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@RequiredArgsConstructor
public abstract class ServiceImpl<T> implements Service<T> {
    private final JpaRepository<T, Long> repository;

    @Override
    public T getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public T create(T t) {
        return repository.save(t);
    }

    @Override
    public abstract T update(Long id,T t);

    @Override
    public Boolean delete(Long id) {
        var data = this.repository.findById(id).orElse(null);
        if (data != null) {
            this.repository.delete(data);
            return true;
        }
        return false;
    }
}
