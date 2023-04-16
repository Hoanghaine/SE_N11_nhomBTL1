package com.Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.App;
import com.Helper.AlertHelper;
import com.utils.ExecuteQuery;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class PsyHomeController {
    @FXML
    Button btThongTin;
    @FXML
    Button btPhongKham;
    @FXML
    Button btLichKham;
    @FXML
    Button btYeuCau;
    @FXML
    Button btLogout;
    @FXML
    AnchorPane pane;

    @FXML
    private  void initialize(){
        paneTrangChu();
    }
    private void loadPane(String frm){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(frm));
            AnchorPane adminPane = loader.load();
            pane.getChildren().add(adminPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onClickPhongKham(ActionEvent actionEvent)throws SQLException, IOException{
        panePhongKham();
    }
    public void onClickLogout(ActionEvent actionEvent) throws SQLException, IOException  {
        App.setRoot("loginFrm");
    }

    private void paneTrangChu(){
        loadPane("TrangChu");
    }
    private void panePhongKham(){
        loadPane("PhongKham");
    }
}
