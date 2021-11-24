package com.ginalgo.contosopizza.controller;

import com.ginalgo.contosopizza.dto.PizzaDto;
import com.ginalgo.contosopizza.entity.Pizza;
import com.ginalgo.contosopizza.service.PizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    private PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PizzaDto pizzaDto) {
        pizzaService.create(pizzaDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/pizza")
    public ResponseEntity<Pizza> get(@RequestParam Long id) {
        Pizza pizza;
        try {
           pizza = pizzaService.get(id);
        }
        catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pizza);
    }

    @GetMapping
    public ResponseEntity<Iterable<Pizza>> getAll()
    {
        var pizzas = pizzaService.getAll();
        return ResponseEntity.ok(pizzas);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam Long id, @RequestBody PizzaDto newPizzaData) {
        try {
            pizzaService.update(id, newPizzaData);
        }
        catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long id) {
        try {
            pizzaService.delete(id);
        }
        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
