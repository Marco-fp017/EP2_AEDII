package ep2_aed_ii;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import services.DistribuicaoGraus;
import services.IDs;

public class EP2_AED_II {
    
    public static void main(String[] args) {
        List<IDs> IDList = new ArrayList<>(); //lista de IDs
        List<DistribuicaoGraus> distGraus = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o caminho de entrada do arquivo a ser lido: ");
        //Lendo o arquivo .csv contendo as informações das viagens
        try (BufferedReader bf = new BufferedReader (new FileReader(sc.nextLine()))){
            String aux = bf.readLine(); // linha com número de ids 
            aux = bf.readLine();        // linha com numero de encontros
            aux = bf.readLine();

            while(aux != null){
                String[] line = aux.split(" ");
                
                IDs id1 = new IDs(Integer.parseInt(line[0]));
                IDs id2 = new IDs(Integer.parseInt(line[1]));

                if (!IDList.contains(id1)){ //id não existe na lista de IDs
                    IDList.add(id1);
                    id1.inserirNo(id2);
                } else{//id existe, preciso localizá-lo p/ adicionar o outro id na lista de adjacência
                    for (IDs auxId : IDList){
                        if(auxId.equals(id1)){
                            auxId.inserirNo(id2);
                            break;
                        }
                    }
                }
                
                if (!IDList.contains(id2)){ //id não existe na lista de IDs
                    IDList.add(id2);
                    id2.inserirNo(id1);
                } else{//id existe, preciso localizá-lo p/ adicionar o outro id na lista de adjacência
                    for (IDs auxId : IDList){
                        if(auxId.equals(id2)){
                            auxId.inserirNo(id1);
                            break;
                        }
                    }
                }
                aux = bf.readLine();
            }
            for(IDs ids : IDList){
                ids.setTamanhoDaLista(ids.tamanhoPilha()); //o tamanho da lista é o número de encontros que determinado id teve
                boolean tamExist = false;
                for(DistribuicaoGraus d : distGraus){
                    if(d.getNumeroEncontros() == ids.getTamanhoDaLista()){
                        d.incrementaEncontros();
                        tamExist = true;
                        break;
                    }
                }
                if(tamExist == false){ //não existe um id com o número de encontros atual
                    distGraus.add(new DistribuicaoGraus(ids.getTamanhoDaLista()));
                }
            }           
            
            System.out.print("Informe o caminho de saída: ");
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(sc.nextLine()))){
                int tamList = 0;
                for(IDs ids : IDList) tamList += ids.tamanhoPilha();
                bw.write(Integer.toString(tamList/2));
                bw.newLine();
/*                for(IDs ids : IDList){
                    bw.write(ids.getId() + "," + ids.tamanhoPilha());
                    bw.newLine();
                } 
*/
                for(DistribuicaoGraus d : distGraus){
                    bw.write(Integer.toString(d.getNumeroEncontros()) + "," + Integer.toString(d.getQuantidadeEncontros()));
                    bw.newLine();
                }
}
        }catch (IOException e){
            e.getMessage();
            e.printStackTrace();
        }
    }
    //C:\\Users\\marco\\Desktop\\OD_graph.txt
    //C:\\Users\\marco\\Desktop\\out\\summary4.txt  
    //86318 / 
}
