package com.glenworsley.reactiveRestDemo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CarRepository extends ReactiveCrudRepository<Car,String> {
}
