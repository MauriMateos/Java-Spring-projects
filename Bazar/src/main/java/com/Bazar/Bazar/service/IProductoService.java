package com.Bazar.Bazar.service;

import com.Bazar.Bazar.model.Producto;

import java.util.List;

public interface IProductoService {

    void saveProducto(Producto producto);

    List<Producto> getProductos();

    void deleteProductoById(Long id);

    Producto findProductoById(Long id);

    void editProducto(Producto producto);

}
