package com.Controller.User;
import java.io.IOException;

import com.App;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class UserHomeController {
    @FXML 
    Button btPhongKham;
    @FXML 
    Button btTimBacSi;
    @FXML 
    Button btThongTin;
    @FXML 
    Button btLogout;
    @FXML
    Button btTrangChu;
    @FXML 
    Button btLich;
    public void onClickPhongKham(ActionEvent actionEvent)throws SQLException, IOException{
        App.setRoot("UserPhongKham");
    }
    public void onClickThongTin(ActionEvent actionEvent)throws SQLException, IOException{
        App.setRoot("UserInfor");
    }
    public void onClickTimBacSi(ActionEvent actionEvent)throws SQLException, IOException{
        App.setRoot("SearchPsy");
    }
    public void onClickLich(ActionEvent actionEvent)throws SQLException, IOException{
        App.setRoot("UserLich");
    }
    public void onClickLogout(ActionEvent actionEvent) throws SQLException, IOException  {
        App.setRoot("loginFrm");
    }

}
