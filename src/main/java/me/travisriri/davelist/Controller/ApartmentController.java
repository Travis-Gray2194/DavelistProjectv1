package me.travisriri.davelist.Controller;

import me.travisriri.davelist.Models.Apartment;
import me.travisriri.davelist.Repositories.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.validation.Valid;

@Controller
public class ApartmentController {

    @Autowired
    ApartmentRepository apartmentRepository;



    @RequestMapping("/")
    public String showindex(Model model){

        model.addAttribute("apartmentlist",apartmentRepository.findAll());

        return "index";

    }

    @GetMapping("/add")
    public String addApartmentform(Model model){
        Apartment a = new Apartment();
        model.addAttribute("apartment",a);
        return "addapartmentform";

    }



    @PostMapping("/add")
    public String processApartmentform(@Valid @ModelAttribute("apartment")Apartment apartment, BindingResult result,Model model){

        if (result.hasErrors()){
             return "addapartmentform";
        }else{
            apartmentRepository.save(apartment);
            model.addAttribute("apartmentlist",apartmentRepository.findAll());

            return "redirect:/add";
        }
    }

    @GetMapping("/list")
    public String listapartment(Model model){
        model.addAttribute("apartmentlist",apartmentRepository.findAll());
        return "apartmentlist";

    }


    @GetMapping("/rentapt")
    public String rentApartment(Model model){
        model.addAttribute("availables", apartmentRepository.findByIsRentedTrue());
        return "availableaptlist";
    }

    @RequestMapping(value="/rentapt",method = RequestMethod.POST)
    public String postRentApartment(@RequestParam("id") Long id,Model model){

        Apartment toBeRented = apartmentRepository.findOne(id);
        toBeRented.setIsRented(false);
        toBeRented.setRented("Not Available");
        apartmentRepository.save(toBeRented);
        model.addAttribute("availables", apartmentRepository.findByIsRentedTrue());
        return "updatedlist";
    }


    @GetMapping("/updateapt")
    public String updateListing(Model model){
        model.addAttribute("notavailables", apartmentRepository.findByIsRentedFalse());
        return "updatedlist";
    }

    @RequestMapping(value="/updateapt",method = RequestMethod.POST)
    public String postUpdatedListing(@PathVariable("id") Long id, Model model){
        Apartment updated = apartmentRepository.findOne(id);
        updated.setIsRented(true);
        updated.setRented("Available");
        apartmentRepository.save(updated);
        model.addAttribute("notavailables", apartmentRepository.findByIsRentedFalse());
        return "availableaptlist";
    }



}
