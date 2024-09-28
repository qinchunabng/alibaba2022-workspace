package com.qin.service;

import com.qin.bean.Depart;
import com.qin.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DepartServiceImpl implements DepartService{

    @Autowired
    private DepartRepository departRepository;

    @Override
    public boolean saveDepart(Depart depart) {
        Depart obj = departRepository.save(depart);
        if(obj != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDepartById(int id) {
        if(departRepository.existsById(id)) {
            departRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        Depart obj = departRepository.save(depart);
        return obj != null;
    }

    @Override
    public Depart getDepartById(int id) {
        return departRepository.getReferenceById(id);
    }

    @Override
    public List<Depart> listAllDeparts() {
        return departRepository.findAll();
    }
}
