package com.upc.controller;

import java.util.List;

import com.upc.exeption.Tipo_ProductoNotfoundException;
import com.upc.model.Respuesta;
import com.upc.model.Tipo_Producto;
import com.upc.service.Tipo_ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;





@RestController
public class Tipo_ProductoServiceController {

    @Autowired
    private Tipo_ProductoService Tipo_ProductoService;

    @RequestMapping(value = "/Tipo_Productos", method = RequestMethod.POST)
    public ResponseEntity<Respuesta> createTipo_Producto(@RequestBody Tipo_Producto Tipo_Producto)
    {
        Tipo_Producto = Tipo_ProductoService.createTipo_Producto(Tipo_Producto);
        Respuesta res = new Respuesta();
        res.setMensaje("Tipo_Producto is created successfully with CTipo_Producto = " +Tipo_Producto.getCTipo_Producto());
        return ResponseEntity.ok(res);
        //return new ResponseEntity<>("Tipo_Producto is created successfully with CTipo_Producto = " +Tipo_Producto.getCTipo_Producto()", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/Tipo_Productos/{CTipo_Producto}", method = RequestMethod.PUT)
    public ResponseEntity<Respuesta> updateTipo_Producto(@PathVariable("CTipo_Producto") Integer CTipo_Producto,
                                                 @RequestBody Tipo_Producto Tipo_Producto)
    {
        boolean isTipo_ProductoExist = Tipo_ProductoService.isTipo_ProductoExist(CTipo_Producto);
        if (isTipo_ProductoExist)
        {

            Tipo_Producto.setCTipo_Producto(CTipo_Producto);
            Tipo_ProductoService.updateTipo_Producto(Tipo_Producto);
            Respuesta res = new Respuesta();
            res.setMensaje("Tipo_Producto is updated successsfully");
            return ResponseEntity.ok(res);
            //return new ResponseEntity<>("Tipo_Producto is updated successsfully", HttpStatus.OK);
        }
        else
        {
            throw new Tipo_ProductoNotfoundException();
        }

    }

    @RequestMapping(value = "/Tipo_Productos/{CTipo_Producto}", method = RequestMethod.GET)
    public ResponseEntity<Object> getTipo_Producto(@PathVariable("CTipo_Producto") Integer CTipo_Producto)
    {
        boolean isTipo_ProductoExist = Tipo_ProductoService.isTipo_ProductoExist(CTipo_Producto);
        if (isTipo_ProductoExist)
        {
            Tipo_Producto Tipo_Producto = Tipo_ProductoService.getTipo_Producto(CTipo_Producto);
            return new ResponseEntity<>(Tipo_Producto, HttpStatus.OK);
        }
        else
        {
            throw new Tipo_ProductoNotfoundException();
        }

    }

    @Operation(summary = "Get a .... CTipo_Producto")

    @ApiResponses(value = {

            @ApiResponse(responseCode = "200", description = "Found the book",

                    content = { @Content(mediaType = "application/json",

                            schema = @Schema(implementation = Tipo_Producto.class)) }),

            @ApiResponse(responseCode = "400", description = "InvalCTipo_Producto CTipo_Producto ",

                    content = @Content),

            @ApiResponse(responseCode = "404", description = "Tipo_Producto not found",

                    content = @Content) })

    @RequestMapping(value = "/Tipo_Productos", method = RequestMethod.GET)
    public ResponseEntity<Object> getTipo_Productos()
    {
        List<Tipo_Producto> Tipo_ProductoList = Tipo_ProductoService.getTipo_Productos();
        return new ResponseEntity<>(Tipo_ProductoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/Tipo_Productos/{CTipo_Producto}", method = RequestMethod.DELETE)
    public ResponseEntity<Respuesta> deleteTipo_Producto(@PathVariable("CTipo_Producto") Integer CTipo_Producto)
    {
        boolean isTipo_ProductoExist = Tipo_ProductoService.isTipo_ProductoExist(CTipo_Producto);
        if (isTipo_ProductoExist)
        {
            Tipo_ProductoService.deleteTipo_Producto(CTipo_Producto);
            Respuesta res = new Respuesta();
            res.setMensaje("Tipo_Producto is deleted successsfully");
            return ResponseEntity.ok(res);
            //return new ResponseEntity<>("Tipo_Producto is deleted successsfully", HttpStatus.OK);
        }
        else
        {
            throw new Tipo_ProductoNotfoundException();
        }

    }
}
