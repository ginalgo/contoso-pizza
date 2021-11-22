package com.ginalgo.contosopizza.service.impl;

import com.ginalgo.contosopizza.dto.PizzaDto;
import com.ginalgo.contosopizza.entity.Pizza;
import com.ginalgo.contosopizza.repository.PizzaCrudRepository;
import com.ginalgo.contosopizza.service.PizzaService;
import org.springframework.stereotype.Service;

@Service
public class PizzaServiceImpl implements PizzaService {

    private PizzaCrudRepository pizzaCrudRepository;

    public PizzaServiceImpl(
            PizzaCrudRepository pizzaCrudRepository
    ) {
        this.pizzaCrudRepository = pizzaCrudRepository;
    }

    @Override
    public void create(PizzaDto pizzaDto) {
        Pizza pizza = new Pizza();
        pizza.setName(pizzaDto.getName());
        pizza.setIsGlutenFree(pizzaDto.getIsGlutenFree());

        pizzaCrudRepository.save(pizza);
    }
}
