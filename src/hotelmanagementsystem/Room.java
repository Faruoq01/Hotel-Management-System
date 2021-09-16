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
public class Room extends RecursiveTreeObject<Room>{
    
    
    StringProperty id;
    StringProperty roomType;
    StringProperty roomNumber;
    StringProperty numberOfPeople;
    StringProperty floorNumber;
    StringProperty roomPhone;
    StringProperty roomPrice;
    StringProperty roomStatus;
    public Room(){
        super();
    }

    public Room(String id, String roomType, String roomNumber, String numberOfPeople, String floorNumber, String roomPhone, String roomPrice, String roomStatus) {
        this.id = new SimpleStringProperty(id);
        this.roomType = new SimpleStringProperty(roomType);
        this.roomNumber = new SimpleStringProperty(roomNumber);
        this.numberOfPeople = new SimpleStringProperty(numberOfPeople);
        this.floorNumber = new SimpleStringProperty(floorNumber);
        this.roomPhone = new SimpleStringProperty(roomPhone);
        this.roomPrice = new SimpleStringProperty(roomPrice);
        this.roomStatus = new SimpleStringProperty(roomStatus);
    }
    
    
     /**
     * 
     * 
     * 
     * final TreeItem<Room> root = new RecursiveTreeItem<Room>(users, RecursiveTreeObject::getChildren);
        treeView.getColumns().setAll(emp_id, emp_first_name, emp_last_name,emp_phone,emp_address,emp_age ,emp_dept ,emp_start_date);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
     * @param url
     * @param rb
     */
    
    
    
}
