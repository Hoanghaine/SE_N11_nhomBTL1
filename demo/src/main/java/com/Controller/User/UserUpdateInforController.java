package com.Controller.User;
import java.io.IOException;

import com.App;
import java.sql.SQLException;

import com.Helper.AlertHelper;
import com.utils.ExecuteQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import static com.Controller.LoginController.idNow;

public class UserUpdateInforController {
    @FXML
    public ComboBox cbGender;
    @FXML
    Button btPhongKham,btTimBacSi,btThongTin,btLogout,btTrangChu,btLich,btLuu,btBack;
    @FXML
    TextField txtTen,txtTuoi,txtDiaChi,txtSdt,txtBenhTinh;
    @FXML
    private String selectedGioiTinh = "Nam";
    public void initialize() { // xu ly combobox
        setCbGioiTinh();
    }
    private void setCbGioiTinh() {
        cbGender.getItems().addAll("Nam", "Nữ", "Khác");
        cbGender.getSelectionModel().selectFirst(); // set gia tri mac dinh cho combobox
        cbGender.setOnAction(e -> {
            selectedGioiTinh = cbGender.getSelectionModel().getSelectedItem().toString();
            System.out.println(selectedGioiTinh);
        });
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
    public void onClickLogout(ActionEvent actionEvent) throws SQLException, IOException  {
        App.setRoot("loginFrm");
    }
    public void onClickBack(ActionEvent actionEvent) throws SQLException, IOException  {
        App.setRoot("UserInfor");
    }
    public void onClickUpdate(ActionEvent actionEvent)throws SQLException,IOException{
        String ten = txtTen.getText();
        System.out.println(ten);
        String tuoi = String.valueOf(Integer.parseInt(txtTuoi.getText()));
        System.out.println(tuoi);
        String gioiTinh = selectedGioiTinh;
        System.out.println(gioiTinh);
        String diaChi = txtDiaChi.getText();
        System.out.println(idNow);
        String sdt = txtSdt.getText();
        String benh = txtBenhTinh.getText();
        String insertSql = "UPDATE benh_nhan SET ten = '"+ten+"' ,tuoi = "+tuoi+",dia_chi = '"+diaChi+"'," +
                "so_dien_thoai = '"+sdt+"', tinh_trang_benh = '"+benh+"', gioi_tinh = '"+gioiTinh+"' " +
                "where id_benhnhan = "+idNow+"; ";
        ExecuteQuery query = new ExecuteQuery(insertSql);
        query.executeUpdate();
        AlertHelper.showAlert(Alert.AlertType.INFORMATION, "Thông báo", null, "Cập nhật thành công!");
    }
}
