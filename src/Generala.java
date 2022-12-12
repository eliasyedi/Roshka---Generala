

import java.util.ArrayList;


public class Generala {
    static private ArrayList<Integer> tablaRecurrencia = new ArrayList<Integer>(6);

    public String jugada(ArrayList<Integer> dados){

        if(dados.size() != 5)
            return "invalido"

        generateTable(dados);

        if(generala())
            return "GENERALA";
        if(poker())
            return "POKER";
        if(full())
            return "FULL";
        if(escalera(dados))
            return "ESCALERA";

        return "NADA";
    }

    static private void generateTable(ArrayList<Integer> dados){
        for(int i = 0 ; i<6 ;i++)
            tablaRecurrencia.add(i, 0);

        for(Integer dado : dados)
            for(Integer recurrencia: dados)
                if(dado.compareTo(recurrencia) == 0)
                    tablaRecurrencia.add(tablaRecurrencia.get(dado-1)+1);
    }
    static private boolean generala(){
        for(Integer recurrencia: tablaRecurrencia)
            if(recurrencia == 5)
                return true;

        return false
    }


    static private boolean poker(){
        for(Integer recurrencia : tablaRecurrencia)
            if(recurrencia == 4)
                return true;

        return false;
    }
    static private boolean full(){
        Integer recurrencia1 = null;
        Integer recurrencia2 = null;
        for(int i = 0 ; i<6 ; i++){
            recurrencia1 = tablaRecurrencia.get(i);
            for(int j = 0 ; j<6 ; j++){
                recurrencia2 = tablaRecurrencia.get(j);
                if(!recurrencia1.equals(recurrencia2)){
                    if((recurrencia1 == 3 && recurrencia2 ==2) || (recurrencia1 == 2 && recurrencia2 ==3))
                        return true;
                }
            }
        }
        return false;
    }


    static private boolean escalera(ArrayList<Integer> dados){
        int menor = dados.get(0).intValue();
        for(Integer dado: dados)
            if(dado.intValue() < menor)
                menor = dado.intValue();

        int index = menor-1;
        for(int i = 0 ; i<5 ; i++ )
            if(tablaRecurrencia.get(index+1)!=1)
                return false;

        return true;
    }


}
