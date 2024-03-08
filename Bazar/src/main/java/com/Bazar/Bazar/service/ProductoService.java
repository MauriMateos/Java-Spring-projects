package com.Bazar.Bazar.service;

import com.Bazar.Bazar.model.Producto;
import com.Bazar.Bazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository prodRepo;

    @Override
    public void saveProducto(Producto producto) {
        prodRepo.save(producto);
    }

    @Override
    public List<Producto> getProductos() {
        return prodRepo.findAll();
    }

    @Override
    public void deleteProductoById(Long id) {
        prodRepo.deleteById(id);
    }

    @Override
    public Producto findProductoById(Long id) {
        return prodRepo.findById(id).orElse(null);
    }

    @Override
    public void editProducto(Producto producto) {
        this.saveProducto(producto);
    }
}
