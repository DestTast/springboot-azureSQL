package com.upc.controller;

import java.util.List;

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

import com.upc.exeption.EmpleadoNotfoundException;
import com.upc.model.Empleado;
import com.upc.service.EmpleadoService;

@RestController
public class EmpleadoServiceController {


    @Autowired
    private EmpleadoService empleadoService;

    @RequestMapping(value = "/empleados", method = RequestMethod.POST)
    public ResponseEntity<Object> createEmpleado(@RequestBody Empleado empleado)
    {
        empleado = empleadoService.createEmpleado(empleado);
        return new ResponseEntity<>("Empleado is created successfully with CEmpleado = " +empleado.getCEmpleado(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/empleados/{CEmpleado}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateEmpleado(@PathVariable("CEmpleado") int CEmpleado,
                                                 @RequestBody Empleado empleado)
    {
        boolean isEmpleadoExist = empleadoService.isEmpleadoExist(CEmpleado);
        if (isEmpleadoExist)
        {
            empleado.setCEmpleado(CEmpleado);
            empleadoService.updateEmpleado(empleado);
            return new ResponseEntity<>("Empleado is updated successsfully", HttpStatus.OK);
        }
        else
        {
            throw new EmpleadoNotfoundException();
        }

    }

    @RequestMapping(value = "/empleados/{CEmpleado}", method = RequestMethod.GET)
    public ResponseEntity<Object> getEmpleado(@PathVariable("CEmpleado") int CEmpleado)
    {
        boolean isEmpleadoExist = empleadoService.isEmpleadoExist(CEmpleado);
        if (isEmpleadoExist)
        {
            Empleado empleado = empleadoService.getEmpleado(CEmpleado);
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        }
        else
        {
            throw new EmpleadoNotfoundException();
        }

    }

    @Operation(summary = "Get a .... CEmpleado")

    @ApiResponses(value = {

            @ApiResponse(responseCode = "200", description = "Found the book",

                    content = { @Content(mediaType = "application/json",

                            schema = @Schema(implementation = Empleado.class)) }),

            @ApiResponse(responseCode = "400", description = "Invalid CEmpleado ",

                    content = @Content),

            @ApiResponse(responseCode = "404", description = "Empleado not found",

                    content = @Content) })

    @RequestMapping(value = "/empleados", method = RequestMethod.GET)
    public ResponseEntity<Object> getEmpleados()
    {
        List<Empleado> empleadoList = empleadoService.getEmpleados();
        return new ResponseEntity<>(empleadoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/empleados/{CEmpleado}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEmpleado(@PathVariable("CEmpleado") int CEmpleado)
    {
        boolean isEmpleadoExist = empleadoService.isEmpleadoExist(CEmpleado);
        if (isEmpleadoExist)
        {
            empleadoService.deleteEmpleado(CEmpleado);
            return new ResponseEntity<>("Empleado is deleted successsfully", HttpStatus.OK);
        }
        else
        {
            throw new EmpleadoNotfoundException();
        }

    }
}
