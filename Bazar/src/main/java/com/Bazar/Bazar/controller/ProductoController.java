package com.Bazar.Bazar.controller;

import com.Bazar.Bazar.model.Producto;
import com.Bazar.Bazar.service.IProductoService;
import com.Bazar.Bazar.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoServ;

    @PostMapping("/productos/crear")
    public String createProducto(@RequestBody Producto producto){

        productoServ.saveProducto(producto);

        return "producto creado correctamente";
    }

    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return productoServ.getProductos();
    }

    @GetMapping("/productos/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoServ.findProductoById(id);
    }

    @DeleteMapping("/productos/delete/{id}")
    public String deleteProductoById(@PathVariable Long id){
        productoServ.deleteProductoById(id);
        return "producto eliminado correctamente";
    }

    @PutMapping("/productos/edit")
    public String editProducto(@RequestBody Producto producto){
        productoServ.editProducto(producto);
        return "producto editado correctamente";
    }
            // new code//

    @GetMapping("/productos/falta_stock")
    public List<Producto> faltaStock(){
        ArrayList<Producto> productosBajos = new ArrayList<>();

        for (Producto prod : this.getProductos()){
            if (prod.getCantidadDisponible() < 5 ){
            productosBajos.add(prod);
            }
        }

        return productosBajos;
    }


}
