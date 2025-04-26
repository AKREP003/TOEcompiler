import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        element test = new opCodes();

        test.constructFromString("jmp reg256");

        String fileName = "simple.bin";

        Short[] data = test.encodeByte().initialCode;


        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {

            for (short value : data) {

                System.out.println(value);

                dos.writeShort(value);

            }

            System.out.println("Short data has been written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}