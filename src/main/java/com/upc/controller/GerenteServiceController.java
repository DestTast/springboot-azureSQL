package com.upc.controller;

import com.upc.exeption.GerenteNotfoundException;
import com.upc.model.Gerente;
import com.upc.service.GerenteService;
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
public class GerenteServiceController {

    @Autowired
    private GerenteService gerenteService;

    @RequestMapping(value = "/gerentes", method = RequestMethod.POST)
    public ResponseEntity<Object> createGerente(@RequestBody Gerente gerente)
    {
        gerente = gerenteService.createGerente(gerente);
        return new ResponseEntity<>("Gerente is created successfully with CGerente = " +gerente.getCGerente(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/gerentes/{CGerente}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateGerente(@PathVariable("CGerente") int CGerente,
                                                 @RequestBody Gerente gerente)
    {
        boolean isGerenteExist = gerenteService.isGerenteExist(CGerente);
        if (isGerenteExist)
        {
            
            gerente.setCGerente(CGerente);
            gerenteService.updateGerente(gerente);
            return new ResponseEntity<>("Gerente is updated successsfully", HttpStatus.OK);
        }
        else
        {
            throw new GerenteNotfoundException();
        }

    }

    @RequestMapping(value = "/gerentes/{CGerente}", method = RequestMethod.GET)
    public ResponseEntity<Object> getGerente(@PathVariable("CGerente") int CGerente)
    {
        boolean isGerenteExist = gerenteService.isGerenteExist(CGerente);
        if (isGerenteExist)
        {
            Gerente gerente = gerenteService.getGerente(CGerente);
            return new ResponseEntity<>(gerente, HttpStatus.OK);
        }
        else
        {
            throw new GerenteNotfoundException();
        }

    }

    @Operation(summary = "Get a .... CGerente")

    @ApiResponses(value = {

            @ApiResponse(responseCode = "200", description = "Found the book",

                    content = { @Content(mediaType = "application/json",

                            schema = @Schema(implementation = Gerente.class)) }),

            @ApiResponse(responseCode = "400", description = "InvalCGerente CGerente ",

                    content = @Content),

            @ApiResponse(responseCode = "404", description = "Gerente not found",

                    content = @Content) })

    @RequestMapping(value = "/gerentes", method = RequestMethod.GET)
    public ResponseEntity<Object> getGerentes()
    {
        List<Gerente> gerenteList = gerenteService.getGerentes();
        return new ResponseEntity<>(gerenteList, HttpStatus.OK);
    }

    @RequestMapping(value = "/gerentes/{CGerente}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteGerente(@PathVariable("CGerente") int CGerente)
    {
        boolean isGerenteExist = gerenteService.isGerenteExist(CGerente);
        if (isGerenteExist)
        {
            gerenteService.deleteGerente(CGerente);
            return new ResponseEntity<>("Gerente is deleted successsfully", HttpStatus.OK);
        }
        else
        {
            throw new GerenteNotfoundException();
        }

    }
}
