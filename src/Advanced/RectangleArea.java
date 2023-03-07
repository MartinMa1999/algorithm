package Advanced;

public class RectangleArea {
    // Find the total area covered by two rectilinear rectangles in a 2D plane.

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a = (C - A) * (D - B);
        int b = (G - E) * (H - F);
        if(E > C || A > G || B > H || F > D){
            return a + b;
        }
        int length = 0;
        int height = 0;

        if(A < E && E < C && C < G){
            length = C - E;
        }
        else if(E < A  && A < G && G < C){
            length = G - A;
        }
        else{
            length = Math.min(G - E, C - A);
        }

        if(D > H && H > B && B > F){
            height = H - B;
        }
        else if(H > D && D > F && F > B){
            height = D - F;
        }
        else{
            height = Math.min(D - B, H - F);
        }


        return a + b - length * height;


    }
}
