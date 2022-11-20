package com.upc.service;

import com.upc.model.Empleado;

import java.util.List;

public interface EmpleadoService {

    public abstract Empleado createEmpleado(Empleado empleado);

    public abstract void updateEmpleado(Empleado empleado);

    public abstract Empleado getEmpleado(int CEmpleado);

    public abstract List<Empleado> getEmpleados();

    public abstract void deleteEmpleado(int CEmpleado);

    public abstract boolean isEmpleadoExist(int CEmpleado);
}
