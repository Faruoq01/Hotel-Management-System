/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author COMPUMAGIC
 */
public class Customer extends RecursiveTreeObject<Customer>{
    
    
    StringProperty id;
    StringProperty name;
    StringProperty email;
    StringProperty address;
    StringProperty phone;
    StringProperty numPeople;
    StringProperty duration;
    StringProperty paymentType;
    StringProperty roomType;
    StringProperty roomNumber;
    StringProperty startDate;
    StringProperty endDate;
    StringProperty price;
    StringProperty services;
    StringProperty total;
   
    public Customer(){
        super();
    }

    public Customer(String id, String name, String email, String address, String phone, String numPeople, String duration, String paymentType, String roomType, String roomNumber, String startDate, String endDate, String price, String services, String total) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.address = new SimpleStringProperty(address);
        this.phone = new SimpleStringProperty(phone);
        this.numPeople = new SimpleStringProperty(numPeople);
        this.duration = new SimpleStringProperty(duration);
        this.paymentType = new SimpleStringProperty(paymentType);
        this.roomType = new SimpleStringProperty(roomType);
        this.roomNumber = new SimpleStringProperty(roomNumber);
        this.startDate = new SimpleStringProperty(startDate);
        this.endDate = new SimpleStringProperty(endDate);
        this.price = new SimpleStringProperty(price);
        this.services = new SimpleStringProperty(services);
        this.total = new SimpleStringProperty(total);
    }

    
    
  
    
    
    
}