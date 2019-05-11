package com.example.jobcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    private Button recordButton;
    private  EditText name,phone,fault,specs,date,model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("zeniteck_jobcards");

        name = findViewById(R.id.edtCustomerName);
        phone = findViewById(R.id.edtPhoneNumber);
        fault = findViewById(R.id.edtLaptopModel);
        specs = findViewById(R.id.edtProblem);
        model = findViewById(R.id.edtHddRamSize);
        date = findViewById(R.id.edtDate);

        recordButton = findViewById(R.id.saveButton);


        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCustomerJobCard();

            }
        });
    }

      public void addCustomerJobCard(){

        String customerName = name.getText().toString();
        String customerPhone = phone.getText().toString();
        String machineFault = fault.getText().toString();
        String machineSpecs = specs.getText().toString();
        String machineModel = model.getText().toString();
        String recordDate = date.getText().toString();


        if(!TextUtils.isEmpty(customerName) 
                && !TextUtils.isEmpty(customerPhone)
                && !TextUtils.isEmpty(machineFault)
                && !TextUtils.isEmpty(machineSpecs)
                && !TextUtils.isEmpty(machineModel)
                && !TextUtils.isEmpty(recordDate)){


            String id = databaseReference.push().getKey();

            Customers customers = new Customers(id,customerName,customerPhone,machineModel,machineFault,machineSpecs);

                    databaseReference.child(id).setValue(customers);
                    name.setText("");
                    phone.setText("");
                    fault.setText("");
                    specs.setText("");
                    model.setText("");
                    date.setText("");
            
            
        }
            else {
            Toast.makeText(MainActivity.this, "Please Enter Particulars", Toast.LENGTH_LONG).show();
        }

      }


}
