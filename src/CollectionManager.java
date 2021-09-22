import java.util.Scanner;
import java.util.StringTokenizer;


public class CollectionManager {
	
	private Scanner inputObj;
	private String inputString;
	private StringTokenizer input;
	String command;
	public static Collection library;

	public void run() {
		
		System.out.println("Collection Manager starts running");
		System.out.println();
		
		library = new Collection();
		
		do {
		
		 inputObj = new Scanner(System.in);			//Scanner Input Object
		
		 inputString = inputObj.nextLine();			// Input Object(inputObj) is converted to String (inputString)
		
		 input = new StringTokenizer(inputString, ",");		//inputString is Tokenized;
		 													//input is Tokenized Object
		 command = input.nextToken();
		 
		 readInput();
		 
		 
		} while(!command.equals("Q"));
		
		System.out.println("Collection Manager Terminated");		
		
	}
	
	private void readInput(){
		
		if ( command.equals("A") ) {			//Add Album
			
										
			String newTitle = input.nextToken();
			String newArtist = input.nextToken();
			Genre newGenre = new genre(input.nextToken());
			Date newReleaseDate = new Date(input.nextToken());
			
			Album newAlbum = new Album(newTitle, newArtist, newGenre, newReleaseDate, true);
			
			if (!library.add(newAlbum)) { 
				System.out.println("Album Added");
			}
			else {
				System.out.println("Album already exists");
			}
			
			
		}
		else if ( command.equals("D") ) {		//Remove Album
			
			String title = input.nextToken();
			String artist = input.nextToken();
			Album delAlbum = new Album(title, artist);
			
			if (library.remove(delAlbum)) {
				System.out.println("Album Removed");
			}
			else {
				
				System.out.println("Album Not Found. Try Again");
			}
			
			
			
		}
		else if ( command.equals("L") ) {		//Lend out an Album
			
			String title = input.nextToken();
			String artist = input.nextToken();
			Album lendAlbum = new Album(title, artist);
			
				
				if (library.lendingOut(lendAlbum)) {
					
					System.out.println("Album Lent");
				}
				else {

					System.out.println("Album is not available; "
							         + "please come back some other time");
				}
		}
		
		else if ( command.equals("R") ) {		//Return an Album
			
			String title = input.nextToken();
			String artist = input.nextToken();
			Album returningAlbum = new Album(title, artist);
				
				if (library.returnAlbum(returningAlbum)) {
					
					System.out.println("Album returned");
					
				}
				else {
					
					System.out.println("Wrong Album; Try agian");
					
				}
	
			
		}
		else if ( command.equals("P") ) {		//display collection without specifying the order
			
			library.print();
			
		}
		else if ( command.equals("PD") ) {		//display the collection sorted by the release dates
			
			library.printByReleaseDate();
			
		}
		else if ( command.equals("PG") ) {		//display the collection sorted by the genres
			
			library.printByGenre();
			
		}
		else {
			
			System.out.println("Invalid Command!");
			
		}
		
		
		
	}
	
	
	
}
