

import java.util.ArrayList;


public class Generala {
    static private ArrayList<Integer> tablaRecurrencia = new ArrayList<Integer>(6);

    public static String jugada(ArrayList<Integer> dados){

        if(dados.size() != 5)
            return "invalido";

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
            tablaRecurrencia.add(0);

        for(int dado = 1 ; dado<6 ; dado++)
            for(Integer recurrencia: dados)
                if(dado == recurrencia.intValue())
                    tablaRecurrencia.set(dado-1,tablaRecurrencia.get(dado-1)+1);

    }
    static private boolean generala(){
        for(Integer recurrencia: tablaRecurrencia)
            if(recurrencia == 5)
                return true;

        return false;
    }


    static private boolean poker(){
        for(Integer recurrencia : tablaRecurrencia)
            if(recurrencia == 4)
                return true;

        return false;
    }
    static private boolean full(){
       // Integer recurrencia1 = null;//Integer recurrencia2 = null;

        for(Integer recurrencia1 : tablaRecurrencia )
            if(recurrencia1 == 3 )
                for(Integer recurrencia2: tablaRecurrencia)
                    if(recurrencia2 == 2)
                        return true;

        return false;

    }


    static private boolean escalera(ArrayList<Integer> dados){
        int menor = dados.get(0).intValue();
        for(Integer dado: dados)
            if(dado.intValue() < menor)
                menor = dado.intValue();

        System.out.println();
        System.out.println(menor);
        int index = menor-1;
        for(int i = 0 ; i<5 ; i++ ){
            if(tablaRecurrencia.get(index).intValue()!=1)
                return false;
            index++;
        }

        return true;
    }


}
