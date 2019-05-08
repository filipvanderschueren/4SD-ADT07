package be.uantwerpen.fti;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        //inlezen van gegevens
        InlezenGegevens gegevens = new InlezenGegevens();
        String filename = "C:/javaprograms/4SD-ADT07/data.txt";

        try {
            gegevens.readData(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("output: "+ gegevens);

    }
}
