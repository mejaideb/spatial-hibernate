package com.example.poc.poc.repository;

import com.example.poc.poc.entity.Address;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Address, Long> {

    @Query(value = "SELECT *\n" +
            "FROM address\n" +
            "WHERE ST_Distance(location, ST_MakePoint(?2,?1)) <= ?3 * 1609.34", nativeQuery = true)
    List<Address> searchByLocation(@Param(value = "latitude") double latitude, @Param(value = "longitude") double longitude, @Param(value = "radius") double radius);


    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "UPDATE address SET location = ST_SetSRID(ST_MakePoint(?1, ?2),4326) where id=?3", nativeQuery = true)
    void saveGeolocation(@Param(value = "longitude") double longitude, @Param(value = "latitude") double latitude, @Param(value = "addressCount") long addressCount);
}
