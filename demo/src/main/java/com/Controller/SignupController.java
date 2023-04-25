package com.Controller;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.App;
import com.Models.AccountBenhnhan;
import com.utils.ExecuteQuery;

import javafx.event.ActionEvent;
import com.Helper.AlertHelper;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class SignupController {
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtRePassword;
    @FXML
    private ComboBox<String> cbRole; 
    @FXML
    Button btBack;
    @FXML
    Button btnSignup;
    private String selectedRole = "User";
    @FXML
    public void initialize() { // xu ly combobox
        setCbRole();
    }

    private void setCbRole() {
        cbRole.getItems().addAll("User", "Psychologists");
        cbRole.getSelectionModel().selectFirst(); // set gia tri mac dinh cho combobox
        cbRole.setOnAction(e -> {
            selectedRole = cbRole.getSelectionModel().getSelectedItem().toString();
            System.out.println(selectedRole);
        });
    }

    @FXML
    public void onPressSignup(ActionEvent actionEventction) throws SQLException, IOException {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String rePassword = txtRePassword.getText();    
        String role = selectedRole;
        if(!rePassword.equals(password)) {
        	AlertHelper.showAlert(AlertType.INFORMATION, "Warning", null, "Mật khẩu xác nhận không giống nhau");
            return ;
        }
        if(role.equals("User")){
            ExecuteQuery queryID = new ExecuteQuery("SELECT MAX(id_benhnhan) FROM benh_nhan;");
            ResultSet rs = queryID.executeQuery();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            id++;

            ExecuteQuery query1 = new ExecuteQuery(
                    "INSERT INTO benh_nhan (id_benhnhan,ten,tuoi,dia_chi,so_dien_thoai,tinh_trang_benh,gioi_tinh) VALUES (" + id +",'', 0, '', '', '', '');"
            );
            query1.executeUpdate();

            ExecuteQuery query2 = new ExecuteQuery(
                    "INSERT INTO account_benhnhan VALUES ('" + username + "', '" + password + "',"+id+" );"
            );
            query2.executeUpdate();

            AlertHelper.showAlert(AlertType.INFORMATION, "Login successful", null, "You have successfully logged with User role.");
            App.setRoot("loginFrm");
        }else if(role.equals("Psychologists")){
            ExecuteQuery queryID2 = new ExecuteQuery("SELECT MAX(id_bacsi) FROM bac_si;");
            ResultSet rs2 = queryID2.executeQuery();
            int id2 = 0;
            if (rs2.next()) {
                id2 = rs2.getInt(1);
            }
            id2++;

            ExecuteQuery query3 = new ExecuteQuery(
                    "INSERT INTO bac_si (id_bacsi,ten,tuoi,dia_chi,so_dien_thoai,email,so_nam_kinh_nghiem,chuyen_mon,gioi_tinh) VALUES (" + id2 +",'', 0, '', '', '', 0, '', '');"
            );
            query3.executeUpdate();

            ExecuteQuery query4 = new ExecuteQuery(
                    "INSERT INTO account_bacsi VALUES ('" + username + "', '" + password + "',"+id2+" );"
            );
            query4.executeUpdate();
            AlertHelper.showAlert(AlertType.INFORMATION, "Login successful", null, "You have successfully logged with Psychologist role.");
            App.setRoot("loginFrm");
        }
    }
    @FXML
    public void onClickBack(ActionEvent actionEventction) throws SQLException, IOException {
        App.setRoot("loginFrm");
    }
}

