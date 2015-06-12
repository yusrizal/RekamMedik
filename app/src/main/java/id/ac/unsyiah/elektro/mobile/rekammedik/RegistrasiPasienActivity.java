package id.ac.unsyiah.elektro.mobile.rekammedik;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class RegistrasiPasienActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "ac.id.unsyiah.elektro.mobile.rekammedik.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi_pasien);

        new GcmRegistrationAsyncTask(this).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
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
    public void onClickDaftar(View view)
    {
        EditText textName = (EditText) findViewById(R.id.edit_nama_pasien);
        String name  = String.valueOf(textName.getText().toString());

        EditText textEmail = (EditText) findViewById(R.id.edit_email_pasien);
        String email  = String.valueOf(textEmail.getText().toString());

        EditText textBirthDay = (EditText) findViewById(R.id.edit_tgllahir_pasien);
        Date birthDay = new GregorianCalendar(2000, Calendar.FEBRUARY, 27).getTime();

        EditText textPass= (EditText) findViewById(R.id.edit_tgllahir_pasien);
        String password  = String.valueOf(textPass.getText().toString());
        password = HashUtil.getMD5(password);

        EditText textKonfPass = (EditText) findViewById(R.id.edit_tgllahir_pasien);
        String konfPass = String.valueOf(textKonfPass.getText().toString());
        konfPass = HashUtil.getMD5(konfPass);


        if (password.equals(konfPass))
        {
            //simpan ke SQLite

            // simpan ke Datastore
            DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

            Entity user = new Entity("User");

            //ambil referensi nilai yang akan disimpan
            user.setProperty("name", name);
            user.setProperty("email", email);
            user.setProperty("birthDay", birthDay);

            //letakkan data ke datastore
            datastoreService.put(user);

            Intent intent = new Intent(this, LoginActivity.class);
            String message =  "Pendaftaran berhasil";
            intent.putExtra(EXTRA_MESSAGE, message);
        }
        else
        {
            String passsalah = "Password tidak sesuai";
            //buat toast
            Toast.makeText(this,passsalah, Toast.LENGTH_SHORT)
                    .show();
        }

    }
}
