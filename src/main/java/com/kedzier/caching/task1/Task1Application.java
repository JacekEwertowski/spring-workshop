package com.kedzier.caching.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task1Application implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Task1Application.class);

    @Autowired
    private CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(Task1Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        printCar(1L);
        printCar(1L);
        printCar(2L);
        printCar(2L);
        Car myNewCar = new Car(100L, "red", "new one");
        carRepository.add(myNewCar);
        printCar(myNewCar.getId());
        carRepository.delete(myNewCar);
        printCar(myNewCar.getId());

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

}
