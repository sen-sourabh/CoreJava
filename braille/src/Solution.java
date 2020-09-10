
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Enter string : ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int strlen = str.length();
        int ar[] = new int[6];
        int h = 0, i = 0, j = 0, k = 0, b = 0, c = 0, upperLetter = 0;
        char[] a = new char[strlen];
        for(i = 0; i < strlen; i++) {
            a[i] = str.charAt(i);
        }
        while(h < strlen) {
            if(h == 0 && upperLetter == 0) {
                if(Character.isUpperCase(a[h])) {
                    upperLetter++;
                }
            }
            if(a[h] == 's' || a[h] == 'S') {
//                b = 011100;
                ar = new int[]{0,1,1,1,0,0};
            } else if (a[h] == 'w' || a[h] == 'W') {
//                b = 010111;
                ar = new int[]{0,1,0,1,1,1};
            } else if(a[h] == 't' || a[h] == 'T') {
//                b = 011110;
                ar = new int[]{0,1,1,1,1,0};
            } else if(a[h] == 'j' || a[h] == 'J') {
//                b = 010110;
                ar = new int[]{0,1,0,1,1,0};
            } else if(a[h] == 'i' || a[h] == 'I') {
//                b = 010100;
                ar = new int[]{0,1,0,1,0,0};
            } else if (a[h] == ',') {
                ar = new int[]{0,1,0,0,0,0};
            } else if (a[h] == ';') {
                ar = new int[]{0,1,1,0,0,0};
            } else if (a[h] == ':') {
                ar = new int[]{0,1,0,0,1,0};
            } else if (a[h] == '.') {
                ar = new int[]{0,1,0,0,1,1};
            } else if (a[h] == '!') {
                ar = new int[]{0,1,1,0,1,0};
            } else if (a[h] == '(') {
                ar = new int[]{0,1,1,0,1,1};
            } else if (a[h] == ')') {
                ar = new int[]{0,1,1,0,1,1};
            } else if (a[h] == '?') {
                ar = new int[]{0,1,1,0,0,1};
            } else if (a[h] == '"') {
                ar = new int[]{0,0,1,0,1,1};
            } else if (a[h] == '-') {
                ar = new int[]{0,0,1,0,0,1};
            } else {
                b = getCode(a[h]);
                while(c < 6) {
                    ar[c] = b % 10;
                    b /= 10;
                    c++;
                }
                ar = reverse(ar, c);
            }
            if(h == 0 && upperLetter == 1){
                System.out.print("000001");
            }
            for(i=0;i<2;i++) {
                for(j=0;j<3;j++) {
                    if(i==1) {
                        k=i+j+2;
                    } else {
                        k=j;
                    }
                    if(ar[k] == 1) {
//                        System.out.print("•");
                        System.out.print("1");
                    } else {
                        System.out.print("0");
//                        System.out.print(".");
                    }
                }
//                System.out.print("\n");
            }
            h++;c=0;
        }
    }
    
    public static int[] reverse(int a[], int size) 
    { 
        int[] arr = new int[size]; 
        int z = size; 
        for (int i = 0; i < size; i++) { 
            arr[z - 1] = a[i]; 
            z = z - 1; 
        }
        return arr;
    }
    
    public static int getCode(char character) {
        switch(character) {
            case ' ':
                int space = 000000;
                return space;
            
            case 'a':
                int a = 100000;
                return a;
                
            case 'A':
                int A = 100000;
                return A;
                    
            case 'b':
                int b = 110000;
                return b;
                    
            case 'B':
                int B = 110000;
                return B;
                    
            case 'c':
                int c = 100100;
                return c;
                    
            case 'C':
                int C = 100100;
                return C;
                        
            case 'd':
                int d = 100110;
                return d;
                    
            case 'D':
                int D = 100110;
                return D;
                        
            case 'e':
                int e = 100010;
                return e;
                    
            case 'E':
                int E = 100010;
                return E;
                        
            case 'f':
                int f = 110100;
                return f;
                    
            case 'F':
                int F = 110100;
                return F;
                        
            case 'g':
                int g = 110110;
                return g;
                    
            case 'G':
                int G = 110110;
                return G;
                
            case 'h':
                int h = 110010;
                return h;
                
            case 'H':
                int H = 110010;
                return H;
                
            case 'i':
                int i = 010100;
                return i;
                    
            case 'I':
                int I = 010100;
                return I;
                        
            case 'j':
                int j = 010110;
                return j;
                    
            case 'J':
                int J = 010110;
                return J;
                        
            case 'k':
                int k = 101000;
                return k;
                    
            case 'K':
                int K = 101000;
                return K;
                    
            case 'l':
                int l = 111000;
                return l;
                    
            case 'L':
                int L = 111000;
                return L;
                
            case 'm':
                int m = 101100;
                return m;
                    
            case 'M':
                int M = 101100;
                return M;
                
            case 'n':
                int n = 101110;
                return n;
                    
            case 'N':
                int N = 101110;
                return N;
                    
            case 'o':
                int o = 101010;
                return o;
                        
            case 'O':
                int O = 101010;
                return O;
                        
            case 'p':
                int p = 111100;
                return p;
                        
            case 'P':
                int P = 111100;
                return P;
                        
            case 'q':
                int q = 111110;
                return q;
                        
            case 'Q':
                int Q = 111110;
                return Q;
                        
            case 'r':
                int r = 111010;
                return r;
                        
            case 'R':
                int R = 111010;
                return R;
                        
            case 's':
                int s = 011100;
                return s;
                        
            case 'S':
                int S = 011100;
                return S;
                        
            case 't':
                int t = 011110;
                return t;
                        
            case 'T':
                int T = 011110;
                return T;
                    
            case 'u':
                int u = 101001;
                return u;
                        
            case 'U':
                int U = 101001;
                return U;
                        
            case 'v':
                int v = 111001;
                return v;
                        
            case 'V':
                int V = 111001;
                return V;
                        
            case 'w':
                int w = 010111;
                return w;
                        
            case 'W':
                int W = 010111;
                return W;
                        
            case 'x':
                int x = 101101;
                return x;
                        
            case 'X':
                int X = 101101;
                return X;
                        
            case 'y':
                int y = 101111;
                return y;
                        
            case 'Y':
                int Y = 101111;
                return Y;
                        
            case 'z':
                int z = 101011;
                return z;
                        
            case 'Z':
                int Z = 101011;
                return Z;
                        
            default:
                System.exit(0);
        }
        return 0;
    }
}


