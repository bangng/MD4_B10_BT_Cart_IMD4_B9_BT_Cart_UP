package rikkei.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.academy.model.Product;
import rikkei.academy.repository.IProductRepository;

import java.util.Optional;
@Service
public class ProductServiceIMPL implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
