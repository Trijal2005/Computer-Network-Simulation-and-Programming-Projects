import java.util.Arrays;
public class lsr {
    static int inf=9999;
    public static void dij(int g[][],int src){
        int n=g.length;
        int dist[]=new int[n];
        boolean vis[]=new boolean[n];

        Arrays.fill(dist, inf);

        dist[src]=0;

        for(int i=0;i<(n-1);i++){
            int u=minD(dist,vis);
            vis[u]=true;

            for(int v=0;v<n;v++){
                if(!vis[v] && g[u][v]!=inf && ((dist[u]+g[u][v])<dist[v])){
                    dist[v]=dist[u]+g[u][v];
                }
            }

        }

        System.out.println("Router "+src+" Distance to "+Arrays.toString(dist));
    }

    public static int minD(int dist[],boolean vis[]){
        int min=inf;
        int minI=-1;
        for(int i=0;i<dist.length;i++){
            if(!vis[i] && dist[i]<=min){
                min=dist[i];
                minI=i;
            }
        }
        return minI;

    }

    public static void main(String args[]){
        int g[][]={{0,4,inf,3},{4,0,1,inf},{inf,1,0,3},{3,inf,2,0}};
        for(int i=0;i<g.length;i++){
            dij(g, i);
        }

    }
}
