package devandroid.glaucomv.apptesteparalistavip.controller;

import android.content.SharedPreferences;

import devandroid.glaucomv.apptesteparalistavip.model.Pessoa;
import devandroid.glaucomv.apptesteparalistavip.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listateste;
    public static final String NOME_PREFERENCES = "pref_testelistavip";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listateste = preferences.edit();


    }

    public void limpar() {

        listateste.clear();
        listateste.apply();

    }

    public void salvar(Pessoa pessoa) {
        listateste.putString("Nome", pessoa.getNome());
        listateste.putString("Sobrenome", pessoa.getSobrenome());
        listateste.putString("Parentesco", pessoa.getParentesco());
        listateste.putString("Telefone", pessoa.getTelefone());
        listateste.apply();


    }

    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setNome(preferences.getString("Nome", "NA"));
        pessoa.setSobrenome(preferences.getString("Sobrenome", "NA"));
        pessoa.setParentesco(preferences.getString("Parentesco", "NA"));
        pessoa.setTelefone(preferences.getString("Telefone", "NA"));

        return pessoa;

    }

    public void finalizar() {
    }

}
