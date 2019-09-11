package com.cognition.projectua;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Context context;
    TabLayout tabLayout;
    Chip chip;
    TextInputEditText name;
    TextInputEditText email;
    TextInputLayout nameLayout;
    TextInputLayout emailLayout;
    MaterialButton storeButton;
    TextView info;

    void initialize() {
        this.context = this;
        Chip chip = (Chip) findViewById(R.id.langChip);
        this.chip = chip;
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        this.tabLayout = tabLayout;
        TextInputEditText name = (TextInputEditText) findViewById(R.id.nameInput);
        this.name = name;
        TextInputEditText email = (TextInputEditText) findViewById(R.id.emailInput);
        this.email = email;
        TextInputLayout nameLayout = (TextInputLayout) findViewById(R.id.nameLayout);
        this.nameLayout = nameLayout;
        TextInputLayout emailLayout = (TextInputLayout) findViewById(R.id.emailLayout);
        this.emailLayout = emailLayout;
        MaterialButton storeButton = (MaterialButton) findViewById(R.id.storeButton);
        this.storeButton = storeButton;
        TextView info = (TextView) findViewById(R.id.infoText);
        this.info = info;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        methods();
    }


    void methods() {
        chipController();
        tabChanger();
        logicDrive(email.getText());
        emailValidator();

    }

    void chipController() {
        chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String language = chip.getText().toString();
                if (language.contains("English")) {
                    chip.setText("भाषा: हिंदी");
                } else {
                    chip.setText("Language: English");
                }

            }
        });
    }

    void tabChanger() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:{
                        System.out.println(tab.getText());
                        break;
                    }case 1:{
                        System.out.println(tab.getText());
                        break;
                    }case 2:{
                        System.out.println(tab.getText());
                        break;
                    }

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    void emailValidator(){
        String value=email.getText().toString();



        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                logicDrive(charSequence);

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                logicDrive(charSequence);


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    void logicDrive(CharSequence charSequence)
    {

        Logic logic =new Logic();
        if (logic.isValidEmail(charSequence.toString()))
        {
            emailLayout.setBoxStrokeColor(getResources().getColor(R.color.valid));
            emailLayout.setError("");

        }
        else
        {
            emailLayout.setError("error: Invalid Email");
        }

    }


}
