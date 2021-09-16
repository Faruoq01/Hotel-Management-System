/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.action.Action;

/**
 * FXML Controller class
 *
 * @author COMPUMAGIC
 */
public class LoginScreenController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField password;
    @FXML
    private StackPane stackepane;

   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButton(MouseEvent event) {
        
        
     
        if(username.getText().toString().equals("")){
            Image image=new Image("img/delete.png");
                Notifications notification=Notifications.create()
                        .title("Error")
                        .text("Username Is Empty")
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_LEFT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
        }else if(password.getText().toString().equals("")){
            Image image=new Image("img/delete.png");
                Notifications notification=Notifications.create()
                        .title("Error")
                        .text("Password Is Empty")
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_LEFT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
        }else{
            
            
            boolean isExist=false;
        String userPass="";
        String userType="";
        String sql="select * from users where username='"+username.getText().toString().trim()+"'";
        Connection connection=DBConnection.getConnection();
        try {
            PreparedStatement ps=(PreparedStatement)connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                isExist=true;
                userPass=rs.getString(3);
                userType=rs.getString(9);
            }
            
            if(isExist){
                
                if(password.getText().toString().trim().equals(userPass)){
                    
                    if(userType.equals("admin")){
                       //if user admin --> Admin Screen 
                       
                        Stage adminScreen=new Stage();
                        Parent root=null;
                        
                        try {
                            root=FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Stage current=(Stage)username.getScene().getWindow();
                        Scene scene=new Scene(root,1366,730);
                        
                        adminScreen.setScene(scene);
                        adminScreen.initStyle(StageStyle.TRANSPARENT);
                        
                        current.hide();
                        
                        adminScreen.show();
                        
                    }else{
                        //if user normal --> Home Screen
                        
                        
                        Stage homeScreen=new Stage();
                        Parent root=null;
                        
                        try {
                            root=FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Stage current=(Stage)username.getScene().getWindow();
                        Scene scene=new Scene(root,1366,730);
                        
                        homeScreen.setScene(scene);
                        homeScreen.initStyle(StageStyle.TRANSPARENT);
                        
                        current.hide();
                        
                        homeScreen.show();
                    }
                    
                }
            }else{
                
                Image image=new Image("img/delete.png");
                Notifications notification=Notifications.create()
                        .title("Error")
                        .text("Check Your username and password again")
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.BOTTOM_LEFT)
                        .graphic(new ImageView(image));
                notification.darkStyle();
                notification.show();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
        
        
        
        
        
        
        
        
    }

    @FXML
    private void cancelButton(MouseEvent event) {
        
        JFXDialogLayout dialogLayout=new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Close"));
        dialogLayout.setBody(new Text("Do You want to exit !"));
        
        JFXButton ok=new JFXButton("Ok");
        JFXButton Cancel=new JFXButton("Cancel");
        
        JFXDialog dialog=new JFXDialog(stackepane, dialogLayout, JFXDialog.DialogTransition.CENTER);
        
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        
        Cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        
        dialogLayout.setActions(ok,Cancel);
        dialog.show();
        
    }

   
    
}
