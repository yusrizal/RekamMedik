package id.ac.unsyiah.elektro.mobile.rekammedik;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class RegistrasiPasienActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi_pasien);

        new GcmRegistrationAsyncTask(this).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void onClickDaftar(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        String name  = String.valueOf(editText.getText().toString());

        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String email  = String.valueOf(editText.getText().toString());

        EditText editText3 = (EditText) findViewById(R.id.editText3);
        Date birthDay = new GregorianCalendar(2000, Calendar.FEBRUARY, 27).getTime();

        // simpan ke Datastore
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

        Entity user = new Entity("User");

        //ambil referensi nilai yang akan disimpan
        user.setProperty("name", name);
        user.setProperty("email", email);
        user.setProperty("birthDay", birthDay);

        //letakkan data ke datastore
        datastoreService.put(user);
    }
}
