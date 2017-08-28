package net.pclogger.pclogger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;

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
}
