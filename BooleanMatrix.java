import java.util.Scanner;

public class BooleanMatrix{
    private static int m = 0;
    private static int n = 0;
    private static int[][] q;

    public static void booleanMatrixSet1sOptimized(int[][] q){

        int m=q.length;
        int n=q[m-1].length;
        // space complexity: BigO(1)
        int row = 0;
        // space complexity: BigO(1)
        int col = 0;
        
        // time complexity: BigO(m)
        for(int i=0; i<m; i++){
            if(q[i][0] == 1){
                row = 1;
            }
        }

        // time complexity: BigO(n)
        for(int j=0; j<n; j++){
            if(q[0][j] == 1){
                col = 1;
            }
        }

        // time complexity: BigO((m-1)*(n-1))
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(q[i][j] == 1){
                    q[i][0] = 1;
                    q[0][j] = 1;
                }
            }
        }

        System.out.println("New matrix with 1s at every place where either row or column is one in the provided matrix:");
        // time complexity: BigO(m*n)
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(q[i][0] == 1 || q[0][j] == 1){
                    q[i][j] = 1;
                    System.out.print(q[i][j]+" ");
                }else if((i==0 && col == 1) || (j==0 && row == 1)){
                    System.out.print(1+" ");
                } else {
                    System.out.print(0+" ");;
                }
            }
            System.out.println();
        }

        // time complexity: BigO(m)
        for(int i=0; i<m; i++){
            if(row == 1){
                q[i][0] = 1;
            }
        }

        // time complexity: BigO(n)
        for(int j=0; j<n; j++){
            if(col == 1){
                q[0][j] = 1;
            }
        }

        // Overall time complexity: BigO(m) + BigO(n)+ BigO((m-1)*(n-1)) + BigO(m*n) + BigO(m) + BigO(n)==> 
        // ==> 2BigO(m) + 2BigO(n) + BigO((m-1)*(n-1)) + BigO(m*n) ==> BigO(m*n)
        // Overall space complexity: BigO(1) + BigO(1)  ==> BigO(1)
    }

    public static void booleanMatrixSet1s(int[][] q){

        int m=q.length;
        int n=q[m-1].length;
        // space complexity: BigO(m)
        int row[] = new int[m];
        // space complexity: BigO(n)
        int col[] = new int[n];

        // time complexity: BigO(m*n)
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(q[i][j] == 1){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        System.out.println();
        System.out.println("New matrix with 1s at every place where either row or column is one in the provided matrix:");
        // time complexity: BigO(m*n)
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(row[i] == 1 || col[j] == 1){
                    q[i][j] = 1;
                }
                System.out.print(q[i][j]+" ");
            }
            System.out.println();
        }

        // Overall time complexity: BigO(m*n) + BigO(m*n)  ==> BigO(m*n) 
        // Overall space complexity: BigO(m) + BigO(n)  ==> BigO(m + n)
    }

    public static void main(String[] args){
        prepareMatrix();
        System.out.println("");
        System.out.println("calling booleanMatrixSet1s...");
        booleanMatrixSet1sOptimized(q);
    }

    public static void prepareMatrix(){
        Scanner input = new Scanner(System.in);
        // reading matrix length
        try{
            System.out.println("Enter the length of matrix in 'm x n' format");
            String matrix = input.nextLine();
            String []matrixDimensions = matrix.split(" x ");
            m = Integer.parseInt(matrixDimensions[0]);
            n = Integer.parseInt(matrixDimensions[1]);
            q = new int[m][n];
        } catch(Exception ex){
            throw new IllegalArgumentException("Entered invalid matrix length");
        }
        
        // reading matrix input data
        try{
            for(int i=0; i<m; i++){
                System.out.println("Enter boolean matrix data in 0 or 1 separated by one space like  0 0 1 1 0");
                String data = input.nextLine();
                String []matrixData = data.split(" ");
                for(int j=0; j<matrixData.length; j++){
                    int value = Integer.parseInt(matrixData[j]);
                    if(value !=0 && value !=1){
                        throw new IllegalArgumentException("Entered only 0 or 1 value in matrix data");
                    }
                    q[i][j] = value;
                }
            }
        } catch(Exception ex){
            throw new IllegalArgumentException("Entered invalid matrix data in boolean matrix");
        }


        // printing matrix data
        System.out.println("Enterd matrix is:");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(q[i][j]+" ");
            }
            System.out.println();
        }
    }
}
