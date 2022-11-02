/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author igor_
 */
public class Processo {
    public int identificador;
    public int tempoProcessado;
    public int tempoTotalExuc;
    public int contadorPrograma;
    public int estadoProcesso; //0 = pronto, 1 = executando, 2 = bloqueado
    public int numES;
    public int numCPU;

    
    public Processo(int identificador, int tempoTotalExuc){
        this.identificador = identificador;
        this.tempoProcessado = 0;
        this.tempoTotalExuc = tempoTotalExuc;
        this.contadorPrograma = this.tempoProcessado +1;
        this.estadoProcesso = 0;
        this.numCPU = 0;
        this.numES = 0;
    }
    
    public void infos(){
        System.out.println("=================================\nProcess: "+this.identificador);
        System.out.println("Tempo processado: "+this.tempoProcessado);
        System.out.println("Tempo total execução: "+this.tempoTotalExuc);
        System.out.println("Contador do programa: "+this.contadorPrograma);
        System.out.println("Estado do processo: "+this.estadoProcesso);
        System.out.println("Numero de E/S: "+this.numES);
        System.out.println("Vezes que entrou na CPU: "+this.numCPU);
    }
}