package com.kedzier.caching.task1;

/**
 * @author kedzierm
 */
public interface CarRepository {

    Car getById(Long id);

    void add(Car car);

    void delete(Car car);

}
