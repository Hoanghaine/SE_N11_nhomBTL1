package com.Controller.User;
import java.io.IOException;

import com.App;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.Controller.LoginController;
import com.utils.ExecuteQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class UserInfoController {
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
    Label txtTen;
    @FXML
    Label txtTuoi;
    @FXML
    Label txtGioiTinh;
    @FXML
    Label txtDiaChi;
    @FXML
    Label txtSdt;
    @FXML
    Label txtBenhTinh;

    public void initialize() {
        initInfo();
    }
    public int getId(){
        int id=-1 ;
        ExecuteQuery query = new ExecuteQuery(
                "SELECT id_benhnhan FROM account_benhnhan WHERE username = '" + LoginController.inputUsername + "'");
        ResultSet resultSet = query.executeQuery();

        try {
            if (resultSet.next()) {
                id = resultSet.getInt("id_benhnhan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    private void initInfo() {
        ExecuteQuery query = new ExecuteQuery("SELECT * FROM benh_nhan WHERE id_benhnhan = '" + getId() + "' ");
        ResultSet resultSet = query.executeQuery();

        try {
            if (resultSet.next()) {
                txtTen.setText(resultSet.getString("ten"));
                txtTuoi.setText(resultSet.getString("tuoi"));
                txtDiaChi.setText(resultSet.getString("dia_chi"));
                txtSdt.setText(resultSet.getString("so_dien_thoai"));
                txtGioiTinh.setText(resultSet.getString("gioi_tinh"));
                txtBenhTinh.setText(resultSet.getString("tinh_trang_benh"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
    public void onClickUpdate(ActionEvent actionEvent)throws SQLException, IOException{
        App.setRoot("UserUpdateInfor");
    }

    public void onClickLogout(ActionEvent actionEvent) throws SQLException, IOException  {
        App.setRoot("loginFrm");
    }

    public void btTimBacSi(ActionEvent actionEvent) {
    }
}
