package com.example.demo.Repository;

import com.example.demo.Entity.Information;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface InformationRepository extends CrudRepository<Information, Integer> {

    @Query(value =  "SELECT * FROM assignment2.information where InformationId =:id", nativeQuery = true)
    public  Information getInformationById(@Param("id")int id);
}
