package com.ginalgo.contosopizza.repository;

import com.ginalgo.contosopizza.entity.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaCrudRepository extends CrudRepository<Pizza, Long> {
}
