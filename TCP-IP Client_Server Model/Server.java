import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) throws IOException {
        BufferedReader fileRead;
        BufferedReader contentRead;
        PrintWriter pwrite;
        ServerSocket sersock=new ServerSocket(5000);
        System.out.println("Ready for Connection Server");

        Socket sock=sersock.accept();
        System.out.println("Connection Establised");

        InputStream istream =sock.getInputStream();
        fileRead=new BufferedReader(new InputStreamReader(istream));
        String fname=fileRead.readLine();

        contentRead=new BufferedReader(new FileReader(fname));
        OutputStream ostream=sock.getOutputStream();
        pwrite=new PrintWriter(ostream,true);

        String str;
        while((str=contentRead.readLine())!=null){
            pwrite.println(str);
        }


        sersock.close();
        sock.close();
        contentRead.close();
        fileRead.close();
        pwrite.close();
    }
}
