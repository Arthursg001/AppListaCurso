package dev.android.mobile.santos.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import dev.android.mobile.santos.applistacurso.R;
import dev.android.mobile.santos.applistacurso.controller.CursoController;
import dev.android.mobile.santos.applistacurso.controller.PessoaController;
import dev.android.mobile.santos.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;
    CursoController cursoController;

    Pessoa pessoa;
    Pessoa outraPessoa;
    List<String> nomesDoCurso;

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editCursoDesejado;
    EditText editTelefoneContato;

    Button btn_Salvar;
    Button btn_Limpar;
    Button btn_Finalizar;

    Spinner spinner;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        controller = new PessoaController(MainActivity.this);
        controller.toString();

        cursoController = new CursoController();

        nomesDoCurso = cursoController.dadosSpinner();

        outraPessoa = new Pessoa();
        controller.procurar(outraPessoa);

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCursoDesejado = findViewById(R.id.editCursoDesejado);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        spinner = findViewById(R.id.spinnerCurso);

        btn_Limpar = findViewById(R.id.btnLimpar);
        btn_Salvar = findViewById(R.id.btnSalvar);
        btn_Finalizar = findViewById(R.id.btnFinalizar);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cursoController.dadosSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);

        editPrimeiroNome.setText(outraPessoa.getPrimeiroNome());
        editSobrenome.setText(outraPessoa.getSegundoNome());
        editCursoDesejado.setText(outraPessoa.getCursoDesejado());
        editTelefoneContato.setText(outraPessoa.getTelefoneContato());

        btn_Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Informacoes Limpadas", Toast.LENGTH_LONG).show();
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editCursoDesejado.setText("");
                editTelefoneContato.setText("");
                controller.limpar();
            }
        });

        btn_Finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte sempre!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btn_Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                outraPessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                outraPessoa.setSegundoNome(editSobrenome.getText().toString());
                outraPessoa.setCursoDesejado(editCursoDesejado.getText().toString());
                outraPessoa.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Dados salvos com sucesso" + outraPessoa.toString(), Toast.LENGTH_LONG).show();

                controller.salvar(outraPessoa);
            }
        });

        Log.i("POOAndroid", outraPessoa.toString());
    }
}