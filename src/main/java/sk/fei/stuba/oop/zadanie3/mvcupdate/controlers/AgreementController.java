package sk.fei.stuba.oop.zadanie3.mvcupdate.controlers;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.fei.stuba.oop.zadanie3.mvcupdate.Service.ServiceLayer;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.lifeagreements.LifeInsurance;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.lifeagreements.TravelInsurance;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.nonlifeagreements.HomeInsurance;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.nonlifeagreements.HouseAndFlatInsurance;
import sk.fei.stuba.oop.zadanie3.mvcupdate.user.User;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AgreementController {
    private final ServiceLayer agreementservice;
    private final ServiceLayer userservice;

    @Autowired
    public AgreementController(ServiceLayer agreementservice,ServiceLayer userservice) {
        this.agreementservice = agreementservice;
        this.userservice = userservice;
    }

    @GetMapping("/list_of_agreements")
    public String allAgreements(@NotNull Model model){
        model.addAttribute("agreements1",agreementservice.findAllLifeAgreements());
        model.addAttribute("agreements2",agreementservice.findAllTravelAgreements());
        model.addAttribute("agreements3",agreementservice.findAllHomeAgreements());
        model.addAttribute("agreements4",agreementservice.findAllHouseAgreements());
        return "agreements/list_of_agreements";
    }

    @GetMapping("/detail_agreement/{id}")
    public String detailAgreement(@PathVariable int id,@NotNull Model model){
        Optional<LifeInsurance> LifeById = agreementservice.findLifeByID(id);
        Optional<TravelInsurance> TravelById = agreementservice.findTravelByID(id);
        Optional<HomeInsurance> HomeById = agreementservice.findHomeByID(id);
        Optional<HouseAndFlatInsurance> HouseById = agreementservice.findHouseByID(id);

        if (LifeById.isPresent()){
            LifeInsurance agreement = LifeById.get();
            model.addAttribute("agreement",agreement);
            return "agreements/life/lifeInsurance/life_detail";
        }
        else if (TravelById.isPresent()){
            TravelInsurance agreement = TravelById.get();
            model.addAttribute("agreement",agreement);
            return "agreements/life/travelInsurance/travel_detail";
        }
        else if (HomeById.isPresent()){
            HomeInsurance agreement = HomeById.get();
            model.addAttribute("agreement",agreement);
            return "agreements/nonlife/homeInsurance/home_detail";
        }
        else if (HouseById.isPresent()){
            HouseAndFlatInsurance agreement = HouseById.get();
            model.addAttribute("agreement",agreement);
            return "agreements/nonlife/houseInsurance/house_detail";
        }
        else{
            return "agreements/list_of_agreements";
        }
    }
    @GetMapping("/update_agreement/{id}")
    public String updateAgreement(@PathVariable int id,@NotNull Model model){
        Optional<LifeInsurance> LifeById = agreementservice.findLifeByID(id);
        Optional<TravelInsurance> TravelById = agreementservice.findTravelByID(id);
        Optional<HomeInsurance> HomeById = agreementservice.findHomeByID(id);
        Optional<HouseAndFlatInsurance> HouseById = agreementservice.findHouseByID(id);

        if (LifeById.isPresent()){
            LifeInsurance agreement = LifeById.get();
            model.addAttribute("agreement",agreement);
            return "agreements/life/lifeInsurance/update_life";
        }
        else if (TravelById.isPresent()){
            TravelInsurance agreement = TravelById.get();
            model.addAttribute("agreement",agreement);
            return "agreements/life/travelInsurance/update_travel";
        }
        else if (HomeById.isPresent()){
            HomeInsurance agreement = HomeById.get();
            model.addAttribute("agreement",agreement);
            return "agreements/nonlife/homeInsurance/update_home";
        }
        else if (HouseById.isPresent()){
            HouseAndFlatInsurance agreement = HouseById.get();
            model.addAttribute("agreement",agreement);
            return "agreements/nonlife/houseInsurance/update_house";
        }
        else{
            return "agreements/list_of_agreements";
        }
    }




    @GetMapping("/add_agreement")
    public String addAgreement(){
        return "agreements/add_agreement";
    }
    @GetMapping("/add_life")
    public String addLife(Model model,User user){
        model.addAttribute("agreement",new LifeInsurance());
        //model.addAttribute("user",userservice.findUserById(user.getId()));
        return "agreements/life/lifeInsurance/add_life";
    }
    @GetMapping("/add_travel")
    public String addTravel(Model model,User user){
        model.addAttribute("agreement",new TravelInsurance());
       // model.addAttribute("user",userservice.findUserById(user.getId()));

        return "agreements/life/travelInsurance/add_travel";
    }
    @GetMapping("/add_home")
    public String addHome(Model model,User user){
        model.addAttribute("agreement",new HomeInsurance());
        //model.addAttribute("user",userservice.findUserById(user.getId()));
        return "agreements/nonlife/homeInsurance/add_home";
    }
    @GetMapping("/add_house")
    public String addHouse(Model model,User user){
        model.addAttribute("agreement",new HouseAndFlatInsurance());
        //model.addAttribute("user",userservice.findUserById(user.getId()));
        return "agreements/nonlife/houseInsurance/add_house";
    }
    @PostMapping("/add_life")
    public  String agreementAddSubmit(@ModelAttribute LifeInsurance agreement,@ModelAttribute User user) {
        agreementservice.addLifeAgreement(agreement,user);
        return "redirect:/";
    }
    @PostMapping("/add_travel")
    public  String travelAddSubmit(@ModelAttribute TravelInsurance agreement,@ModelAttribute User user) {
        agreementservice.addTravelAgreement(agreement,user);
        return "redirect:/";
    }
    @PostMapping("/add_home")
    public  String homeAddSubmit(@ModelAttribute @Valid HomeInsurance agreement, @ModelAttribute @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "agreements/nonlife/homeInsurance/add_home";
        }
        agreementservice.addHomeAgreement(agreement,user);
        return "redirect:/";
    }
    @PostMapping("/add_house")
    public  String houseAddSubmit(@ModelAttribute HouseAndFlatInsurance agreement,@ModelAttribute User user) {
        agreementservice.addHouseAgreement(agreement,user);
        return "redirect:/";
    }
    @PostMapping("/update_life")
    public  String lifeUpdateSubmit(@ModelAttribute LifeInsurance agreement,@ModelAttribute User user) {
        agreementservice.addLifeAgreement(agreement,user);
        return "redirect:/";
    }
    @PostMapping("/update_travel")
    public  String travelUpdateSubmit(@ModelAttribute TravelInsurance agreement,@ModelAttribute User user) {
        agreementservice.addTravelAgreement(agreement,user);
        return "redirect:/";
    }
    @PostMapping("/userdetail/{id}/update_home")
    public  String homeUpdateSubmit(@ModelAttribute HomeInsurance agreement,@ModelAttribute User user) {
        agreementservice.addHomeAgreement(agreement,user);
        return "redirect:/";
    }
    @PostMapping("/update_house")
    public  String houseUpdateSubmit(@ModelAttribute HouseAndFlatInsurance agreement,@ModelAttribute User user) {
        agreementservice.addHouseAgreement(agreement,user);
        return "redirect:/";
    }

}
