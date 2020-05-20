package com.glenworsley.reactiveRestDemo;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
@Log4j2
public class DataInitializr {

    private final CarRepository carRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void go() {
        var cars = Flux.just(new Car(null, "toyota", "corolla", "BHZ736"),
                new Car(null, "ford", "falcon", "HFR553"))
                .flatMap(carRepository::save);

        this.carRepository.deleteAll()
                .thenMany(cars)
                .thenMany(this.carRepository.findAll())
                .subscribe(log::info);

    }
}
