import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> dados = getRandom();

        System.out.print("dados: " + dados);

        System.out.println(Generala.jugada(dados));
    }


    static public ArrayList<Integer> getRandom(){
        ArrayList <Integer> dados = new ArrayList<Integer>(5);
        for(int i = 0 ; i<5 ; i++)
            dados.add(i , (int)(Math.random()*5+1));

        return dados;
    }



}