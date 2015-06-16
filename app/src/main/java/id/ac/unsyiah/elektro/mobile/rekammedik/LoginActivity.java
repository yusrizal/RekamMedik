package id.ac.unsyiah.elektro.mobile.rekammedik;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;


public class LoginActivity extends Activity {

    public final static String EXTRA_MESSAGE = "ac.id.unsyiah.elektro.mobile.rekammedik.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();
        String message = intent.getStringExtra(RegistrasiPasienActivity.EXTRA_MESSAGE);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void doLogin(View view){
        //ambil data dari masukkan user
        EditText txtemail = (EditText) findViewById(R.id.edit_email);
        String email = String.valueOf(txtemail.getText().toString());

        EditText txtpass = (EditText) findViewById(R.id.edit_Pass);
        String pass = String.valueOf(txtpass.getText().toString());
        pass = HashUtil.getMD5(pass);

        //ambil data dari datastore

        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

        // ambil email

        //ambil hash dari pass

        //cocokkan masukkan yang diberikan
        /**
        if (pass ){

        }else{

        }
         */
    }
    public void doRegister(View view){
    }
}
