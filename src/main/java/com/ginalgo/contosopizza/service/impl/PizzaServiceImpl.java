package com.ginalgo.contosopizza.service.impl;

import com.ginalgo.contosopizza.dto.PizzaDto;
import com.ginalgo.contosopizza.entity.Pizza;
import com.ginalgo.contosopizza.repository.PizzaCrudRepository;
import com.ginalgo.contosopizza.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Pizza get(Long id) {
        return pizzaCrudRepository.findById(id).
                orElseThrow(RuntimeException::new);
    }

    @Override
    public Iterable<Pizza> getAll() {
        return pizzaCrudRepository.findAll();
    }

    @Override
    public void update(Long id, PizzaDto newPizzaData) {
        Pizza pizza = pizzaCrudRepository.findById(id).orElseThrow(RuntimeException::new);
        pizza.setIsGlutenFree(newPizzaData.getIsGlutenFree());
        pizza.setName(newPizzaData.getName());
        pizzaCrudRepository.save(pizza);
    }

    @Override
    public void delete(Long id) {
        Pizza pizza = get(id);
        pizzaCrudRepository.deleteById(id);
    }
}
