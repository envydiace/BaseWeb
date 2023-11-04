package com.ndanh.Mapper;

import java.util.List;

public interface Mapper<E, D> {
    D toDto(E entity);
    E toEntity(D dto);
    List<D> toDto(List<E> entityList);
    List<E> toEntity(List<D> dtoList);
}
