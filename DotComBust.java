import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

        public class DotComBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComList = new ArrayList<DotCom> ();
	private int numOfGuesses = 0;
	private void setUpGame(){
		DotCom one = new DotCom();
		one.setName = ("Pets.com");
		DotCom two = new DotCom();
		two.setName = ("eToys.com")
		DotCom three = new DotCom();
  		three.setName = ("Go2.com");
		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);
		System.out.println("Your Goal is to sink three dotcoms.");
		System.out.println ("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to sink hem all in fewest number of gueeses");
		for (DotCom: dotComList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}
        private void StartPlaying(){
		while(!dotComList.isEmpty()){
			String userGuess = helper.getUserInput("Enter a Guess");
			checkUserGuess(userGuess);
		}
	finishGame();
	}
	private void checkUserGuess(String userGuess){
		numOfGuesses++;
		String result = "miss";
		for (DotCom dotComToTest : dotComList){
			result = dotComToTest.checkYourself(userGuess);
			if (result = "hit"){
				break;
			}
			if (result = "kill"){
				dotComList.remove(dotComTest);
				break;
			}
		}
                System.out.println(result);
	}
        private void finishGame(){
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		if (numOfGuesses <= 18){
			System.out.println("It only took you " + numOfGuesses + " guesses");
			System.out.println("You got out before your options sank");
		}else {
			System.out.println("Took long enough " + numOfGuesses + " guesses");
			System.out.println("Fish are dancing with your options!");
	         }	
		
	}
	public static void main (String []  args) {
		DotComBust game = new DotComBust();
		game.SetUpGame();
		game.StartPlaying();
	}	
public class DotCom {
    private ArrayList<String> locationCells;
    private String name;
    public void setLicationcCells(ArrayList<String> loc){
        locationCells = loc;
    }
    public void setName(String n){
        name = n;
    }
    public String checkYourself(String userInput){
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >=0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk" + name + " :(");
            }
            else {
                result = "hit";
            }
        }
        return result;
    }
}
public class GameHelper{
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int [] grid = new int [gridSize];
    private int Comcount = 0;
    
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new Bufferedreader (new inputStreamreader(System.in));
            inputLine = is.readLine ();
            if (inputLine.length()== 0) return null;
        } catch (IOException e) {
            System.out.print("IOException: " +e);
            
        }
        return inputLine.toLowerCase();
    
    }
    
    public ArrayList<String> placeDotmCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String [] alphacoords = new String[comSize];
        String temp = null;
        int [] coords = new int[comSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;
        comCount++;
        int incr = 1;
        if ((comCount % 2) == 1){
            incr = gridLength;
        }
        while (!success & attempts++ < 200){
            location = (int) (Math.random() * griSize);
            int x = 0;
            success = true;
            while (success && x < comSize) {
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;
                    if (location >= gridSize) {
                        success = false;
                    }
                    if (x >0 && (location % gridLength == 0)){
                        success = false;
                    } else {
                        success = false;
                    }
                }
            }
            
            
            int x = 0;
            int row = 0;
            while (x < comSize){
                grid [coords[x]] = 1;
                row = (int) (coord[x] / gridLength);
                column = coords[x] % gridLength;
                temp = String.valueOf(alphabet.charAt(column));
                alphaCells.add(temp.concat(Integer.String(row)));
                x++;
            }
                    
            return alphaCells;
            
        } 
    }
    
}
}

                        
            
           
        
    

