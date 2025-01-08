import java.util.Scanner;
public class Bellman2 {
    public static void bellmanFord(int g[][],int V,int E,int src){
        int dist[]=new int[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;

        for(int i=0;i<V-1;i++){
            for(int j=0;j<E;j++){
                int u=g[j][0];
                int v=g[j][1];
                int w=g[j][2];

                if(dist[u]!=Integer.MAX_VALUE && (dist[u]+w)<dist[v]){
                    dist[v]=dist[u]+w;
                }
            }
        }

        for(int j=0;j<E;j++){
            int u=g[j][0];
            int v=g[j][1];
            int w=g[j][2];

            if(dist[u]!=Integer.MAX_VALUE && (dist[u]+w)<dist[v]){
                System.out.println("Negative Cycle");
            }

        }

        System.out.println("Vertex Distance");
        for(int i=0;i<V;i++){
            System.out.println(i+"\t\t"+dist[i]);
        }
    }

    public static void main(String args[]){
        int V,E,src;
        System.err.println("Enter no.of edges(2) and vertex(1):");
        Scanner scan=new Scanner(System.in);
        V=scan.nextInt();
        E=scan.nextInt();
        int g[][]=new int [E][3];
        System.err.println("Enter The S D W");
        for(int i=0;i<E;i++){
            System.err.println("Edge: "+(i+1));
            g[i][0]=scan.nextInt();
            g[i][1]=scan.nextInt();
            g[i][2]=scan.nextInt();
        }
        System.err.println("Enter Source:");
        src=scan.nextInt();

        bellmanFord(g, V, E, src);

        scan.close();
        


    }

}
