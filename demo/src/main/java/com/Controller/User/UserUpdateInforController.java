package com.Controller.User;
import java.io.IOException;

import com.App;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class UserUpdateInforController {
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

    @FXML
    Button btBack;
    public void onClickPhongKham(ActionEvent actionEvent)throws SQLException, IOException{
        App.setRoot("UserPhongKham");
    }
    public void onClickTrangChu(ActionEvent actionEvent)throws SQLException, IOException{
        App.setRoot("UserHome");
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
    public void onClickBack(ActionEvent actionEvent) throws SQLException, IOException  {
        App.setRoot("UserInfor");
    }

}
