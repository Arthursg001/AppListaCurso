package dev.android.mobile.santos.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

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

    EditText edit_PrimeiroNome;
    EditText edit_SegundoNome;
    EditText edit_CursoDesejado;
    EditText edit_TelefoneContato;

    Button btn_Salvar;
    Button btn_Limpar;
    Button btn_Finalizar;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new PessoaController(MainActivity.this);
        controller.toString();

        cursoController = new CursoController();

        nomesDoCurso = cursoController.dadosSpinner();

        outraPessoa = new Pessoa();
        controller.procurar(outraPessoa);

        edit_PrimeiroNome = findViewById(R.id.edit_PrimeiroNome);
        edit_SegundoNome = findViewById(R.id.edit_SegundoNome);
        edit_CursoDesejado = findViewById(R.id.edit_CursoDesejado);
        edit_TelefoneContato = findViewById(R.id.edit_TelefoneContato);

        spinner = findViewById(R.id.spinnerCursos);

        btn_Limpar = findViewById(R.id.btn_Limpar);
        btn_Salvar = findViewById(R.id.btn_Salvar);
        btn_Finalizar = findViewById(R.id.btn_Finalizar);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cursoController.dadosSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);

        edit_PrimeiroNome.setText(outraPessoa.getPrimeiroNome());
        edit_SegundoNome.setText(outraPessoa.getSegundoNome());
        edit_CursoDesejado.setText(outraPessoa.getCursoDesejado());
        edit_TelefoneContato.setText(outraPessoa.getTelefoneContato());

        btn_Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Informacoes Limpadas", Toast.LENGTH_LONG).show();
                edit_PrimeiroNome.setText("");
                edit_SegundoNome.setText("");
                edit_CursoDesejado.setText("");
                edit_TelefoneContato.setText("");
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
                outraPessoa.setPrimeiroNome(edit_PrimeiroNome.getText().toString());
                outraPessoa.setSegundoNome(edit_SegundoNome.getText().toString());
                outraPessoa.setCursoDesejado(edit_CursoDesejado.getText().toString());
                outraPessoa.setTelefoneContato(edit_TelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Dados salvos com sucesso" + outraPessoa.toString(), Toast.LENGTH_LONG).show();

                controller.salvar(outraPessoa);
            }
        });

        Log.i("POOAndroid", outraPessoa.toString());
    }
}