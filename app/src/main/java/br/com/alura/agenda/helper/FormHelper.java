package br.com.alura.agenda.helper;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.alura.agenda.R;
import br.com.alura.agenda.activity.FormActivity;
import br.com.alura.agenda.model.User;

/**
 * Created by lucas on 16/04/2017.
 */

public class FormHelper {

    private User user;
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
        user = new User();
    }

    public User getUser(){
        user.setName(nameField.getText().toString());
        user.setAddress(addressField.getText().toString());
        user.setPhone(phoneField.getText().toString());
        user.setSite(webSiteField.getText().toString());
        user.setRating(Double.valueOf(ratingField.getRating()));

        return user;
    }

    public void fillForm(User user) {
        nameField.setText(user.getName());
        addressField.setText(user.getAddress());
        phoneField.setText(user.getPhone());
        webSiteField.setText(user.getSite());
        ratingField.setRating(user.getRating().floatValue());
        this.user = user;
    }
}
