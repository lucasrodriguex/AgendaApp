package br.com.alura.agenda.helper;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.alura.agenda.FormActivity;
import br.com.alura.agenda.R;
import br.com.alura.agenda.model.User;

/**
 * Created by lucas on 16/04/2017.
 */

public class FormHelper {

    private EditText nameField;
    private EditText addressField;
    private EditText phoneField;
    private EditText webSiteField;
    private RatingBar ratingField;

    public FormHelper(FormActivity formActivity) {
        nameField = (EditText) formActivity.findViewById(R.id.form_name);
        addressField = (EditText) formActivity.findViewById(R.id.form_address);
        phoneField = (EditText) formActivity.findViewById(R.id.form_phone);
        webSiteField = (EditText) formActivity.findViewById(R.id.form_site);
        ratingField = (RatingBar) formActivity.findViewById(R.id.form_rating);

    }

    public User getUser(){
        User user = new User(nameField.getText().toString(),
                            addressField.getText().toString(),
                            phoneField.getText().toString(),
                            webSiteField.getText().toString(),
                            Double.valueOf(ratingField.getRating()));
        return user;
    }

}
