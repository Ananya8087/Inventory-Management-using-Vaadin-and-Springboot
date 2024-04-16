package com.example.application.views;


import com.example.application.views.util.DatabaseUtil;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.notification.Notification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Route("")
public class LoginView extends VerticalLayout {

    public LoginView() {
        TextField username = new TextField("Username");
        TextField password = new TextField("Password");
        Button loginButton = new Button("Login");

        loginButton.addClickListener(e -> {
            if (authenticate(username.getValue(), password.getValue())) {
                // Navigate to the main inventory page
                getUI().ifPresent(ui -> ui.navigate("master-detail"));
            } else {
                Notification.show("Invalid credentials!");
            }
        });

        add(new H1("Login"), username, password, loginButton);
    }

    private boolean authenticate(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();  // Return true if a row is found
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
