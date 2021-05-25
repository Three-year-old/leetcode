package Math;

public class RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a = (C - A) * (D - B), b = (G - E) * (H - F);
        return a + b - overlap(A, C, E, G) * overlap(F, H, B, D);
    }

    private int overlap(int a, int b, int c, int d) {
        if (b <= c || d <= a) {
            return 0;
        }
        return Math.min(b, d) - Math.max(a, c);
    }
}
