package br.ufabc.edu.so.projetoFinal.escalonadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.ufabc.edu.so.projetoFinal.model.Processo;
import br.ufabc.edu.so.projetoFinal.model.ResultItem;
import br.ufabc.edu.so.projetoFinal.util.ToolsUtils;

public class EscalonadorSJFPreemptivo implements Escalonador {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultItem execute(List<Processo> processos) {
		int instante = 0;
        int numTrocas = 0;
        Map<String, Processo> diagrama = new LinkedHashMap<String, Processo>();
        Map<Processo, Integer> procTmpEspMap = new HashMap<Processo, Integer>();
        Map<Processo, Integer> procTmpRetMap = new HashMap<Processo, Integer>();
        
        /* tempoTotal guarda o tempo total que leva a execução de todos os processos
         * idProcAntigo guarda o id do último processo executado
         */
        int tempoTotal = 0, idProcAntigo = -1;
        
        //Guarda o ultimo instante que foi iniciada a execução de cada processo
        ArrayList<Integer> tempoInicio = new ArrayList<Integer>();
        
        //guarda o último instante que foi pausado cada processo
        ArrayList<Integer> tempoPausa = new ArrayList<Integer>();
        
        //inicia as variavel com valores padrões e pega tempo total dos processos
        for(Processo processo : processos){
            tempoTotal += processo.getDuracao();
            tempoInicio.add(0);
            tempoPausa.add(0);
        }
        
        //Enquanto não for o último instante do processo
        while(instante < tempoTotal){
            int menorDuracao = -1, idProc = 0;
            
            /*Procura pelo processo de menor duração e com entrada no instante meor ou igual o atual 
                e coloca na fila para ser executado primeiro*/
            for(int i = 0; i < processos.size(); i++){
                if(!processos.get(i).isFinished()){
                    if(processos.get(i).getHrCriacao() == instante || processos.get(i).getHrCriacao() < instante){
                        if(menorDuracao == -1){
                            menorDuracao = processos.get(i).getDuracao();
                            idProc = i;
                        }
                        else if(menorDuracao > processos.get(i).getDuracao()){
                            menorDuracao = processos.get(i).getDuracao();
                            idProc = i;
                        }
                    }
                }
            }
            
            //Se for o último instante pega os dados do último processo executado
            if(instante == tempoTotal - 1){
            	String key = tempoInicio.get(idProc) + "-" + (instante + 1);
            	diagrama.put(key, processos.get(idProc));
            	if(tempoPausa.get(idProc) == 0){
                    procTmpEspMap.put(processos.get(idProc), tempoInicio.get(idProc)- processos.get(idProc).getHrCriacao());
                }
                else{
                    procTmpEspMap.put(processos.get(idProc), tempoInicio.get(idProc) - (tempoPausa.get(idProc)));
                }
                procTmpRetMap.put(processos.get(idProc), instante);
                processos.get(idProc).setFinished(true);
            }
            
            //Se o processo tiver mudado guarda os dados do último processo e começa a execução do novo
            if(idProcAntigo != idProc){
            	
            	if(idProcAntigo != -1){
            		String key = tempoInicio.get(idProcAntigo) + "-" + instante;
                	diagrama.put(key, processos.get(idProcAntigo));
            	}
                numTrocas++;
                processos.get(idProc).setDuracao(processos.get(idProc).getDuracao() - 1);
                
                tempoInicio.set(idProc, instante);
                if(idProcAntigo != -1 && !processos.get(idProcAntigo).isFinished()){
                    tempoPausa.set(idProcAntigo, instante);
                }
                
                idProcAntigo = idProc;
                
                instante++;
            }
            
            //Senão verifica se o processo não acabou de executar e aumenta o instante
            else if(processos.get(idProc).getDuracao() != 0){
                processos.get(idProc).setDuracao(processos.get(idProc).getDuracao() - 1);
                instante++;
            }
            //senão o processo acabou de executar e tem todos os dados guardados
            else{
                if(tempoPausa.get(idProc) == 0){
                    procTmpEspMap.put(processos.get(idProc), tempoInicio.get(idProc)- processos.get(idProc).getHrCriacao());
                }
                else{
                    procTmpEspMap.put(processos.get(idProc), tempoInicio.get(idProc) - (tempoPausa.get(idProc)));
                }
                procTmpRetMap.put(processos.get(idProc), instante);
                processos.get(idProc).setFinished(true);
            }
           
        }
        
        
        float tmpMedioEsp = ToolsUtils.getTempoMedio(new ArrayList<Integer>(procTmpEspMap.values()));
        float tmpMediRetorno = ToolsUtils.getTempoMedio(new ArrayList<Integer>(procTmpRetMap.values()));
        return new ResultItem(tmpMedioEsp, tmpMediRetorno, numTrocas, diagrama);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "SJF Preemptivo";
	}

}