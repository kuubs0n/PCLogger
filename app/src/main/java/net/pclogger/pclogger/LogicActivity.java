package net.pclogger.pclogger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static android.support.v7.appcompat.R.styleable.View;

public class LogicActivity extends AppCompatActivity {

    @InjectView(R.id.editTextLogin) EditText _editTextLogin;
    @InjectView(R.id.editTextPassword) EditText _editTextPassword;
    @InjectView(R.id.buttonLogin) Button _buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic);

        setControls();
    }

    private void setControls(){
        EditText password = (EditText) findViewById(R.id.editTextPassword);
        password.setTransformationMethod(new PasswordTransformationMethod());
    }

    private boolean validateEmail(){
        String email = _editTextLogin.getText().toString();
        _editTextLogin.setError(null);

        if(TextUtils.isEmpty(email)){
            _editTextLogin.setError("Podaj email");
            return false;
        }else{
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }

    @OnClick(R.id.buttonLogin)
    public void submit(Button button){
        if(validateEmail()){
            //TODO ODPYTAJ API
    }
    }
}
