public class literal extends element {

    public short numericRep = 0;

    public int size = 1;

    @Override
    public void constructFromString(String toParse) {


        this.numericRep = (short) (32768 + Short.parseShort(toParse));



    }

    @Override
    public machineCode encodeByte(){

        machineCode buffer = new machineCode();

        buffer.val = new Short[]{this.numericRep};

        return buffer;
    }

}
