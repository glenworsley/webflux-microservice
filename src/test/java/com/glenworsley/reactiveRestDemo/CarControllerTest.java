package com.glenworsley.reactiveRestDemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CarControllerTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarController carController;

    @Test
    void getAllCallsRepositoryFindAll() {
        carController.all();
        verify(carRepository).findAll();
    }


}