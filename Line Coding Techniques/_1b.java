public class _1b {
    public static void main(String args[]){
        String data="1010";
        int encoded[]=encode(data);
        System.err.println("Encoded data");
        for(int x:encoded){
            System.err.println(x);
        }
    }
    public static int[] encode(String data){
        int en[]=new int[data.length()];
        for (int i=0;i<data.length();i++){
            en[i]=(data.charAt(i)=='1'?1:-1);
        }
        return en;
    }
}
