package labwork.lab1;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


    public class Activity extends AppCompatActivity {
        EditText firstNameET;
        EditText lastNameET;
        EditText phoneET;
        EditText passwordET;
        EditText emailET;
        EditText confirmPasswordET;

        @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registration);

            firstNameET = findViewById(R.id.fname);
            lastNameET = findViewById(R.id.lname);
            phoneET = findViewById(R.id.phone);
            passwordET = findViewById(R.id.password);
            emailET = findViewById(R.id.email);
            confirmPasswordET = findViewById(R.id.cpassword);
        }

        public void register(View view) {
            final String firstName = firstNameET.getText().toString();
            if (!isValidFirstName(firstName)) {
                firstNameET.setError("Ще раз ім'я");
            }

            final String lastName = lastNameET.getText().toString();
            if (!isValidLastName(lastName)) {
                lastNameET.setError("Ще раз прізвище");
            }

            final String email = emailET.getText().toString();
            if (!isValidEmail(email)) {
                emailET.setError("Повторіть ввід");
            }
            final String pass = passwordET.getText().toString();
            if (!isValidPassword(pass)) {
                passwordET.setError("Пароль повинен бути більше 6 символів");
            }
            final String phone = phoneET.getText().toString();
            if (!isValidPhone(phone)) {
                phoneET.setError("Не правильний ввід номера, повторіть");
            }
            if (!confirmPasswordET.equals(passwordET)) {
                confirmPasswordET.setError("Паролі мають співпадати");
            }
        }

        //validating email
        private boolean isValidEmail(String email) {
            Pattern EMAIL_PATTERN = Patterns.EMAIL_ADDRESS;
            Pattern pattern = Pattern.compile(String.valueOf(EMAIL_PATTERN));
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }

        // validating password
        private boolean isValidPassword(String pass) {
            if (pass.length() < 6) {
                return false;
            }
            final String PASSWORD_PATTERN = "[a-zA-Z0-9]{6,20}";
            Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
            Matcher matcher = pattern.matcher(pass);
            return matcher.matches();
        }

        //validating phone
        private boolean isValidPhone(String phone) {
            String PHONE_PATTERN = "[0-9]{10}";
            Pattern pattern = Pattern.compile(PHONE_PATTERN);
            Matcher matcher = pattern.matcher(phone);
            return matcher.matches();
        }

        // validate firstName
        private boolean isValidFirstName(String firstName) {
            String FirstName_PATTERN = "[a-z]{1,20}";
            Pattern pattern = Pattern.compile(FirstName_PATTERN);
            Matcher matcher = pattern.matcher(firstName);
            return matcher.matches();
        }

        //validateLastName
        private boolean isValidLastName(String lastName) {
            String LASTANAME_PATTERN = "[a-zA-Z]{1,20}";
            Pattern pattern = Pattern.compile(LASTANAME_PATTERN);
            Matcher matcher = pattern.matcher(lastName);
            return matcher.matches();
        }

        public void onViewList(View view) {
            Intent i = new Intent(this, InfoActivity.class);
            startActivity(i);
        }
    }