package com.example.demo.DAO;

import com.example.demo.Entity.Information;
import com.example.demo.Repository.InformationRepository;

public class InformationDAO {

    private final InformationRepository _InformationRepository;

    public InformationDAO(InformationRepository informationRepository) {
        _InformationRepository = informationRepository;
    }


    public Information getInformation(){
        return  _InformationRepository.getInformationById();
    }


}
