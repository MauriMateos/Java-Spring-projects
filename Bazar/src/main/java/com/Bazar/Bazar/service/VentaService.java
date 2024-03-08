package com.Bazar.Bazar.service;

import com.Bazar.Bazar.model.Venta;
import com.Bazar.Bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
