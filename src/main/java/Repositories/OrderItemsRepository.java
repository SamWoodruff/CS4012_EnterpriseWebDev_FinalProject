package Repositories;

import entities.*;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemsRepository extends CrudRepository<OrderItem,Integer> {
}
