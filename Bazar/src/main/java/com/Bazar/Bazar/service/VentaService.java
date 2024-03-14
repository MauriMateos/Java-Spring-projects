package com.Bazar.Bazar.service;

import com.Bazar.Bazar.model.Producto;
import com.Bazar.Bazar.model.Venta;
import com.Bazar.Bazar.repository.IProductoRepository;
import com.Bazar.Bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepo;


    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public void deleteVentaById(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public Venta findVentaById(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);
    }


//    @Override
//    public Venta obtenerVentaMayorMonto() {
//        int masAlto=0;
//
//        ArrayList<Venta> lista = (ArrayList<Venta>) this.getVentas();
//
//
//
//        ArrayList<Producto> productos = new ArrayList<>();
//        for (Producto prod: lista){
//            productos = prod.getListaProductos());
//        }
//
////        for (Venta venta:this.getVentas()){
////            if(masAlto<venta.getListaProductos().)
////        }
//
//        return null;
//    }
@Override
public Venta obtenerVentaMayorMonto() {
    double montoMasAlto = 0;
    Venta ventaMasAlta = null;

    // Obtener todas las ventas
    List<Venta> ventas = getVentas();

    // Iterar sobre cada venta
    for (Venta venta : ventas) {
        double montoVenta = 0;

        // Calcular el monto total de la venta sumando el costo de todos los productos
        for (Producto producto : venta.getListaProductos()) {
            montoVenta += producto.getCosto();
        }

        // Verificar si el monto de esta venta es mayor al monto más alto encontrado hasta ahora
        if (montoVenta > montoMasAlto) {
            montoMasAlto = montoVenta;
            ventaMasAlta = venta;
        }
    }

    return ventaMasAlta;
}

    public double calcularTotal(Venta venta) {
        double total = 0;

        // Iterar sobre los productos de la venta y sumar sus costos
        for (Producto producto : venta.getListaProductos()) {
            total += producto.getCosto();
        }

        return total;
    }

}
