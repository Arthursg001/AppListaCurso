package dev.android.mobile.santos.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import dev.android.mobile.santos.applistacurso.model.Pessoa;
import dev.android.mobile.santos.applistacurso.view.MainActivity;

public class PessoaController {
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    public void salvar(Pessoa outraPessoa) {
        Log.d("MVC_Controller", "Salvo: " + outraPessoa.toString());
        listaVip.putString("PrimeiroNome", outraPessoa.getPrimeiroNome());
        listaVip.putString("Sobrenome", outraPessoa.getSegundoNome());
        listaVip.putString("NomeCurso", outraPessoa.getCursoDesejado());
        listaVip.putString("TelefoneContato", outraPessoa.getTelefoneContato());
        listaVip.apply();

    }

    public Pessoa procurar(Pessoa outraPessoa){
        outraPessoa.setPrimeiroNome(preferences.getString("PrimeiroNome",""));
        outraPessoa.setSegundoNome(preferences.getString("Sobrenome", ""));
        outraPessoa.setCursoDesejado(preferences.getString("NomeCurso", ""));
        outraPessoa.setTelefoneContato(preferences.getString("TelefoneContato", ""));
        return outraPessoa;
    }

    public void limpar(){
        listaVip.clear();
        listaVip.apply();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciada...");
        return super.toString();
    }
}
