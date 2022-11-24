package com.upc.controller;

import java.util.List;

import com.upc.exeption.UsuarioNotfoundException;
import com.upc.model.Respuesta;
import com.upc.model.Usuario;
import com.upc.service.UsuarioService;
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
public class UsuarioServiceController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public ResponseEntity<Respuesta> createUsuario(@RequestBody Usuario usuario)
    {
        usuario = usuarioService.createUsuario(usuario);
        Respuesta res = new Respuesta();
        res.setMensaje("Usuario is created successfully with CUsuario = " +usuario.getCUsuario());
        return ResponseEntity.ok(res);
        //return new ResponseEntity<>("Usuario is created successfully with CUsuario = " +usuario.getCUsuario(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/usuarios/{CUsuario}", method = RequestMethod.PUT)
    public ResponseEntity<Respuesta> updateUsuario(@PathVariable("CUsuario") int CUsuario,
                                                 @RequestBody Usuario usuario)
    {
        boolean isUsuarioExist = usuarioService.isUsuarioExist(CUsuario);
        if (isUsuarioExist)
        {

            usuario.setCUsuario(CUsuario);
            usuarioService.updateUsuario(usuario);
            Respuesta res = new Respuesta();
            res.setMensaje("Usuario is updated successsfully");
            //return new ResponseEntity<Respuesta>(res,HttpStatus.OK);
            return ResponseEntity.ok(res);
        }
        else
        {
            throw new UsuarioNotfoundException();
        }

    }

    @RequestMapping(value = "/usuarios/{CUsuario}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUsuario(@PathVariable("CUsuario") int CUsuario)
    {
        boolean isUsuarioExist = usuarioService.isUsuarioExist(CUsuario);
        if (isUsuarioExist)
        {
            Usuario usuario = usuarioService.getUsuario(CUsuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        else
        {
            throw new UsuarioNotfoundException();
        }

    }

    @Operation(summary = "Get a .... CUsuario")

    @ApiResponses(value = {

            @ApiResponse(responseCode = "200", description = "Found the book",

                    content = { @Content(mediaType = "application/json",

                            schema = @Schema(implementation = Usuario.class)) }),

            @ApiResponse(responseCode = "400", description = "InvalCUsuario CUsuario ",

                    content = @Content),

            @ApiResponse(responseCode = "404", description = "Usuario not found",

                    content = @Content) })

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ResponseEntity<Object> getUsuarios()
    {
        List<Usuario> usuarioList = usuarioService.getUsuarios();
        return new ResponseEntity<>(usuarioList, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuarios/{CUsuario}", method = RequestMethod.DELETE)
    public ResponseEntity<Respuesta> deleteUsuario(@PathVariable("CUsuario") int CUsuario)
    {
        boolean isUsuarioExist = usuarioService.isUsuarioExist(CUsuario);
        if (isUsuarioExist)
        {
            usuarioService.deleteUsuario(CUsuario);
            Respuesta res = new Respuesta();
            res.setMensaje("Usuario is deleted successsfully");
            return ResponseEntity.ok(res);
            //return new ResponseEntity<>("Usuario is deleted successsfully", HttpStatus.OK);
        }
        else
        {
            throw new UsuarioNotfoundException();
        }

    }
}
