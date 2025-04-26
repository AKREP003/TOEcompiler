import java.util.Arrays;

public class machineCode {

    public Short[] initialCode = new Short[] {};
    public Short[] val = new Short[] {0};

    public machineCode concatInits( machineCode x2) {

        Short[] initBuffer = Arrays.copyOf(this.initialCode, this.initialCode.length + x2.initialCode.length);
        System.arraycopy(x2.initialCode, 0, initBuffer, this.initialCode.length, x2.initialCode.length);

        Short[] valBuffer = Arrays.copyOf(this.val, this.val.length + x2.val.length);
        System.arraycopy(x2.val, 0, valBuffer, this.val.length, x2.val.length);

        machineCode buffer = new machineCode();
        
        buffer.initialCode = initBuffer;
        buffer.val = valBuffer;        
        
        return buffer;

    }


}
