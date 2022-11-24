package com.upc.controller;

import java.util.List;

import com.upc.model.Respuesta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.upc.exeption.ProductoNotfoundException;
import com.upc.model.Producto;
import com.upc.service.ProductoService;

@RestController
public class ProductoServiceController {

    @Autowired
    private ProductoService productoService;

    @RequestMapping(value = "/productos", method = RequestMethod.POST)
    public ResponseEntity<Respuesta> createProducto(@RequestBody Producto producto)
    {
        producto = productoService.createProducto(producto);
        Respuesta res = new Respuesta();
        res.setMensaje("Producto is created successfully with CProducto = " +producto.getCProducto());
        return ResponseEntity.ok(res);
        //return new ResponseEntity<>("Producto is created successfully with CProducto = " +producto.getCProducto(), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/productos/{CProducto}", method = RequestMethod.PUT)
    public ResponseEntity<Respuesta> updateProducto(@PathVariable("CProducto") int CProducto,
                                                 @RequestBody Producto producto)
    {
        boolean isProductoExist = productoService.isProductoExist(CProducto);
        if (isProductoExist)
        {

            producto.setCProducto(CProducto);
            productoService.updateProducto(producto);
            Respuesta res = new Respuesta();
            res.setMensaje("Producto is updated successsfully");
            //return new ResponseEntity<>("Producto is updated successsfully", HttpStatus.OK);
            return ResponseEntity.ok(res);
        }
        else
        {
            throw new ProductoNotfoundException();
        }

    }

    @RequestMapping(value = "/productos/{CProducto}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProducto(@PathVariable("CProducto") int CProducto)
    {
        boolean isProductoExist = productoService.isProductoExist(CProducto);
        if (isProductoExist)
        {
            Producto producto = productoService.getProducto(CProducto);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        }
        else
        {
            throw new ProductoNotfoundException();
        }

    }

    @Operation(summary = "Get a .... CProducto")

    @ApiResponses(value = {

            @ApiResponse(responseCode = "200", description = "Found the book",

                    content = { @Content(mediaType = "application/json",

                            schema = @Schema(implementation = Producto.class)) }),

            @ApiResponse(responseCode = "400", description = "Invalid CProducto ",

                    content = @Content),

            @ApiResponse(responseCode = "404", description = "Producto not found",

                    content = @Content) })

    @RequestMapping(value = "/productos", method = RequestMethod.GET)
    public ResponseEntity<Object> getProductos()
    {
        List<Producto> productoList = productoService.getProductos();
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/productos/{CProducto}", method = RequestMethod.DELETE)
    public ResponseEntity<Respuesta> deleteProducto(@PathVariable("CProducto") int CProducto)
    {
        boolean isProductoExist = productoService.isProductoExist(CProducto);
        if (isProductoExist)
        {
            productoService.deleteProducto(CProducto);
            Respuesta res = new Respuesta();
            res.setMensaje("Producto is deleted successsfully");
            return ResponseEntity.ok(res);
            //return new ResponseEntity<>("Producto is deleted successsfully", HttpStatus.OK);
        }
        else
        {
            throw new ProductoNotfoundException();
        }

    }
}
