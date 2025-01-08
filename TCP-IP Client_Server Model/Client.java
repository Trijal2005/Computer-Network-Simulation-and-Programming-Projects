import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) throws IOException {
        BufferedReader keyRead;
        BufferedReader socketRead;
        PrintWriter pwrite;
        
        Socket socket=new Socket("127.1.0.0",5000);
        
        System.out.println("Enter file name:");
        keyRead=new BufferedReader(new InputStreamReader(System.in));
        String fname=keyRead.readLine();

        OutputStream ostream = socket.getOutputStream();
        pwrite = new PrintWriter(ostream,true);
        System.out.println();
        pwrite.println(fname);

        InputStream isteam = socket.getInputStream();
        socketRead= new BufferedReader(new InputStreamReader(isteam));

        String str;
        while((str=socketRead.readLine())!=null){
            System.out.println(str);
        }

        keyRead.close();
        socket.close();
        socketRead.close();

    }

}
