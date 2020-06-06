import java.util.Scanner;

public class SortedBooleanMatrix{
    private static int m = 0;
    private static int n = 0;
    private static int[][] q;

    public static void findMax1sWithRowNumberOptimized(){
        int m = q.length;
        int n = q[0].length;
        int j = n-1;
        // space complexity: BigO(1)
        int maxRowNum = 0;
        // space complexity: BigO(1)
        int maxCount = 0;
        
        // time complexity: BigO(m + n)
        for(int i=0; i<m; i++){
            // space complexity: BigO(1)
            int sum = 0;
            while(j>=0){
                if(q[i][j] == 0){
                    break;
                }
                sum = n-j;
                j--;
            }
            if(sum > maxCount){
                maxCount = sum; 
                maxRowNum = i;
            }
            if(j < 0){
                break;
            }
        }

        if(maxCount == 0){
            System.out.println("No 1s found in any row");
        } else {
            System.out.println("Max 1s found in row:"+maxRowNum+", 1s count:"+maxCount);
        }

        // Overall time complexity: BigO(m + n)
        // Overall space complexity: BigO(1) + BigO(1) + BigO(1) ==> BigO(1)
    }

    public static void findMax1sWithRowNumber(){
        int m = q.length;
        int n = q[m-1].length;
        // space complexity: BigO(1)
        int maxCount = 0;
        // space complexity: BigO(1)
        int maxRowNum = 0;
        // time complexity: BigO(m*n)
        for(int i=0; i<m; i++){
            // space complexity: BigO(1)
            int sum = 0;
            for(int j=0; j<n; j++){
                sum += q[i][j];
                if(q[i][j] == 1){
                    sum = n-j;
                    break;
                }
            }
            if(sum > maxCount){
                maxCount = sum;
                maxRowNum = i;
            }
        }

        if(maxCount == 0){
            System.out.println("No 1s found in any row");
        } else {
            System.out.println("Max 1s found in row:"+maxRowNum+", 1s count:"+maxCount);
        }

        // Overall time complexity: BigO(m*n)
        // Overall space complexity: BigO(1) + BigO(1) + BigO(1) ==> BigO(1)
    }

    public static void main(String[] args){
        prepareMatrix();
        //findMax1sWithRowNumber();
        findMax1sWithRowNumberOptimized();
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