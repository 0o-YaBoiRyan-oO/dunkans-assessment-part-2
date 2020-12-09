import java.util.ArrayList;

public class Search {

    ArrayList<City> linear(ArrayList<City> A, String X){

        ArrayList<City> position  = new ArrayList<City>();        
        boolean found = false; 
        int index = 0;
        int checkNo = 0;
        int N = A.size();
        
        

        while (!found && index < N) {
            checkNo ++;
            // check A[index]
            if ((A.get(index).getName()).equals(X)) {

                System.out.println(X + " has been found: ");
                System.out.println("----------------------------");
                System.out.println("Number of cities checked: " + checkNo);
                System.out.println("----------------------------");

                found = true;
                position.add(A.get(index));
            }
            index ++;
        }

        if (found == false){
            System.out.println(X + " could NOT be found");
            System.out.println("----------------------------");
            System.out.println("Number of cities checked: " + checkNo);
            System.out.println("----------------------------");
        }
        
        return position;
        
   }

    ArrayList<City> binary(ArrayList<City> A, int X){

        int N = A.size();
        int lower = 0, upper = N;
        ArrayList<City> position  = new ArrayList<City>();            // index of X to be returned
        boolean found = false;  // assumption is X will not be found
        int checkNo = 0;

        // if X is there, it must be in A[lower..upper]
        while (!found && lower <= upper){    // if X is there, it must be in A[lower..upper]
            checkNo ++;
            int middle = (lower + upper)/2;
            if (A.get(middle).getPopulation() == X){
                System.out.println("City has been found with the population of: " + X);
                System.out.println("----------------------------");
                System.out.println("Number of cities checked: " + checkNo);
                System.out.println("----------------------------");

                found = true;
                position.add(A.get(middle));
            }
            else if (A.get(middle).getPopulation() > X){  // if X is there, it is in A[lower..middle-1]
                upper = middle -1;        
            }
            else{  //  A[middle < X.  if X is there, it is in A[middle+1, upper]
                  lower = middle +1;
            }
        }

        return position;
    }

}

