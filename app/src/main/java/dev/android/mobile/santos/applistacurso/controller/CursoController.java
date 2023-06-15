package dev.android.mobile.santos.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import dev.android.mobile.santos.applistacurso.model.Curso;

public class CursoController {
    private List listaCursos;

    public List getListaCursos(){
        listaCursos = new ArrayList<Curso>();

        listaCursos.add(new Curso("Profissionalizante"));
        listaCursos.add(new Curso("Tecnologo"));
        listaCursos.add(new Curso("Tecnico"));
        listaCursos.add(new Curso("Doutorado"));
        listaCursos.add(new Curso("Extra-Curricular"));
        listaCursos.add(new Curso("Mestrado"));
        listaCursos.add(new Curso("Graduação"));
        listaCursos.add(new Curso("Pós-Graduação"));

        return listaCursos;
    }

    public ArrayList<String> dadosSpinner(){
        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaCursos().size(); i++){
            Curso objeto = (Curso) getListaCursos().get(i);
            dados.add(objeto.getCursoDesejado());
        }
        return dados;
    }
}
