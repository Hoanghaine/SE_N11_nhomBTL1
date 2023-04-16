package com.Controller.Psy;
import java.io.IOException;

import com.App;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import com.Controller.LoginController;
import com.utils.ExecuteQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class PsyInforController {
    @FXML
    Button btPhongKham;
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
    Label txtEmail;
    @FXML
    Label txtChuyenMon;
    @FXML
    Label txtKinhNghiem;
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

    public void initialize() {
        initInfo();
    }
    public int getId(){
        int id=-1 ;
        ExecuteQuery query = new ExecuteQuery(
                "SELECT id_bacsi FROM account_bacsi WHERE username = '" + LoginController.inputUsername + "'");
        ResultSet resultSet = query.executeQuery();

        try {
            if (resultSet.next()) {
                id = resultSet.getInt("id_bacsi");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    private void initInfo() {
        ExecuteQuery query = new ExecuteQuery("SELECT * FROM bac_si WHERE id_bacsi = '" + getId() + "' ");
        ResultSet resultSet = query.executeQuery();

        try {
            if (resultSet.next()) {
                txtTen.setText(resultSet.getString("ten"));
                txtTuoi.setText(resultSet.getString("tuoi"));
                txtDiaChi.setText(resultSet.getString("dia_chi"));
                txtSdt.setText(resultSet.getString("so_dien_thoai"));
                txtEmail.setText(resultSet.getString("email"));
                txtKinhNghiem.setText(resultSet.getString("so_nam_kinh_nghiem"));
                txtChuyenMon.setText(resultSet.getString("chuyen_mon"));
                txtGioiTinh.setText(resultSet.getString("gioi_tinh"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void onClickPhongKham(ActionEvent actionEvent)throws SQLException, IOException{
        App.setRoot("PsyPhongKham");
    }
    public void onClickTrangChu(ActionEvent actionEvent)throws SQLException, IOException{
        App.setRoot("PsyHome");
    }
    public void onClickTraLoi(ActionEvent actionEvent)throws SQLException, IOException{
        App.setRoot("PsyResponse");
    }
    public void onClickLich(ActionEvent actionEvent)throws SQLException, IOException{
        App.setRoot("PsyLich");
    }
    public void onClickLogout(ActionEvent actionEvent) throws SQLException, IOException  {
        App.setRoot("loginFrm");
    }
    public void onClickUpdate(ActionEvent actionEvent) throws SQLException, IOException  {
        App.setRoot("PsyUpdateInfor");
    }
}
