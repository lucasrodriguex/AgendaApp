package br.com.alura.agenda.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.UserDAO;
import br.com.alura.agenda.model.User;

public class UserListActivity extends AppCompatActivity {

    private ListView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        userList = (ListView) findViewById(R.id.user_list);

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View item, int position, long id) {
                User user = (User) list.getItemAtPosition(position);
                Intent goToForm = new Intent(UserListActivity.this, FormActivity.class);
                goToForm.putExtra("user", user);
                startActivity(goToForm);
            }
        });

        Button newUser = (Button) findViewById(R.id.new_user);
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToForm = new Intent(UserListActivity.this, FormActivity.class);
                startActivity(intentGoToForm);
            }
        });

        registerForContextMenu(userList);
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

        ArrayAdapter<User> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);
        userList.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem delete = menu.add("Delete");

        delete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

                User user = (User) userList.getItemAtPosition(info.position);

                UserDAO userDAO = new UserDAO(UserListActivity.this);
                userDAO.delete(user);
                userDAO.close();

                Toast.makeText(UserListActivity.this,
                        String.format("User %s removed!", user.getName()), Toast.LENGTH_SHORT).show();

                loadUserList();
                return false;
            }
        });

    }
}
