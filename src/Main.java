import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws IOException {

        for (; ; ) {
            System.out.println("please type address of folder to get its size");
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();

            Path folder = Paths.get(path);

            long size = Files.walk(folder)
                    .filter(p -> p.toFile().isFile())
                    .mapToLong(p -> p.toFile().length())
                    .sum();

            getFormatAndUnit(size);

        }
    }


    public static void  getFormatAndUnit (long size )  {

        double grade = Math.log10(size)/Math.log10(1024.0);

                                if (grade < 1)  {  System.out.printf("%1$2.2f%2$s", (float) size, " bytes \n");}
            else if (grade >= 1 && grade < 2 )  {  System.out.printf("%1$2.2f%2$s", size/1024.0, " kb \n"); }
            else if (grade >= 2 && grade < 3 )  {  System.out.printf("%1$2.2f%2$s", size/(1024.0*1024.0), " mb \n"); }
            else if (grade >= 3 && grade < 4 )  {  System.out.printf("%1$2.2f%2$s", size/Math.pow(1024.0, 3.0), " gb \n"); }
                                          else  {  System.out.printf("%1$2.2f%2$s", size/Math.pow(1024.0, 4.0), " tb \n"); }
        }

    }





