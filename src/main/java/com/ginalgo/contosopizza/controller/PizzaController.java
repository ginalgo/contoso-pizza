package com.ginalgo.contosopizza.controller;

import com.ginalgo.contosopizza.dto.PizzaDto;
import com.ginalgo.contosopizza.service.PizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pizza")
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

}
