import java.util.Map;

class opCodes extends element{




    public static Map<String, Short> operationalCodes = Map.of(

            "mov",  (short) 128, "add", (short) 128, "jmp", (short) 192

    );


    argument[] val = new argument[3];

    Short[] code = new Short[] {0};

    public int size;

    @Override
    public void constructFromString(String toParse) {

        String[] components = toParse.split(" ");

        for (int i = 2; i >= 0; i--) {this.val[i] = new argument();}; //init all

        for (int i = components.length - 1; i >= 1; i--){

            this.val[i + 1].constructFromString(components[i]);

        }

        this.code =new Short[] { operationalCodes.get(components[0])};

        if (this.val[2].data instanceof literal) {
            System.err.println("destination cannot be literal");
            System.exit(1);
        }

    }

    @Override
    public machineCode encodeByte() {


        machineCode[] initBuffer = new machineCode[3];

        for (int i = 2; i >= 0; i--) {

            initBuffer[i] = this.val[i].encodeByte();

        }

        machineCode initOp = new machineCode();

        initOp.val = this.code;

        machineCode concat = initOp.concatInits(initBuffer[0].concatInits(initBuffer[1].concatInits(initBuffer[2])));

        machineCode concatBuffer = new machineCode();

        concatBuffer.initialCode = concat.val;

        concat = concat.concatInits(concatBuffer);

        concat.val = new Short[0];

        this.size = concat.initialCode.length;

        return concat;

    }

}
