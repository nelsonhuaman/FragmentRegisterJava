package com.example.fragmentregister;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements RegisterFragment.OnRegistrationListener {

    private TextView textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textMessage = findViewById(R.id.txtMessage);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RegisterFragment registerFragment = RegisterFragment.newInstance();
        registerFragment.setOnRegistrationListener(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, registerFragment)
                .commit();
    }

    @Override
    public void onRegistration(User user) {
        textMessage.setText("Name: " + user.getFirstname() + " " + user.getLastname() +
                "\nEmail: " + user.getEmail() +
                "\nPhone: " + user.getPhone() +
                "\nUsername: " + user.getUsername());
    }
}