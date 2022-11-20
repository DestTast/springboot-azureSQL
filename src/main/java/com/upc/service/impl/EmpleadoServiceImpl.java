package com.upc.service.impl;


import com.upc.model.Empleado;
import com.upc.repository.EmpleadoRepository;
import com.upc.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
    @Autowired//Notación correspondiente
    private EmpleadoRepository empleadoRepository;
    @Override
    public Empleado createEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void updateEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public Empleado getEmpleado(int CEmpleado) {
        Optional<Empleado> optional = empleadoRepository.findById(CEmpleado);
        Empleado empleado = optional.get();
        return empleado;
    }

    @Override
    public List<Empleado> getEmpleados() {
        return (List<Empleado>)empleadoRepository.findAll();
    }

    @Override
    public void deleteEmpleado(int CEmpleado) {
        empleadoRepository.deleteById(CEmpleado);
    }

    @Override
    public boolean isEmpleadoExist(int CEmpleado) {
        return empleadoRepository.existsById(CEmpleado);
    }
}
