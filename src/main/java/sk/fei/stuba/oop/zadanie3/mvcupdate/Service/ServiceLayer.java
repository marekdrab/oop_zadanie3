package sk.fei.stuba.oop.zadanie3.mvcupdate.Service;


import org.springframework.stereotype.Service;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.Basic_agreement;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.lifeagreements.LifeInsurance;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.lifeagreements.TravelInsurance;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.nonlifeagreements.HomeInsurance;
import sk.fei.stuba.oop.zadanie3.mvcupdate.agreements.nonlifeagreements.HouseAndFlatInsurance;
import sk.fei.stuba.oop.zadanie3.mvcupdate.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ServiceLayer {
    private Map<Integer, User> users;
    private Map<Integer, Basic_agreement> agreements;
    private Map<Integer, LifeInsurance> lifeAgreements;
    private Map<Integer, TravelInsurance> travelAgreements;
    private Map<Integer, HomeInsurance> homeAgreements;
    private Map<Integer, HouseAndFlatInsurance> houseAgreements;

    public ServiceLayer() {
        this.users = new HashMap<>();
        this.agreements = new HashMap<>();
        this.lifeAgreements = new HashMap<>();
        this.travelAgreements = new HashMap<>();
        this.homeAgreements= new HashMap<>();
        this.houseAgreements= new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(),user);
    }

    public Map<Integer, User> findAllUsers() {
        return users;
    }

    public Optional<User> findUserById(int id) {
        return Optional.ofNullable(users.get(id));
    }


    public void addLifeAgreement(LifeInsurance agreement, User user){
        lifeAgreements.put(agreement.getId(),agreement);
        agreements.put(agreement.getId(),agreement);
        for (Map.Entry<Integer,User> i : users.entrySet()){
            if (i.getValue().getId()==user.getId()){
                user.setAgreements(agreement);
            }
        }
    }
    public void addTravelAgreement(TravelInsurance agreement, User user){
        travelAgreements.put(agreement.getId(),agreement);
        agreements.put(agreement.getId(),agreement);
        for (Map.Entry<Integer,User> i : users.entrySet()){
            if (i.getValue().getId()==user.getId()){
                user.setAgreements(agreement);
            }
        }
    }
    public void addHouseAgreement(HouseAndFlatInsurance agreement, User user){
        houseAgreements.put(agreement.getId(),agreement);
        agreements.put(agreement.getId(),agreement);
        for (Map.Entry<Integer,User> i : users.entrySet()){
            if (i.getValue().getId()==user.getId()){
                user.setAgreements(agreement);
            }
        }
    }
    public void addHomeAgreement(HomeInsurance agreement, User user){
        homeAgreements.put(agreement.getId(),agreement);
        agreements.put(agreement.getId(),agreement);
        for (Map.Entry<Integer,User> i : users.entrySet()){
            if (i.getValue().getId()==user.getId()){
                user.setAgreements(agreement);
            }
        }
    }

    public  Map<Integer, LifeInsurance> findAllLifeAgreements() {
        return lifeAgreements;
    }
    public  Map<Integer, TravelInsurance> findAllTravelAgreements() {
        return travelAgreements;
    }
    public  Map<Integer, HomeInsurance> findAllHomeAgreements() {
        return homeAgreements;
    }
    public  Map<Integer, HouseAndFlatInsurance> findAllHouseAgreements() {
        return houseAgreements;
    }
    
    public  Map<Integer, LifeInsurance> findLifeByInsurerID(int id){
        Map<Integer, LifeInsurance> temp = new HashMap<>();
        for (LifeInsurance i : lifeAgreements.values()){
            if (i.getInsurerId()==id||i.getInsuredid()==id){
                temp.put(i.getId(),i);
            }
        }
        return temp;
    }

    public  Map<Integer, TravelInsurance> findTravelByInsurerID(int id){
        Map<Integer, TravelInsurance> temp = new HashMap<>();
        for (TravelInsurance i : travelAgreements.values()){
            if (i.getInsurerId()==id||i.getInsuredid()==id){
                temp.put(i.getId(),i);
            }
        }
        return temp;
    }

    public  Map<Integer, HouseAndFlatInsurance> findHouseByInsurerID(int id){
        Map<Integer, HouseAndFlatInsurance> temp = new HashMap<>();
        for (HouseAndFlatInsurance i : houseAgreements.values()){
            if (i.getInsurerId()==id){
                temp.put(i.getId(),i);
            }
        }
        return temp;
    }

    public  Map<Integer, HomeInsurance> findHomeByInsurerID(int id){
        Map<Integer, HomeInsurance> temp = new HashMap<>();
        for (HomeInsurance i : homeAgreements.values()){
            if (i.getInsurerId()==id){
                temp.put(i.getId(),i);
            }
        }
        return temp;
    }

    public Optional<LifeInsurance> findLifeByID(int id) {
        return Optional.ofNullable(lifeAgreements.get(id));
    }
    public Optional<TravelInsurance> findTravelByID(int id) {
        return Optional.ofNullable(travelAgreements.get(id));
    }
    public Optional<HomeInsurance> findHomeByID(int id) {
        return Optional.ofNullable(homeAgreements.get(id));
    }
    public Optional<HouseAndFlatInsurance> findHouseByID(int id) {
        return Optional.ofNullable(houseAgreements.get(id));
    }
}
