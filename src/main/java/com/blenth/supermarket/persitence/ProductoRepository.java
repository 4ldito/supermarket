package com.blenth.supermarket.persitence;

import com.blenth.supermarket.domain.Product;
import com.blenth.supermarket.domain.repository.ProductRepository;
import com.blenth.supermarket.persitence.crud.ProductoCrudRepository;
import com.blenth.supermarket.persitence.entity.Producto;
import com.blenth.supermarket.persitence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// con esto le indicamos a Spring que esta clase se encarga de interactuar con la base de datos
@Repository()
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    // consigue todos los productos
    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    // encuentra 1 producto según la id
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));
    }

    // encuentra productos según la categoria
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    // encunetra los productos escasos
    public Optional<List<Product>> getScarseProduct(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    // encuentra los productos con menor precio,
    // NO deberia llamarse menor precio porque trae más de 1 producto según X precio
    @Override
    public Optional<List<Product>> getLessPrice(double precio) {
        Optional<List<Producto>> productos = productoCrudRepository.findByPrecioVentaLessThanAndEstado(precio, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }



}
