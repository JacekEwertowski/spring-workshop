package com.kedzier.caching.task3;

import java.util.Collection;

/**
 * @author kedzierm
 */
public interface CarRepository {

    Car getById(Long id);

    Car add(Car car);

    void delete(Car car);

    Collection<Car> getAll();

    Collection<Car> getByIds(Long... ids);

}
