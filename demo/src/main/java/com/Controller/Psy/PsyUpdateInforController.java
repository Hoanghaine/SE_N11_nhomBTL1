package com.Controller.Psy;
import java.io.IOException;

import com.App;
import java.sql.SQLException;

import com.Helper.AlertHelper;
import com.utils.ExecuteQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import static com.Controller.LoginController.idNow;

public class PsyUpdateInforController {
    @FXML
    Button btPhongKham,btBack,btLich,btTrangChu,btLogout,btThongTin,btTraLoi;
   @FXML
   TextField txtTen,txtTuoi,txtDiaChi,txtSdt,txtEmail,txtChuyenMon,txtKinhNghiem;
   @FXML
   ComboBox<String> cbGender;
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
    public void onClickBack(ActionEvent actionEvent) throws SQLException, IOException  {
        App.setRoot("PsyInfor");
    }
    public void onClickUpdate(ActionEvent actionEvent)throws SQLException,IOException{
        String ten = txtTen.getText();
        String tuoi = String.valueOf(Integer.parseInt(txtTuoi.getText()));
        String gioiTinh = selectedGioiTinh;
        String diaChi = txtDiaChi.getText();
        String email = txtEmail.getText();
        String chuyenMon = txtChuyenMon.getText();
        String exp = String.valueOf(Integer.parseInt(txtKinhNghiem.getText()));
        String sdt = txtSdt.getText();
        String insertSql = "UPDATE bac_si SET ten = '"+ten+"' ,tuoi = "+tuoi+",dia_chi = '"+diaChi+"'," +
                "so_dien_thoai = '"+sdt+"', email = '"+email+"', so_nam_kinh_nghiem = "+exp+", chuyen_mon = '"+chuyenMon+"' ,gioi_tinh = '"+gioiTinh+"' " +
                "where id_bacsi = "+idNow+"; ";
        ExecuteQuery query = new ExecuteQuery(insertSql);
        query.executeUpdate();
        AlertHelper.showAlert(Alert.AlertType.INFORMATION, "Thông báo", null, "Cập nhật thành công!");
    }

}
