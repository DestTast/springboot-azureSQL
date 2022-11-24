package com.upc.controller;

import java.util.List;

import com.upc.exeption.VentasNotfoundException;
import com.upc.model.Respuesta;
import com.upc.model.Ventas;
import com.upc.service.VentasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.upc.exeption.VentasNotfoundException;
import com.upc.model.Ventas;
import com.upc.service.VentasService;



@RestController
public class VentasServiceController {

    @Autowired
    private VentasService ventasService;

    @RequestMapping(value = "/ventass", method = RequestMethod.POST)
    public ResponseEntity<Respuesta> createVentas(@RequestBody Ventas ventas)
    {
        ventas = ventasService.createVentas(ventas);
        Respuesta res = new Respuesta();
        res.setMensaje("Ventas is created successfully with CVenta = " +ventas.getCVenta());
        return ResponseEntity.ok(res);
        //return new ResponseEntity<>("Ventas is created successfully with CVenta = " +ventas.getCVenta(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/ventass/{CVenta}", method = RequestMethod.PUT)
    public ResponseEntity<Respuesta> updateVentas(@PathVariable("CVenta") int CVenta,
                                                 @RequestBody Ventas ventas)
    {
        boolean isVentasExist = ventasService.isVentasExist(CVenta);
        if (isVentasExist)
        {

            ventas.setCVenta(CVenta);
            ventasService.updateVentas(ventas);
            Respuesta res = new Respuesta();
            res.setMensaje("Ventas is updated successsfully");
            //return new ResponseEntity<>("Ventas is updated successsfully", HttpStatus.OK);
            return ResponseEntity.ok(res);
        }
        else
        {
            throw new VentasNotfoundException();
        }

    }

    @RequestMapping(value = "/ventass/{CVenta}", method = RequestMethod.GET)
    public ResponseEntity<Object> getVentas(@PathVariable("CVenta") int CVenta)
    {
        boolean isVentasExist = ventasService.isVentasExist(CVenta);
        if (isVentasExist)
        {
            Ventas ventas = ventasService.getVentas(CVenta);
            return new ResponseEntity<>(ventas, HttpStatus.OK);
        }
        else
        {
            throw new VentasNotfoundException();
        }

    }

    @Operation(summary = "Get a .... CVenta")

    @ApiResponses(value = {

            @ApiResponse(responseCode = "200", description = "Found the book",

                    content = { @Content(mediaType = "application/json",

                            schema = @Schema(implementation = Ventas.class)) }),

            @ApiResponse(responseCode = "400", description = "InvalCVenta CVenta ",

                    content = @Content),

            @ApiResponse(responseCode = "404", description = "Ventas not found",

                    content = @Content) })

    @RequestMapping(value = "/ventass", method = RequestMethod.GET)
    public ResponseEntity<Object> getVentass()
    {
        List<Ventas> ventasList = ventasService.getVentass();
        return new ResponseEntity<>(ventasList, HttpStatus.OK);
    }

    @RequestMapping(value = "/ventass/{CVenta}", method = RequestMethod.DELETE)
    public ResponseEntity<Respuesta> deleteVentas(@PathVariable("CVenta") int CVenta)
    {
        boolean isVentasExist = ventasService.isVentasExist(CVenta);
        if (isVentasExist)
        {
            ventasService.deleteVentas(CVenta);
            Respuesta res = new Respuesta();
            res.setMensaje("Ventas is deleted successsfully");
            return ResponseEntity.ok(res);
            //return new ResponseEntity<>("Ventas is deleted successsfully", HttpStatus.OK);
        }
        else
        {
            throw new VentasNotfoundException();
        }

    }
}
