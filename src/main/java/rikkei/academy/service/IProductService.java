package rikkei.academy.service;

import org.springframework.stereotype.Service;
import rikkei.academy.model.Product;

import java.util.Optional;
@Service
public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
