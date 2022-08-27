package android.course.com.uiexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText name, password, email, phone, address;
        Button registration = findViewById(R.id.registration);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);

        Switch visibleAddress = findViewById(R.id.addressVisibility);
        RadioGroup genderRadioGroup = findViewById(R.id.gender_radio_group);



        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gender gender = getGender(genderRadioGroup.getCheckedRadioButtonId());
                if (checkIsValid(name, password, email, phone, address)) {
                    RegistrationRequest registrationRequest = new RegistrationRequest(
                            getStringFromEdit(email),
                            getStringFromEdit(password),
                            getStringFromEdit(name),
                            getStringFromEdit(address),
                            getStringFromEdit(phone),
                            visibleAddress.isChecked(),
                            gender
                            );

                    registrationRequest.printInformation();
                }
            }
        };

        registration.setOnClickListener(click);


    }


    boolean checkIsValid(EditText name, EditText password,
                         EditText email, EditText phone,
                         EditText address) {
        boolean isValid = true;

        if (getStringFromEdit(name).isEmpty()) {
            isValid = false;
            Toast.makeText(this, "must add your name", Toast.LENGTH_LONG).show();
        } else if (getStringFromEdit(password).isEmpty()) {
            isValid = false;
            password.setError("Required");
        } else if (getStringFromEdit(password).length() < 8) {
            isValid = false;
            password.setError("password must greater than 7 char or number");
        } else if (getStringFromEdit(email).isEmpty()) {
            isValid = false;
            email.setError("Required");
        } else if (getStringFromEdit(phone).isEmpty()) {
            isValid = false;
            phone.setError("Required");

        } else if (getStringFromEdit(address).isEmpty()) {
            isValid = false;
            address.setError("Required");
        }
        return isValid;
    }

    String getStringFromEdit(EditText editText) {
        return editText.getText().toString();
    }

    @SuppressLint("NonConstantResourceId")
    private Gender getGender(int checkedRadioButtonId) {
        switch (checkedRadioButtonId) {
            case R.id.male:
                return Gender.Male;
            case R.id.female:
                return Gender.Female;
        }
        return Gender.Male;
    }
}