//Given in Google Foobar

//public class Solution {
//    public static String solution(String s) {
//        int strlen = s.length();
//        int ar[] = new int[6];
//        int h = 0, i = 0, j = 0, k = 0, b = 0, c = 0, upperLetter = 0;
//        char[] a = new char[strlen];
//        for(i = 0; i < strlen; i++) {
//            a[i] = s.charAt(i);
//        }
//        while(h < strlen) {
//            if(h == 0 && upperLetter == 0) {
//                if(Character.isUpperCase(a[h])) {
//                    upperLetter++;
//                }
//            }
//            if(a[h] == 's' || a[h] == 'S') {
//                ar = new int[]{0,1,1,1,0,0};
//            } else if (a[h] == 'w' || a[h] == 'W') {
//                ar = new int[]{0,1,0,1,1,1};
//            } else if(a[h] == 't' || a[h] == 'T') {
//                ar = new int[]{0,1,1,1,1,0};
//            } else if(a[h] == 'j' || a[h] == 'J') {
//                ar = new int[]{0,1,0,1,1,0};
//            } else if(a[h] == 'i' || a[h] == 'I') {
//                ar = new int[]{0,1,0,1,0,0};
//            } else if (a[h] == ',') {
//                ar = new int[]{0,1,0,0,0,0};
//            } else if (a[h] == ';') {
//                ar = new int[]{0,1,1,0,0,0};
//            } else if (a[h] == ':') {
//                ar = new int[]{0,1,0,0,1,0};
//            } else if (a[h] == '.') {
//                ar = new int[]{0,1,0,0,1,1};
//            } else if (a[h] == '!') {
//                ar = new int[]{0,1,1,0,1,0};
//            } else if (a[h] == '(') {
//                ar = new int[]{0,1,1,0,1,1};
//            } else if (a[h] == ')') {
//                ar = new int[]{0,1,1,0,1,1};
//            } else if (a[h] == '?') {
//                ar = new int[]{0,1,1,0,0,1};
//            } else if (a[h] == '"') {
//                ar = new int[]{0,0,1,0,1,1};
//            } else if (a[h] == '-') {
//                ar = new int[]{0,0,1,0,0,1};  
//            } else {
//                b = getCode(a[h]);
//                while(c < 6) {
//                    ar[c] = b % 10;
//                    b /= 10;
//                    c++;
//                }
//                ar = reverse(ar, c);
//            }
//            if(h == 0 && upperLetter == 1){
//                System.out.print("000001");
//            }
//            for(i=0;i<2;i++) {
//                for(j=0;j<3;j++) {
//                    if(i==1) {
//                        k=i+j+2;
//                    } else {
//                        k=j;
//                    }
//                    if(ar[k] == 1) {
//                        System.out.print("1");
//                    } else {
//                        System.out.print("0");
//                    }
//                }
//            }
//            h++;c=0;
//        }
//        System.out.print(" ");
//    }
//    
//    public static int[] reverse(int a[], int size) 
//    { 
//        int[] arr = new int[size]; 
//        int z = size; 
//        for (int i = 0; i < size; i++) { 
//            arr[z - 1] = a[i]; 
//            z = z - 1; 
//        }
//        return arr;
//    }
//    
//    public static int getCode(char character) {
//        switch(character) {
//            case ' ':
//                int space = 000000;
//                return space;
//            
//            case 'a':
//                int a = 100000;
//                return a;
//                
//            case 'A':
//                int A = 100000;
//                return A;
//                    
//            case 'b':
//                int b = 110000;
//                return b;
//                    
//            case 'B':
//                int B = 110000;
//                return B;
//                    
//            case 'c':
//                int c = 100100;
//                return c;
//                    
//            case 'C':
//                int C = 100100;
//                return C;
//                        
//            case 'd':
//                int d = 100110;
//                return d;
//                    
//            case 'D':
//                int D = 100110;
//                return D;
//                        
//            case 'e':
//                int e = 100010;
//                return e;
//                    
//            case 'E':
//                int E = 100010;
//                return E;
//                        
//            case 'f':
//                int f = 110100;
//                return f;
//                    
//            case 'F':
//                int F = 110100;
//                return F;
//                        
//            case 'g':
//                int g = 110110;
//                return g;
//                    
//            case 'G':
//                int G = 110110;
//                return G;
//                
//            case 'h':
//                int h = 110010;
//                return h;
//                
//            case 'H':
//                int H = 110010;
//                return H;
//                
//            case 'i':
//                int i = 010100;
//                return i;
//                    
//            case 'I':
//                int I = 010100;
//                return I;
//                        
//            case 'j':
//                int j = 010110;
//                return j;
//                    
//            case 'J':
//                int J = 010110;
//                return J;
//                        
//            case 'k':
//                int k = 101000;
//                return k;
//                    
//            case 'K':
//                int K = 101000;
//                return K;
//                    
//            case 'l':
//                int l = 111000;
//                return l;
//                    
//            case 'L':
//                int L = 111000;
//                return L;
//                
//            case 'm':
//                int m = 101100;
//                return m;
//                    
//            case 'M':
//                int M = 101100;
//                return M;
//                
//            case 'n':
//                int n = 101110;
//                return n;
//                    
//            case 'N':
//                int N = 101110;
//                return N;
//                    
//            case 'o':
//                int o = 101010;
//                return o;
//                        
//            case 'O':
//                int O = 101010;
//                return O;
//                        
//            case 'p':
//                int p = 111100;
//                return p;
//                        
//            case 'P':
//                int P = 111100;
//                return P;
//                        
//            case 'q':
//                int q = 111110;
//                return q;
//                        
//            case 'Q':
//                int Q = 111110;
//                return Q;
//                        
//            case 'r':
//                int r = 111010;
//                return r;
//                        
//            case 'R':
//                int R = 111010;
//                return R;
//                        
//            case 's':
//                int s = 011100;
//                return s;
//                        
//            case 'S':
//                int S = 011100;
//                return S;
//                        
//            case 't':
//                int t = 011110;
//                return t;
//                        
//            case 'T':
//                int T = 011110;
//                return T;
//                    
//            case 'u':
//                int u = 101001;
//                return u;
//                        
//            case 'U':
//                int U = 101001;
//                return U;
//                        
//            case 'v':
//                int v = 111001;
//                return v;
//                        
//            case 'V':
//                int V = 111001;
//                return V;
//                        
//            case 'w':
//                int w = 010111;
//                return w;
//                        
//            case 'W':
//                int W = 010111;
//                return W;
//                        
//            case 'x':
//                int x = 101101;
//                return x;
//                        
//            case 'X':
//                int X = 101101;
//                return X;
//                        
//            case 'y':
//                int y = 101111;
//                return y;
//                        
//            case 'Y':
//                int Y = 101111;
//                return Y;
//                        
//            case 'z':
//                int z = 101011;
//                return z;
//                        
//            case 'Z':
//                int Z = 101011;
//                return Z;
//                
//            default:
//                System.exit(0);
//        }
//        return 0;
//    }
//}