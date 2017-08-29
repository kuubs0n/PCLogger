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
        String NAMESPACE = "http://eleet.eu/services/";
        String SOAP_ACTION = "http://eleet.eu/services/Find";
        String METHOD_NAME = "Find";
        String URL = "http://prod-license-service.cloudapp.net/pclLicense.svc?wsdl";

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("email", "admin@pclogger.net");
        request.addProperty("password", "haslo");
        request.addProperty("ip", "192.168.0.1");

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);

        try{
            HttpTransportSE transport = new HttpTransportSE(URL);
            transport.call(SOAP_ACTION, envelope);

            SoapPrimitive result = (SoapPrimitive)envelope.getResponse();
            Object obj = result;
        } catch (SoapFault soapFault) {
            soapFault.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
