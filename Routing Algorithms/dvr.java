import java.util.Arrays;
public class dvr {
    static int INF=9999;

    public static void S_DVR(int g[][]){
        int n=g.length;
        int dist[][]=new int[n][n];
        for(int i=0;i<n;i++){
            dist[i]=Arrays.copyOf(g[i], n);
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if((dist[i][k]+dist[k][j])<dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            System.err.println("Router "+(i)+" Distance to "+Arrays.toString(dist[i]));
        }
    }

    public static void main(String args[]){
        int g[][]={{0,4,INF,3},{4,0,1,INF},{INF,1,0,3},{3,INF,2,0}};
        S_DVR(g);
    }
}
