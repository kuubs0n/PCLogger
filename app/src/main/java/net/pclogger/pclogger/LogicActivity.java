package net.pclogger.pclogger;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import IPclLicenseServiceContract.PclLicenseServiceContractClient;
import IPclLicenseServiceContract.UserAccountModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LogicActivity extends AppCompatActivity {

    @BindView(R.id.editTextLogin) EditText _editTextLogin;
    @BindView(R.id.editTextPassword) EditText _editTextPassword;
    @BindView(R.id.buttonLogin) Button _buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic);
        ButterKnife.bind(this);
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
        service asd = new service();
        asd.execute();
    }

    public class service extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... args0){
            try{
                WSDL();
            }catch(Exception ex){
                String asd = ex.getMessage();
            }
            return null;
        }
    }

    private void WSDL(){
        PclLicenseServiceContractClient client = new PclLicenseServiceContractClient();
        UserAccountModel user =  client.Find("adhdteam420@yopmail.com", "qwerty.123", "192.168.0.10");
    }

}
