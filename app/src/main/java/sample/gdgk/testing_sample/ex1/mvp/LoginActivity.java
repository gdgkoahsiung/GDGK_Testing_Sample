package sample.gdgk.testing_sample.ex1.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import sample.gdgk.testing_sample.R;
import sample.gdgk.testing_sample.inject.Injection;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private LoginPresenter presenter = new LoginPresenter(this, Injection.provideRetrofitModel());
    private TextInputLayout emailTextInputLayout;
    private TextInputLayout passwordTextInputLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        EditText emailEdit = (EditText) findViewById(R.id.emailEdit);
        EditText passwordEdit = (EditText) findViewById(R.id.passwordEdit);

        View loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> presenter.checkValidAndLogin(emailEdit.getText().toString(),
                passwordEdit.getText().toString()));

        emailTextInputLayout = (TextInputLayout) findViewById(R.id.emailTextInputLayout);
        passwordTextInputLayout = (TextInputLayout) findViewById(R.id.passwordTextInputLayout);
    }

    @Override
    public void showEmailError() {
        emailTextInputLayout.setError(getString(R.string.email_error));
    }

    @Override
    public void showPasswordError() {
        passwordTextInputLayout.setError(getString(R.string.password_error));
    }

    @Override
    public void clearErrorMessage() {
        emailTextInputLayout.setError("");
        passwordTextInputLayout.setError("");
    }

    @Override
    public void showLoginError(String message) {
        Snackbar.make(findViewById(R.id.root), message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginSuccess() {
        Snackbar.make(findViewById(R.id.root), R.string.login_success, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginFailed() {
        Snackbar.make(findViewById(R.id.root), R.string.login_failed, Snackbar.LENGTH_LONG).show();
    }
}
