package com.example.demo.DAO;

import com.example.demo.Entity.Information;
import com.example.demo.Repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationDAO {
    private final InformationRepository _InformationRepository;

    @Autowired
    public InformationDAO(InformationRepository informationRepository) {
        _InformationRepository = informationRepository;
    }

    public Information getInformationById(int id){
        return _InformationRepository.getInformationById(id);
    }

}
