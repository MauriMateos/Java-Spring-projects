package com.Bazar.Bazar.controller;

import com.Bazar.Bazar.model.Venta;
import com.Bazar.Bazar.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VentaController {
    @Autowired
    private VentaService ventaServ;

    @PostMapping("/ventas/crear")
    public String createVenta(@RequestBody Venta venta){
        ventaServ.saveVenta(venta);
        return "venta creada correctamente";
    }

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
