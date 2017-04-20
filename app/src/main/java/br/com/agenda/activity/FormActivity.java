package br.com.agenda.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.agenda.R;
import br.com.agenda.dao.UserDAO;
import br.com.agenda.helper.FormHelper;
import br.com.agenda.model.User;

public class FormActivity extends AppCompatActivity {

    private FormHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        helper = new FormHelper(this);

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
        if(user != null) {
            helper.fillForm(user);
        }
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

                if(user.getId() != null){
                    dao.updateUser(user);
                } else {
                    dao.insert(user);
                }
                dao.close();
                Toast.makeText(FormActivity.this
                        ,String.format("User %s Successfully Saved!!", user.getName())
                        ,Toast.LENGTH_SHORT).show();

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
