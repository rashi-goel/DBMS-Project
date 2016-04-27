package com.example.hp.bs;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FragmentTwo extends Fragment {
    EditText t1,t2,t3;
    Button b1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment_two, container, false);
       t1=(EditText)view.findViewById(R.id.input_name);
        t2=(EditText)view.findViewById(R.id.input_email);
        t3=(EditText)view.findViewById(R.id.input_password);
        b1= (Button)view.findViewById(R.id.btn_signup);




       /* final ProgressDialog progressDialog = new ProgressDialog(getActivity(),R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();*/

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });





        return view;
    }

    public void signup() {
        Log.d("TAG", "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }
    }

    public void onSignupFailed() {
        Snackbar snackbar = Snackbar
                .make(getView(), "LogIn Failed", Snackbar.LENGTH_LONG);

        snackbar.show();
    }


    public boolean validate(){
        boolean valid = true;

        String name = t1.getText().toString();
        String email = t2.getText().toString();
        String password = t3.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            t1.setError("at least 3 characters");
            valid = false;
        } else {
            t1.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            t2.setError("enter a valid email address");
            valid = false;
        } else {
            t2.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            t3.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            t3.setError(null);
        }

        return valid;
    }
}



