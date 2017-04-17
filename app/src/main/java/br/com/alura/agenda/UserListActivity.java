package br.com.alura.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.com.alura.agenda.dao.UserDAO;
import br.com.alura.agenda.model.User;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        Button newUser = (Button) findViewById(R.id.new_user);
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToForm = new Intent(UserListActivity.this, FormActivity.class);
                startActivity(intentGoToForm);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadUserList();
    }

    private void loadUserList() {
        UserDAO dao = new UserDAO(this);
        List<User> users = dao.findUsers();
        dao.close();

        ListView listaAlunos = (ListView) findViewById(R.id.user_list);
        ArrayAdapter<User> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);
        listaAlunos.setAdapter(adapter);
    }
}
