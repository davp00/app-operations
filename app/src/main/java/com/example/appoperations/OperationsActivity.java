package com.example.appoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OperationsActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    protected EditText num1, num2;
    protected TextView resultText, errorText;
    protected Button resultButton;
    protected Spinner operationSpiner;

    protected OperationItem selectedOperation = null;
    protected Operation operationHandler = new Operation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);

        this.num1 = (EditText) findViewById(R.id.num1Text);
        this.num2 = (EditText) findViewById(R.id.num2Text);

        this.resultText = (TextView) findViewById(R.id.resultText);
        this.errorText = (TextView) findViewById(R.id.errorText);

        this.resultButton = (Button) findViewById(R.id.resultButton);

        this.resultButton.setOnClickListener(this);

        this.initSpinner();
    }

    private void initSpinner()
    {
        this.operationSpiner = (Spinner) findViewById(R.id.operationSpinner);

        ArrayList<OperationItem> operationItems = new ArrayList<>();
        operationItems.add(new OperationItem("+", "Suma"));
        operationItems.add(new OperationItem("-", "Resta"));
        operationItems.add(new OperationItem("*", "Multiplicación"));
        operationItems.add(new OperationItem("/", "División"));
        operationItems.add(new OperationItem("lcm", "Mínimo Común Múltiplo"));
        operationItems.add(new OperationItem("gcd", "Máximo Común Divisor"));

        this.selectedOperation = operationItems.get(0);

        ArrayAdapter<OperationItem> dataAdapter = new ArrayAdapter<>(this, R.layout.spinner, operationItems);
        this.operationSpiner.setAdapter(dataAdapter);
        this.operationSpiner.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View view)
    {
        this.resultText.setText("");
        this.errorText.setText("");

        if (selectedOperation == null)
        {
            Toast.makeText(this, "Operación no seleccionada", Toast.LENGTH_SHORT).show();
            return ;
        }
        String num1 = this.num1.getText().toString();
        String num2 = this.num2.getText().toString();

        if (num1.isEmpty())
        {
            Toast.makeText(this, "El número 1 es requerido", Toast.LENGTH_SHORT).show();
            return ;
        }

        if(num2.isEmpty())
        {
            Toast.makeText(this, "El número 2 es requerido", Toast.LENGTH_SHORT).show();
            return;
        }


        View v = this.getCurrentFocus();

        if (v != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }

        try {
            double result = this.operationHandler.getResult(selectedOperation.getValue(), Double.parseDouble(num1), Double.parseDouble(num2));

            this.resultText.setText(new String("Él Resultado es: "+result));
        } catch (Exception e) {
            this.errorText.setText(new String("ERROR: "+ e.getMessage()));
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        this.selectedOperation = (OperationItem) adapterView.getSelectedItem();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}