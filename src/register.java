public class register extends element {

    public short numericRep;

    public int size = 1;

    @Override
    public void constructFromString(String toParse) {


        this.numericRep = Short.parseShort(toParse);



    }

    @Override
    public machineCode encodeByte(){

        machineCode buffer = new machineCode();

        buffer.val = new Short[]{this.numericRep};

        return buffer;
    }

}
