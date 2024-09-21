package com.udea.consulta.repository;

import com.udea.consulta.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE (:startDate IS NULL OR :endDate IS NULL OR (f.date <= :endDate AND f.date >= :startDate)) " +
            "AND (:origin IS NULL OR f.origin = :origin) " +
            "AND (:price IS NULL OR f.price <= :price)" +
            "AND (:destination IS NULL OR f.destination = :destination) " +
            "AND (:baggageType IS NULL OR f.baggageType = :baggageType) " +
            "AND (:classType IS NULL OR f.classType = :classType) " +
            "AND (:maxNumberPassengers IS NULL OR f.maxNumberPassengers <= :maxNumberPassengers)")
    List<Flight> findFlightsByCriteria(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("origin") String origin,
            @Param("price") Double price,
            @Param("destination") String destination,
            @Param("baggageType") String baggageType,
            @Param("classType") String classType,
            @Param("maxNumberPassengers") Integer maxNumberPassengers);
}