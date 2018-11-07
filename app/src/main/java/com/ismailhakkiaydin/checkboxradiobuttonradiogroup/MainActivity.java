package com.ismailhakkiaydin.checkboxradiobuttonradiogroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout pnlPeriodNumbers, pnlPeriod;
    private EditText txtPeriod;
    private RadioButton rdoOnePeriod, rdoMultiPeriod;


    private void init(){
        pnlPeriodNumbers = findViewById(R.id.pnlPeriodNumbers);
        pnlPeriod = findViewById(R.id.pnlPeriod);
        txtPeriod = findViewById(R.id.txtPeriod);
        rdoOnePeriod = findViewById(R.id.rdoOnePeriod);
        rdoMultiPeriod = findViewById(R.id.rdoMultiPeriod);
    }

    public class RadioSelection implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
            if (rdoMultiPeriod.isChecked()){
                pnlPeriod.setVisibility(View.VISIBLE);
                pnlPeriodNumbers.setVisibility(View.VISIBLE);
            }else{
                pnlPeriod.setVisibility(View.INVISIBLE);
                pnlPeriodNumbers.setVisibility(View.INVISIBLE);
            }
        }
    }

    private void registerListener(){
        rdoMultiPeriod.setOnCheckedChangeListener(new RadioSelection());
        rdoOnePeriod.setOnCheckedChangeListener(new RadioSelection());
    }

    public void createPeriod(View view){
        pnlPeriod.removeAllViews();

        int nPeriod = Integer.valueOf(txtPeriod.getText().toString());

        for(int i=1; i<=nPeriod; i++){
            CheckBox cb = new CheckBox(this);
            cb.setText(i + " Period");

            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if(compoundButton.isChecked()){
                        String str = compoundButton.getText().toString();
                        Toast.makeText(MainActivity.this, str,Toast.LENGTH_LONG).show();
                    }
                }
            });

            pnlPeriod.addView(cb);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        registerListener();

    }
}
