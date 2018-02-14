package me.travisriri.davelist;



import me.travisriri.davelist.Models.Apartment;
import me.travisriri.davelist.Repositories.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    ApartmentRepository apartmentRepository;


//    public Apartment(String address, String city, String state, String price, String listingDate, String description, String rules, String wifi, String cable, String privateBathroom, String rented) {
//        this.address = address;
//        this.city = city;
//        this.state = state;
//        this.price = price;
//        this.listingDate = listingDate;
//        this.description = description;
//        this.rules = rules;
//        this.wifi = wifi;
//        this.cable = cable;
//        this.privateBathroom = privateBathroom;
//        this.rented = rented;
//    }

    @Override
    public void run(String... strings) throws Exception {
        Apartment apartment1 = new Apartment("1 Summit Dr","Frederick","MD","1500","08/12/2019","Great Lounge are and gym","No pets","yes","no","yes","availible");
        apartmentRepository.save(apartment1);
    }
}