import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class cat {
    public static void main(String[] args) {
        long czas = System.nanoTime();
int powtórzenie = 10000;
        int x = 5;
        int y = 0;
        czas = System.nanoTime();
        for(int i=0;i<powtórzenie;i++)
        dzielenie(x,y);


        System.out.println("Try catch, dzielenie przez 0");
        System.out.println(System.nanoTime()-czas);
        czas = System.nanoTime();
        for(int i=0;i<powtórzenie;i++)
            try {

                dzielenieThrows(x,y);

            } catch(ArithmeticException e) {
            }
        System.out.println("Throws, dzielenie przez 0");
        System.out.println(System.nanoTime()-czas);



        int [] tab = new int[10];
        for(int i=0;i<powtórzenie;i++)
            xindeksTablicy(tab);
        System.out.println("Try catch, przekroczenie zakresu");

        System.out.println(System.nanoTime() - czas);



        czas = System.nanoTime();
        for(int i=0;i<powtórzenie;i++)
            try{
                xindeksTablicyThrows(tab);
            }catch (ArrayIndexOutOfBoundsException e){


            }
        System.out.println("Throws, przekroczenie zakresu");

        System.out.println(System.nanoTime()-czas);



        czas = System.nanoTime();
        for(int i=0;i<powtórzenie;i++)
            czytaj();
        System.out.println("Try catch, plik");

        System.out.println(System.nanoTime()-czas);



        czas = System.nanoTime();
        for(int i=0;i<powtórzenie;i++)
            try(ObjectInputStream is = new ObjectInputStream((new FileInputStream("plik.txt")))) {
                czytajThrows(is);
            } catch (IOException |ClassNotFoundException e) {
            }

        System.out.println("Throws, plik");

        System.out.println(System.nanoTime() - czas);}


    public static void xindeksTablicy(int[] tab){
        try{
            tab[55] = 18;
        }catch(ArrayIndexOutOfBoundsException e){}



    }
    public  static void dzielenieThrows(int x,int y) throws ArithmeticException{
        int divide = x / y;
    }

    public static void dzielenie(int x, int y){
        try{

            int divide = x / y;

        } catch(ArithmeticException e){


    }}


    public static void xindeksTablicyThrows(int[] tab ) throws ArrayIndexOutOfBoundsException{
        tab[22] = 7;
    }

    public static void czytajThrows(ObjectInputStream is) throws IOException, ClassNotFoundException {
        is.readObject();
    }

    public static void czytaj(){
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("plik.txt"))) {
            is.readObject();

        } catch (ClassNotFoundException | IOException e) {

        }
    }

}