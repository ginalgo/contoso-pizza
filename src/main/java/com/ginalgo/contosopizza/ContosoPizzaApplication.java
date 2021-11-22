package com.ginalgo.contosopizza;

import com.ginalgo.contosopizza.entity.Pizza;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContosoPizzaApplication {

    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        pizza.setName("Kal");

        SpringApplication.run(ContosoPizzaApplication.class, args);
    }

}
