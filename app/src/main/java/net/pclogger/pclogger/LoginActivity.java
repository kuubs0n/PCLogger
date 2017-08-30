package net.pclogger.pclogger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import IPclLicenseServiceContract.PclLicenseServiceContractClient;
import IPclLicenseServiceContract.UserAccountModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.editTextLogin) EditText _editTextLogin;
    @BindView(R.id.editTextPassword) EditText _editTextPassword;
    @BindView(R.id.buttonLogin) Button _buttonLogin;
    @BindView(R.id.textViewLinkToTerm) TextView _linkToTerm;

    private ProgressDialog _progressDialog;

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

    private boolean isEmailCorrect(String email){
        _editTextLogin.setError(null);

        if(TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            _editTextLogin.setError("Podaj poprawny email");
            return false;
        }
        return true;
    }

    private boolean isPasswordCorrect(String password){
        _editTextPassword.setError(null);

        if(TextUtils.isEmpty(password)){
            _editTextPassword.setError("Podaj hasło");
            return false;
        }
        return true;
    }

    private boolean validateCredentials(){
        boolean isCorrect = true;
        String email = _editTextLogin.getText().toString();
        String password = _editTextPassword.getText().toString();

        isCorrect = isEmailCorrect(email) && isPasswordCorrect(password);
        return isCorrect;
    }

    @OnClick(R.id.buttonLogin)
    public void submitButtonLogin(){
        if(validateCredentials()){
            loginAsync loginAction = new loginAsync();
            loginAction.execute();
        }
    }

    @OnClick(R.id.textViewLinkToTerm)
    public void submitTermLink(){
        Uri uri = Uri.parse("https://www.pclogger.net/pl/Regulamin.html");
        Intent startBrowser = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(startBrowser);
    }

    public class loginAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute(){
            _progressDialog = new ProgressDialog(LoginActivity.this);
            _progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            _progressDialog.setIndeterminate(true);
            _progressDialog.setMessage("Logowanie...");;
            _progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... args0){
            try{
                login();
            }catch(Exception ex){

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            _progressDialog.dismiss();
            Intent goToMain = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(goToMain);
        }
    }

    private void login(){
        PclLicenseServiceContractClient client = new PclLicenseServiceContractClient();
        UserAccountModel user =  client.Find("adhdteam420@yopmail.com", "qwerty.123", "192.168.0.10");
    }

}
