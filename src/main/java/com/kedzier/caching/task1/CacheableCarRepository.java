package com.kedzier.caching.task1;

import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author kedzierm
 */
@Component
public class CacheableCarRepository implements CarRepository {

    private static final Logger LOG = LoggerFactory.getLogger(CacheableCarRepository.class);

    private final Collection<Car> cars = Sets.newHashSet(
        new Car(1l, "red", "car1"),   //
        new Car(2l, "blue", "car2"),  //
        new Car(3l, "yellow", "car3"),      //
        new Car(4l, "black", "car4"),       //
        new Car(5l, "white", "car5"),     //
        new Car(6l, "green", "car6"),     //
        new Car(7l, "red", "car7"),     //
        new Car(8l, "red", "car8"),     //
        new Car(9l, "black", "car9"),     //
        new Car(10l, "red", "car10"));    //

    @Override
    public Car getById(Long id) {
        LOG.debug("*** Searching for car with id [{}] ***", id);
        return cars.stream().filter(car -> car.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void add(Car car) {
        LOG.debug("> Adding car [{}]", car);
        cars.add(car);
    }

    @Override
    public void delete(Car car) {
        LOG.debug("> Deleting car [{}]", car);
        cars.remove(car);
    }

}
