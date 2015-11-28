package com.kedzier.caching.task1;

/**
 * @author kedzierm
 */
public interface CarRepository {

    Car getById(Long id);

    Car add(Car car);

    void delete(Car car);

}
