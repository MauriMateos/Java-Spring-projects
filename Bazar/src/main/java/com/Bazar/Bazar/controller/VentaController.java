package com.Bazar.Bazar.controller;

import com.Bazar.Bazar.DTO.ventaClienteProductoDTO;
import com.Bazar.Bazar.model.Cliente;
import com.Bazar.Bazar.model.Producto;
import com.Bazar.Bazar.model.Venta;
import com.Bazar.Bazar.service.IClienteService;
import com.Bazar.Bazar.service.IProductoService;
import com.Bazar.Bazar.service.IVentaService;
import com.Bazar.Bazar.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

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


            //new code//

    @GetMapping("/ventas/productos/{id}")
    public List<Producto> listaPorVenta(@PathVariable Long id){

        return this.getVentaById(id).getListaProductos();
    }

    @GetMapping("/ventas/fecha/{fecha_venta}")
    public ResponseEntity<Map<String, Object>> fechaVentas(@PathVariable LocalDate fecha_venta){
        int cantVentas = 0, cantTotal = 0;


    for (Venta venta: this.getVentas()){
        if (venta.getFechaVenta().equals(fecha_venta)){

            cantVentas++;
            for (Producto producto: venta.getListaProductos()){
                cantTotal += producto.getCosto();
            }


        }
    }

        Map<String, Object> response = new HashMap<>();
        response.put("cantidadVentas", cantVentas);
        response.put("valorTotalProductos", cantTotal);

        // Devolver la respuesta en formato JSON
        return ResponseEntity.ok(response);


    }

    @GetMapping("/ventas/mayor-monto")
    public ResponseEntity<ventaClienteProductoDTO> obtenerVentaMayorMonto() {
        Venta ventaMayorMonto = ventaServ.obtenerVentaMayorMonto();
        double cantTotal = 0;


        for (Producto producto: ventaMayorMonto.getListaProductos()){
            cantTotal += producto.getCosto();
        }

        ventaClienteProductoDTO ventaClienteProductoDTO = new ventaClienteProductoDTO();
        ventaClienteProductoDTO.setCodigoVenta(ventaMayorMonto.getCodigoVenta());
        ventaClienteProductoDTO.setTotal(cantTotal);
        ventaClienteProductoDTO.setCantidadProductos(ventaMayorMonto.getListaProductos().size());
        ventaClienteProductoDTO.setNombreCliente(ventaMayorMonto.getUnCliente().getNombre());
        ventaClienteProductoDTO.setApellidoCliente(ventaMayorMonto.getUnCliente().getApellido());

        return ResponseEntity.ok(ventaClienteProductoDTO);
    }

}
