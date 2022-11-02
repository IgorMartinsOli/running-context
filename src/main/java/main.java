
import java.util.ArrayList;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author igor_
 */
public class main {
    public static void main(String[] args) {
        Random gerador = new Random();
        var processos = new ArrayList<Processo>();
        
        processos.add(new Processo(0, 10000));
        processos.add(new Processo(1, 5000));
        processos.add(new Processo(2, 7000));
        processos.add(new Processo(3, 3000));
        processos.add(new Processo(4, 3000));
        processos.add(new Processo(5, 8000));
        processos.add(new Processo(6, 2000));
        processos.add(new Processo(7, 5000));
        processos.add(new Processo(8, 4000));
        processos.add(new Processo(9, 10000));
        
        int processoAtual = -1;
        
        do{
            
            //seleciona o processo atual;
            processoAtual++;
            //verfica se ja correu o numero de processos e reinicia a fila
            if(processoAtual > processos.size()-1){
                processoAtual = 0;
            }
            
            //caso ele nao esteja como bloqueado executa o quantum, se estiver bloqueado cai para a logica da chance de 30%
            if(processos.get(processoAtual).estadoProcesso != 2){
                //altera o estado para executando
                processos.get(processoAtual).estadoProcesso = 1;

                //adiciona 1 ao total de vezes que passou pelo processamento
                processos.get(processoAtual).numCPU++;

                int oldEstate = processos.get(processoAtual).estadoProcesso;
                //quantum
                for(int i = 0;i <= 1000; i++){
                    
                    int target = gerador.nextInt(101);
                    for(int j = 0; j <= 5; j++){
                        int random = gerador.nextInt(101);
                        if(target == random){
                            processos.get(processoAtual).estadoProcesso = 2;
                            processos.get(processoAtual).numES++;
                            i = 1001;
                        }else{
                            if(processos.get(processoAtual).tempoProcessado < processos.get(processoAtual).tempoTotalExuc){
                                processos.get(processoAtual).tempoProcessado++;
                            }else{
                                processos.get(processoAtual).estadoProcesso = 0;
                                processos.get(processoAtual).infos();
                                processos.remove(processoAtual);
                            }
                        }
                    }
                }
                
                //altera o processo para pronto caso esteja diferente de bloqueado
                if(processos.get(processoAtual).estadoProcesso !=2){
                    processos.get(processoAtual).estadoProcesso = 0;
                }
                
            }else{
                int target = gerador.nextInt(101);
                for(int i = 0; i <= 30; i++){
                    int random = gerador.nextInt(101);
                    if(target == random){
                        processos.get(processoAtual).estadoProcesso = 0;
                    }
                }
            }
            
        }while(!processos.isEmpty());
    }
}