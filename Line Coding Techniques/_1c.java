class _1c{
    public static void main(String args[]){
        String data="1010";
        String encoded=encode(data);
        System.err.println("Manchester : "+encoded);
    }
    public static String encode(String data){
        StringBuilder en=new StringBuilder();
        for(char bit:data.toCharArray()){
            if(bit=='1'){
                en.append(" 10 ");
            }
            else{
                en.append((" 01 "));
            }
        }
        return en.toString();
    }
}