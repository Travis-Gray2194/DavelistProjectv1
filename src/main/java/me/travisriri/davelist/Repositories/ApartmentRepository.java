package me.travisriri.davelist.Repositories;

import me.travisriri.davelist.Models.Apartment;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepository extends CrudRepository<Apartment, Long> {


    Iterable<Apartment> findByIsRentedTrue();
    Iterable<Apartment> findByIsRentedFalse();
}
