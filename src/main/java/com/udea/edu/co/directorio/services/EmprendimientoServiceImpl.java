package com.udea.edu.co.directorio.services;


import com.udea.edu.co.directorio.entities.Emprendimiento;
import com.udea.edu.co.directorio.repositories.EmprendedorRepository;
import com.udea.edu.co.directorio.repositories.EmprendimientoRepository;
import com.udea.edu.co.directorio.request.CreateEmprendimientoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmprendimientoServiceImpl implements EmprendimientoService{

    @Autowired
    private  EmprendimientoRepository emprendimientoRepository;

    @Autowired
    private EmprendedorRepository emprendedorRepository;

    @Override
    public Emprendimiento createEmeprendimiento(CreateEmprendimientoRequest req) {
        Emprendimiento emprendimiento = new Emprendimiento();
        emprendimiento.setNombre(req.getNombre());
        emprendimiento.setResumen(req.getResumen());
        emprendimiento.setFormalizada(req.isFormalizada());
        emprendimiento.setNombreLogo(req.getNombreLogo());
        emprendimiento.setDescripcion(req.getDescripcion());
        emprendimiento.setEtapa(req.getEtapa());
        emprendimiento.setFundadores(req.getFundadores());
        emprendimiento.setInformacionDeContacto(req.getInformacionDeContacto());
        emprendimiento.setSectores(req.getSectores());
        emprendimiento.setServicios(req.getServicios());
        emprendimiento.setFechaRegistro(LocalDateTime.now());
        return emprendimientoRepository.save(emprendimiento);
    }

    @Override
    public Emprendimiento updateEmprendimiento(Long emprendimientoId, CreateEmprendimientoRequest updatedEmprendimientoRequest) throws Exception {
        Emprendimiento emprendimiento = findEmprendimientoById(emprendimientoId);

        if(emprendimiento.getDescripcion()!=null){
            emprendimiento.setDescripcion(updatedEmprendimientoRequest.getDescripcion());
        }

        if (emprendimiento.getInformacionDeContacto()!=null){
            emprendimiento.setInformacionDeContacto(updatedEmprendimientoRequest.getInformacionDeContacto());
        }

        if (emprendimiento.getEtapa()!=null){
            emprendimiento.setEtapa(updatedEmprendimientoRequest.getEtapa());
        }

        return emprendimientoRepository.save(emprendimiento);
    }

    @Override
    public void deleteEmprendimiento(Long emprendimientoId) throws Exception {

        Emprendimiento emprendimiento = findEmprendimientoById(emprendimientoId);

        emprendimientoRepository.delete(emprendimiento);
    }

    @Override
    public List<Emprendimiento> getAllEmprendimientos() {
        return emprendimientoRepository.findAll();
    }

    @Override
    public List<Emprendimiento> searchEmprendimiento(String keyword) {
        return emprendimientoRepository.findBySearchQuery(keyword);
    }

    @Override
    public Emprendimiento findEmprendimientoById(Long emprendimientoId) throws Exception {
        Optional<Emprendimiento> opt=emprendimientoRepository.findById(emprendimientoId);
        if(opt.isEmpty()){
            throw new Exception("No se ha encontrado el emprendimiento con el id: "+emprendimientoId);
        }
        return opt.get();
    }

    @Override
    public Emprendimiento getEmprendimientoByEmprendedor(Long fundadorId) throws Exception {
        Emprendimiento emprendimiento = emprendimientoRepository.findByFundadoresId(fundadorId);
        if (emprendimiento==null){
            throw new Exception("No se ha encontrado el emprendimiento con el id del fundador: "+fundadorId);
        }
        return emprendimiento;
    }

    @Override
    public Emprendimiento updateEmprendimientoFormalizacion(Long id) throws Exception {
        Emprendimiento emprendimiento = findEmprendimientoById(id);
        emprendimiento.setFormalizada(!emprendimiento.isFormalizada());
        return emprendimientoRepository.save(emprendimiento);
    }
}