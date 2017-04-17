package br.com.alura.agenda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.alura.agenda.dao.UserDAO;
import br.com.alura.agenda.helper.FormHelper;
import br.com.alura.agenda.model.User;

public class FormActivity extends AppCompatActivity {

    private FormHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        helper = new FormHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_form_ok:
                User user = helper.getUser();
                UserDAO dao = new UserDAO(this);
                dao.insert(user);

                Toast.makeText(FormActivity.this,
                        String.format("User %s Successfully Saved!!", user.getName()),
                        Toast.LENGTH_SHORT).show();

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
