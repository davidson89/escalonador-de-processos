package br.ufabc.edu.so.projetoFinal.escalonadores;

import java.io.File;
import java.util.List;

import br.ufabc.edu.so.projetoFinal.model.Processo;

public interface Escalonador {
	
	public File execute(List<Processo> processos);

}
