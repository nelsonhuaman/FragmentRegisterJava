package com.example.fragmentregister;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    private OnRegistrationListener mListener;

    public interface OnRegistrationListener {
        void onRegistration(User user);
    }
    public void setOnRegistrationListener(OnRegistrationListener listener) {
        mListener = listener;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnRegistrationListener) {
            mListener = (OnRegistrationListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRegistrationListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        EditText editUsername = view.findViewById(R.id.editUsername2);
        EditText editPhone = view.findViewById(R.id.editPhone);
        EditText editPsw = view.findViewById(R.id.editPsw);
        EditText editFirstname = view.findViewById(R.id.editFirstname);
        EditText editLastname = view.findViewById(R.id.editLastname);
        EditText editEmail = view.findViewById(R.id.editEmail);
        Button buttonRegister = view.findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(v -> {
            String username = editUsername.getText().toString();
            String phone = editPhone.getText().toString();
            String password = editPsw.getText().toString();
            String firstname = editFirstname.getText().toString();
            String lastname = editLastname.getText().toString();
            String email = editEmail.getText().toString();

            User user = new User()
                    .setUsername(username)
                    .setPhone(phone)
                    .setPassword(password)
                    .setFirstname(firstname)
                    .setLastname(lastname)
                    .setEmail(email);

            mListener.onRegistration(user);
        });

        return view;
    }

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }
}