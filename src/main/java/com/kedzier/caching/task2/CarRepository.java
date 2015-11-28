package com.kedzier.caching.task2;

import java.util.Collection;

/**
 * @author kedzierm
 */
public interface CarRepository {

    Car getById(Long id);

    Car add(Car car);

    void delete(Car car);

    Collection<Car> getAll();

}
