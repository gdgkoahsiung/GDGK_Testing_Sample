package sample.gdgk.testing_sample.ex1.mvc;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import sample.gdgk.testing_sample.R;
import sample.gdgk.testing_sample.ex1.mvc.volley.GsonRequest;
import sample.gdgk.testing_sample.ex1.mvc.volley.LoginModel;
import sample.gdgk.testing_sample.ex1.mvc.volley.MyVolley;
import sample.gdgk.testing_sample.inject.Injection;
import sample.gdgk.testing_sample.model.LoginResponse;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private LoginModel model = Injection.provideLoginModel();
    private EditText emailEdit;
    private EditText passwordEdit;
    private View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);

        root = findViewById(R.id.root);

        emailEdit = (EditText) findViewById(R.id.emailEdit);
        passwordEdit = (EditText) findViewById(R.id.passwordEdit);

        View loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.loginButton) {
            GsonRequest<LoginResponse> request = model.login(emailEdit.getText().toString(), passwordEdit.getText().toString()
                    , new Response.Listener<LoginResponse>() {
                        @Override
                        public void onResponse(LoginResponse response) {
                            if (response.status == 1) {
                                Snackbar.make(root, R.string.login_success, Snackbar.LENGTH_LONG).show();
                            } else {
                                Snackbar.make(root, R.string.login_failed, Snackbar.LENGTH_LONG).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });

            MyVolley.getInstance(getApplicationContext()).addToRequestQueue(request);
        }
    }

}
