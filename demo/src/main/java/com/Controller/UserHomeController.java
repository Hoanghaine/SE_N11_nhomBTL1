package com.Controller;
import java.io.IOException;

import com.App;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

public class UserHomeController {
    @FXML 
    Button btPhongKham;
    @FXML 
    Button btTimBacSy;
    @FXML 
    Button btThongTin;
    @FXML 
    Button btLogout;
    @FXML 
    Button btTrangChu;
    @FXML 
    Button btDatLich;

    public void onClickLogout(ActionEvent actionEvent) throws SQLException, IOException {
        App.setRoot("loginFrm");
    }
    public void onClickThongTin(ActionEvent actionEvent) throws SQLException, IOException{
        App.setRoot("inforUser");
    }
    public void onClickTrangChu(ActionEvent actionEvent) throws SQLException, IOException{
        App.setRoot("UserHome");
    }
    public void onClickPhongKham(ActionEvent actionEvent) throws SQLException, IOException{
        App.setRoot("PhongKham");
    }
    public void onClickTimBacSy(ActionEvent actionEvent) throws SQLException, IOException{
        App.setRoot("SearchUser");
    }
    public void onClickDatLich(ActionEvent actionEvent) throws SQLException, IOException{
        App.setRoot("BookingUser");
    }
}
