public class argument extends element {

    public element data = new literal();

    @Override
    public void constructFromString(String toParse) {

        String parsed = toParse;

        this.data = new literal(); //add other stuff

        if (toParse.length() >= 3) {

            String firstThreeChars = toParse.substring(0, 3);

            if (firstThreeChars.equals("reg")) {

                parsed = toParse.substring(3);

                this.data = new register();

            }


        }


        this.data.constructFromString(parsed);

        this.size = this.data.size;

    }

    public machineCode encodeByte(){

        return this.data.encodeByte();
    }

}
