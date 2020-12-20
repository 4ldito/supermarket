package com.blenth.supermarket.persitence.crud;

import com.blenth.supermarket.persitence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
    Optional<List<Producto>> findByPrecioVentaLessThanAndEstado(double precioVenta, boolean estado);
}
