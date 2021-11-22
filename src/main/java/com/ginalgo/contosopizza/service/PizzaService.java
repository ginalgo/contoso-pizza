package com.ginalgo.contosopizza.service;

import com.ginalgo.contosopizza.dto.PizzaDto;
import com.ginalgo.contosopizza.entity.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaService {
    void create(PizzaDto pizzaDto);
    Pizza get(Long id);
    Iterable<Pizza> getAll();
    void update(Long id, PizzaDto newPizzaDto);
    void delete(Long id);
}
