import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        exampleArrayTeapots1();
        exampleArrayRectangles1();
        exampleArrayTeapots2();

    }

    private static void exampleArrayTeapots2() {
        Teapot[] array = new Teapot[]{  new Teapot(1, "blue"),
                new Teapot(1.1, "white"),
                new Teapot(2.5, "white"),
                new Teapot(3, "green")
        };

        Teapot toFind = new Teapot(2.5, "white");

        int k3 = Arrays.stream(array).toList().indexOf(toFind);
        System.out.println("k3 = " + k3);


        int kolvo = (int) Arrays.stream(array).distinct().count();
        System.out.println("kolvo = " + kolvo);
    }

    private static void exampleArrayRectangles1() {
        Rectangle[] array2 = new Rectangle[]{new Rectangle(10, 15),
                                             new Rectangle(25, 25),
                                             new Rectangle(16, 20),
                                             new Rectangle(15, 10)};  
        Rectangle toFind = new Rectangle(10, 15);
        
        int kr = findRectangle(array2, toFind);
        System.out.println("kr = " + kr);
    }

    private static void exampleArrayTeapots1() {
        Teapot[] array = new Teapot[]{  new Teapot(1, "blue"),
                new Teapot(1.1, "white"),
                new Teapot(2.5, "white"),
                new Teapot(3, "green")
        };

        Teapot toFind = new Teapot(2.5, "white");
        //как найти номер чайника toFind в массиве array ?
        int k = indexOfTeapot(array, toFind);       //самописный метод
        System.out.println("k = " + k);
        int k2 = findTeapot(array, toFind);
        System.out.println("k2 = " + k2);
    }

    public static int findTeapot(Teapot[] array, Teapot toFind) {
        int k2=0;
        while (k2< array.length){
            if(array[k2].equals(toFind))
                break;
            k2++;
        }
        return k2;
    }

    public static int indexOfTeapot(Teapot[] mas, Teapot x){
        for (int i=0; i< mas.length; i++)
            //if(mas[i] == x)
            if(Objects.equals(mas[i].color, x.color) && mas[i].volume == x.volume)
                return i;
        return -1;
    }

    public static int findRectangle(Rectangle[] array, Rectangle toFind) {
        int i=0;
        while (i< array.length){
            if(array[i].equals(toFind))
                return  i;
            i++;
        }
        return -1;
    }
    
    public static int countDistinctTeapots(Teapot[] array){
        int result=0;
        for (int i =0; i<array.length; i++){
            boolean isUnique= true;
            for (int j = i+1; j < array.length; j++) {
                if(array[i].equals(array[j])){
                    isUnique = false;
                    break;
                }                    
            }
            if(isUnique)
                result++;
        }
        return result;
    }
}