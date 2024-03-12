package com.Bazar.Bazar.controller;

import com.Bazar.Bazar.model.Cliente;
import com.Bazar.Bazar.model.Venta;
import com.Bazar.Bazar.service.IClienteService;
import com.Bazar.Bazar.service.IProductoService;
import com.Bazar.Bazar.service.IVentaService;
import com.Bazar.Bazar.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {
    @Autowired
    private IVentaService ventaServ;
    @Autowired
    private IClienteService clienteServ;
    @Autowired
    private IProductoService productoServ;



    @PostMapping("/ventas/crear")
    public String createVenta(@RequestBody Venta venta){

        Cliente clienteExistente = clienteServ.findClienteById(venta.getUnCliente().getIdCliente());

        if (clienteExistente != null) {
            // El cliente ya existe, asociarlo a la venta
            venta.setUnCliente(clienteExistente);
        } else {
            // El cliente no existe, guardar el cliente y asociarlo a la venta
            clienteServ.saveCliente(venta.getUnCliente());
        }

        ventaServ.saveVenta(venta);
        return "venta creada correctamente";
    }

//    @PostMapping("/ventas/crear")
//    public String createVenta(@RequestBody Venta venta){
//        Venta ventaa = new Venta();
//
//    }

    @GetMapping("/ventas")
    public List<Venta> getVentas(){
        return ventaServ.getVentas();
    }

    @GetMapping("/ventas/{id}")
    public Venta getVentaById(@PathVariable Long id){
        return ventaServ.findVentaById(id);
    }

    @PutMapping("/ventas/edit")
    public String editVenta(@RequestBody Venta venta){
        ventaServ.editVenta(venta);
        return "venta editada correctamente";
    }

    @DeleteMapping("/ventas/delete/{id}")
    public String deleteVenta(@PathVariable Long id){
        ventaServ.deleteVentaById(id);
        return "venta eliminada correctamente";
    }

}
