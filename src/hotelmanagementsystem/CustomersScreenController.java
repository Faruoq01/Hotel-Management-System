/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author COMPUMAGIC
 */
public class CustomersScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTreeTableView<Customer> treeView;

    @FXML
    private JFXTextField searchText;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadAllCustomers("SELECT * FROM customer ");
    }    
    
    public void loadAllCustomers(String sql){
        
        JFXTreeTableColumn<Customer,String> id=new JFXTreeTableColumn<>("Room Id");
        id.setPrefWidth(70);
        id.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                return param.getValue().getValue().id;
            }
        });
        
        
        JFXTreeTableColumn<Customer,String> name=new JFXTreeTableColumn<>("Name");
        name.setPrefWidth(80);
        name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                return param.getValue().getValue().name;
            }
        });
        
        JFXTreeTableColumn<Customer,String> email=new JFXTreeTableColumn<>("Room Number");
        email.setPrefWidth(110);
        email.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                return param.getValue().getValue().email;
            }
        });
        
        
        JFXTreeTableColumn<Customer,String> address=new JFXTreeTableColumn<>("Address");
        address.setPrefWidth(100);
        address.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                return param.getValue().getValue().address;
            }
        });
        
        JFXTreeTableColumn<Customer,String> phone=new JFXTreeTableColumn<>("Phone");
        phone.setPrefWidth(100);
        phone.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                return param.getValue().getValue().phone;
            }
        });
        
        JFXTreeTableColumn<Customer,String> num_people=new JFXTreeTableColumn<>("Number Of People");
        num_people.setPrefWidth(120);
        num_people.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                return param.getValue().getValue().numPeople;
            }
        });
        
        JFXTreeTableColumn<Customer,String> duration=new JFXTreeTableColumn<>("Duration");
        duration.setPrefWidth(110);
        duration.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                return param.getValue().getValue().duration;
            }
        });
        
        JFXTreeTableColumn<Customer,String> payment=new JFXTreeTableColumn<>("Payment Type");
        payment.setPrefWidth(110);
        payment.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                return param.getValue().getValue().paymentType;
            }
        });
        
        JFXTreeTableColumn<Customer,String> roomType=new JFXTreeTableColumn<>("Room Type");
        roomType.setPrefWidth(100);
        roomType.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                return param.getValue().getValue().roomType;
            }
        });
        
        
        JFXTreeTableColumn<Customer,String> rommNumber=new JFXTreeTableColumn<>("Room Number");
        rommNumber.setPrefWidth(110);
        rommNumber.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                return param.getValue().getValue().roomNumber;
            }
        });
        
        JFXTreeTableColumn<Customer,String> start=new JFXTreeTableColumn<>("Start Date");
        start.setPrefWidth(110);
        start.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                return param.getValue().getValue().startDate;
            }
        });
        
        
        JFXTreeTableColumn<Customer,String> end=new JFXTreeTableColumn<>("End Date");
        end.setPrefWidth(100);
        end.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                return param.getValue().getValue().endDate;
            }
        });
        
        JFXTreeTableColumn<Customer,String> price=new JFXTreeTableColumn<>("Price");
        price.setPrefWidth(80);
        price.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                return param.getValue().getValue().price;
            }
        });
        
        JFXTreeTableColumn<Customer,String> services=new JFXTreeTableColumn<>("Services");
        services.setPrefWidth(90);
        services.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                return param.getValue().getValue().services;
            }
        });
        
        JFXTreeTableColumn<Customer,String> total=new JFXTreeTableColumn<>("Total");
        total.setPrefWidth(90);
        total.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customer, String> param) {
                return param.getValue().getValue().total;
            }
        });
        
       
        
        
        ObservableList<Customer> customer = FXCollections.observableArrayList();
        Connection connection=DBConnection.getConnection();
        try {
            PreparedStatement ps=(PreparedStatement)connection.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                customer.add(new Customer(rs.getInt(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15)));
            }
                    } catch (SQLException ex) {
            Logger.getLogger(RoomScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         final TreeItem<Customer> root = new RecursiveTreeItem<Customer>(customer, RecursiveTreeObject::getChildren);
         
        treeView.getColumns().setAll(id,name,email,address,phone,num_people,payment,roomType,rommNumber,start,end,price,services,total);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
        
        
    }

    @FXML
    private void searchByRoomNumber(MouseEvent event) {
        loadAllCustomers("SELECT * FROM customer WHERE roomNumber='"+searchText.getText().toString().trim()+"'");
    }

    @FXML
    private void back(MouseEvent event) {
         Stage home=new Stage();
        Parent root=null;
        
        try {
            root=FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage current=(Stage)searchText.getScene().getWindow();
        Scene scene=new Scene(root);
        
        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);
        
        current.hide();
        home.show();
    }
    
}
