package com.Controller.Psy;
import java.io.IOException;

import com.App;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class PsyResponseController {
    @FXML
    Button btPhongKham;
    @FXML
    Button btTraLoi;
    @FXML
    Button btThongTin;
    @FXML
    Button btLogout;
    @FXML
    Button btTrangChu;
    @FXML
    Button btLich;
    public void onClickPhongKham(ActionEvent actionEvent)throws SQLException, IOException{
        App.setRoot("PsyPhongKham");
    }
    public void onClickThongTin(ActionEvent actionEvent)throws SQLException, IOException{
        App.setRoot("PsyInfor");
    }
    public void onClickTrangChu(ActionEvent actionEvent)throws SQLException, IOException{
        App.setRoot("PsyHome");
    }
    public void onClickLich(ActionEvent actionEvent)throws SQLException, IOException{
        App.setRoot("PsyLich");
    }
    public void onClickLogout(ActionEvent actionEvent) throws SQLException, IOException  {
        App.setRoot("loginFrm");
    }

}
