package com.Bazar.Bazar.service;



import com.Bazar.Bazar.model.Venta;

import java.util.List;

public interface IVentaService {

    void saveVenta(Venta venta);

    List<Venta> getVentas();

    void deleteVentaById(Long id);

    Venta findVentaById(Long id);

    void editVenta(Venta Venta);

}
