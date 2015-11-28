package com.kedzier.caching.task3;

import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Collection;

@SpringBootApplication
@EnableCaching
public class Task3Application implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Task3Application.class);

    @Autowired
    private CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(Task3Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        printCar(1L);
        printCar(1L);
        printCars(1L, 2L);
        printCars(1L, 2L);
        Car myNewCar = new Car(100L, "red", "new one");
        carRepository.add(myNewCar);
        printCars(1L, 100L);
        carRepository.delete(myNewCar);
        printCars(1L, 100L);

    }

    private void printCarsCount() {
        LOG.info("> About to print cars count");
        Collection<Car> cars = carRepository.getAll();
        LOG.info("> [{}] cars found", cars.size());
    }

    private void printCar(Long id) {
        LOG.info("> About to print car with id [{}]...", id);
        Car car = carRepository.getById(id);
        if (car != null) {
            LOG.info("> {}", car);
        } else {
            LOG.info("> Car not found");
        }
    }

    private void printCars(Long... ids) {
        LOG.info("> About to print cars with ids [{}]...", Joiner.on(",").join(ids));
        Collection<Car> cars = carRepository.getByIds(ids);
        for (Car car : cars) {
            if (car != null) {
                LOG.info("> {}", car);
            } else {
                LOG.info("> Car not found");
            }
        }
    }

}
