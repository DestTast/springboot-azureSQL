package com.upc.controller;

import com.upc.exeption.Venta_ProductoNotfoundException;
import com.upc.model.Respuesta;
import com.upc.model.Venta_Producto;
import com.upc.service.Venta_ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;





@RestController
public class Venta_ProductoServiceController {

    @Autowired
    private Venta_ProductoService venta_productoService;

    @RequestMapping(value = "/venta_productos", method = RequestMethod.POST)
    public ResponseEntity<Object> createVenta_Producto(@RequestBody Venta_Producto venta_producto)
    {
        venta_producto = venta_productoService.createVenta_Producto(venta_producto);
        //Respuesta res = new Respuesta();
        //res.setMensaje("Venta_Producto is created successfully with CVenta_Producto = " +venta_producto.getCVenta_Producto());
        //return ResponseEntity.ok(res);
        return new ResponseEntity<>("Venta_Producto is created successfully with CVenta_Producto = " +venta_producto.getCVenta_Producto(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/venta_productos/{CVenta_Producto}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateVenta_Producto(@PathVariable("CVenta_Producto") int CVenta_Producto,
                                                 @RequestBody Venta_Producto venta_producto)
    {
        boolean isVenta_ProductoExist = venta_productoService.isVenta_ProductoExist(CVenta_Producto);
        if (isVenta_ProductoExist)
        {
            
            venta_producto.setCVenta_Producto(CVenta_Producto);
            venta_productoService.updateVenta_Producto(venta_producto);
            //Respuesta res = new Respuesta();
            //res.setMensaje("Venta_Producto is updated successsfully");
            return new ResponseEntity<>("Venta_Producto is updated successsfully", HttpStatus.OK);
            //return ResponseEntity.ok(res);
        }
        else
        {
            throw new Venta_ProductoNotfoundException();
        }

    }

    @RequestMapping(value = "/venta_productos/{CVenta_Producto}", method = RequestMethod.GET)
    public ResponseEntity<Object> getVenta_Producto(@PathVariable("CVenta_Producto") int CVenta_Producto)
    {
        boolean isVenta_ProductoExist = venta_productoService.isVenta_ProductoExist(CVenta_Producto);
        if (isVenta_ProductoExist)
        {
            Venta_Producto venta_producto = venta_productoService.getVenta_Producto(CVenta_Producto);
            return new ResponseEntity<>(venta_producto, HttpStatus.OK);
        }
        else
        {
            throw new Venta_ProductoNotfoundException();
        }

    }

    @Operation(summary = "Get a .... CVenta_Producto")

    @ApiResponses(value = {

            @ApiResponse(responseCode = "200", description = "Found the book",

                    content = { @Content(mediaType = "application/json",

                            schema = @Schema(implementation = Venta_Producto.class)) }),

            @ApiResponse(responseCode = "400", description = "InvalCVenta_Producto CVenta_Producto ",

                    content = @Content),

            @ApiResponse(responseCode = "404", description = "Venta_Producto not found",

                    content = @Content) })

    @RequestMapping(value = "/venta_productos", method = RequestMethod.GET)
    public ResponseEntity<Object> getVenta_Productos()
    {
        List<Venta_Producto> venta_productoList = venta_productoService.getVenta_Productos();
        return new ResponseEntity<>(venta_productoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/venta_productos/{CVenta_Producto}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteVenta_Producto(@PathVariable("CVenta_Producto") int CVenta_Producto)
    {
        boolean isVenta_ProductoExist = venta_productoService.isVenta_ProductoExist(CVenta_Producto);
        if (isVenta_ProductoExist)
        {
            venta_productoService.deleteVenta_Producto(CVenta_Producto);
            //Respuesta res = new Respuesta();
            //res.setMensaje("Venta_Producto is deleted successsfully");
            //return ResponseEntity.ok(res);
            return new ResponseEntity<>("Venta_Producto is deleted successsfully", HttpStatus.OK);
        }
        else
        {
            throw new Venta_ProductoNotfoundException();
        }

    }
}
