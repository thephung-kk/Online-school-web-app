package com.phungnt.schoolwebapplication.repository;

import com.phungnt.schoolwebapplication.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String>  {


}
