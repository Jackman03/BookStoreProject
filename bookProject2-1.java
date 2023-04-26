/*
 COPYRIGHT 2022 COP3330 
 HW2 JONAH FERNANDEZ & JACKSON VAUGHN
 
 */

import java.util.Random;
import java.util.Scanner;
public class bookProject2 {
	public static void main(String[] args) {
		
		bookStoreList storeList = new bookStoreList();
		libaryBookList libList = new libaryBookList();
		
		String yon = "xxx";
		
		String bookInfo;
		String storeOrLib = "xx";
		Scanner scanIn = new Scanner(System.in);

		System.out.println("Welcome to the book store");
		System.out.println("Would you like to create a book (yes/no)");
		yon = scanIn.next();
		
		if(yon.equalsIgnoreCase("no")){
			System.out.println("Are you sure? You didnt enter a book! (yes/no)");
			yon = scanIn.next();
			if(yon.equalsIgnoreCase("yes")){
				System.out.println("Have a good day!");
				System.exit(0);
			}
		}
			
		
		if(! (yon.equalsIgnoreCase("yes") || yon.equalsIgnoreCase("no")))//if the anwers is not yes or no, this loop fired
		while(!yon.equalsIgnoreCase("yes") || ! yon.equalsIgnoreCase("no")){//while statremnt for alt anwsee
				System.out.println("please enter a correct anwser");
				yon = scanIn.next();
				if((yon.equalsIgnoreCase("yes") || yon.equalsIgnoreCase("no"))){
					break;
				}
				
		}
				
			
		
	
		while(yon.equalsIgnoreCase("yes")){//do while anwser is yes
		System.out.println("Got it.");
		System.out.println("Great, please entet the author, title and isbn seperated by /");
		bookInfo = (new Scanner (System.in)).nextLine();
		
		String items[] = bookInfo.split("/");
		
		System.out.println("great, is this a libary or book store book (BB or LB)");
		
		storeOrLib = scanIn.next();
		
		if(! (storeOrLib.equalsIgnoreCase("BB") || storeOrLib.equalsIgnoreCase("LB")))//if the anwers is not yes or no, this loop fired
			while(!storeOrLib.equalsIgnoreCase("BB") || ! storeOrLib.equalsIgnoreCase("LB")){//while statremnt for alt anwsee
					System.out.println("please enter a correct anwser");
					storeOrLib = scanIn.next();
					if((storeOrLib.equalsIgnoreCase("BB") || storeOrLib.equalsIgnoreCase("LB"))){
						break;
					}
					
			}
		System.out.println("Got it.");

		if(storeOrLib.equalsIgnoreCase("BB")){//all the info for a book store book
		
			bookStoreBook book = new bookStoreBook();
			book.setAuthor(items[0]);
			book.setTitle(items[1]);
			book.setIsbn(items[2]);
			storeList.addBookStoreBook(book);
			System.out.println("Please enter the price of " + book.priceAsk());
			
			double p = scanIn.nextDouble();
			book.setPrice(p);
			System.out.println("Is the book at a discount?(y/n)");
		
			String discountPrice = scanIn.next();//asks if there is a discount
			
			if(! (discountPrice.equalsIgnoreCase("y") || discountPrice.equalsIgnoreCase("n")))//if the anwers is not yes or no, this loop fired
				while(!discountPrice.equalsIgnoreCase("y") || ! discountPrice.equalsIgnoreCase("n")){//while statremnt for alt anwsee
						System.out.println("please enter a correct anwser");
						discountPrice = scanIn.next();
						if((discountPrice.equalsIgnoreCase("y") || discountPrice.equalsIgnoreCase("n"))){
							break;
						}	
				}
		
			if(discountPrice.equalsIgnoreCase("y")){
				System.out.println("what is the discount?");
				double discount = scanIn.nextDouble();
				//System.out.println("jsut to conform..the discount amount is" + discount);
				book.caculateSale(discount);
			
			System.out.println("got it");
			System.out.println(book.toString());
			}
		
			else if(discountPrice.equalsIgnoreCase("y")){
				System.out.println("got it");
				System.out.println(book.toStringTwo());
			}
		}
			if(storeOrLib.equalsIgnoreCase("LB")){//if a libary book is created
			libaryBook book2 = new libaryBook();
			book2.setAuthor(items[0]);
			book2.setTitle(items[1]);
			book2.setIsbn(items[2]);
			libList.addLibaryBook(book2);
			System.out.println(book2.toString());
		}
		
		System.out.println("would you like to create a book (yes/no)");
		yon = scanIn.next();
		
		if(! (yon.equalsIgnoreCase("yes") || yon.equalsIgnoreCase("no")))//if the anwers is not yes or no, this loop fired
			while(!yon.equalsIgnoreCase("yes") || ! yon.equalsIgnoreCase("no")){//while statremnt for alt anwsee
					System.out.println("please enter a correct anwser");
					yon = scanIn.next();
					if((yon.equalsIgnoreCase("yes") || yon.equalsIgnoreCase("no"))){
						break;
					}
			}
		}
		
		System.out.println("Here are all your  store books");
		System.out.println("");
		storeList.printBooks();
		System.out.println("Here are all your  libary books");
		System.out.println("");
		libList.printBooks();
		
		System.out.println("have a good day!");
	}
	//starts classes
	
	
}

class bookStoreBook {
	private String author;
	private String title;
	private String isbn;
	private double price;
	public double discountedPrice;
	public double discountAmmount;
	private int onSale;
	
	String mgs = "here is your book info: ";
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getOnSale() {
		return onSale;
	}
	public void setOnSale(int onSale) {
		this.onSale = onSale;
	}
	
	public void caculateSale(double percent){
		percent = percent / 100;
		discountedPrice = price * (1.0 - percent);	
		discountedPrice = Math.round(discountedPrice * 100)/100.0;
	}
	
	public String toString(){
		return mgs + isbn + " - " + title + " by " + author +  " for " + price + " listed for " + discountedPrice;
	}
	
	public String toStringTwo(){//prints with no discount
		return mgs + isbn + " - " + title + " by " + author +  " for " + price + " listed for " + price;
	}
	
	public String priceAsk(){
		return title + " by " + author;
	}
}
 class bookStoreList {
	final int SIZE = 100;
	private bookStoreBook [] list;
	
	public bookStoreList(){
		list = new bookStoreBook[SIZE];//creates an arry of bookstorebooks with a size 100
		for (int i = 0; i<SIZE; i++)
			list[i] = null;
		//sets the list of book store books to null
	}
	public void printBooks(){
		//System.out.println("these are the books");
		for(int i = 0; i<SIZE; i++){
			if(list[i] != null)//if the book spot is not null, it gets printed out
				System.out.println(list[i]);
		}
}
	
	private int indexOfNull(){ //finds the index of the number where we will put the book, only putting books in null spots
		int index = -1;//index is set to -1
		for(int i = 0;i<SIZE; i++){
			if(list[i] == null){//is the spot is set to null, we can add a book here
				index = i;//index is set to the null number
				break;
			}
			
		}
		return index;
	}
	public boolean addBookStoreBook(bookStoreBook b){
		int index = indexOfNull();//caculates the first null postion and sets it as the index
		if(index == -1){//if the index is not -1, meaning its filled, the loop contimues
			return false;
		}
		list[index] = b;//if the index is null, the book gets set at the posotion
		return true;
	}
	
	private int indexOfIsbn(String isbn){
		for(int x = 0;x<SIZE;x++){//loops through list of books
			if(list[x] != null){//makes sure the posotipn in the list is not null
				if(isbn.equalsIgnoreCase(list[x].getIsbn()))//checks the isbn
					return x;
			}
		}
		return -1;	
	}
	
	public boolean removeBookStoreBook(String isbn){//we input the isbn so this can look through the list
		int index = indexOfIsbn(isbn);
		if(index == -1)
			return false;//is the indes from the index of isbn is -1, this means the book is not found
		list[index] = null;//finds the posption and sets it to null
		return true;
	}
	
}
 class libaryBookList {
	final int SIZE = 200;
	private libaryBook [] list;
	
	
	
	public libaryBookList(){
		list = new libaryBook[SIZE];//creates an arry of bookstorebooks with a size 100
		for (int i = 0; i<SIZE; i++)
			list[i] = null;
		//sets the list of book store books to null
	}
	public void printBooks(){
		//System.out.println("these are the books");
		for(int i = 0; i<SIZE; i++){
			if(list[i] != null)//if the book spot is not null, it gets printed out
				System.out.println(list[i]);
		}
}
	
	private int indexOfNull(){ //finds the index of the number where we will put the book, only putting books in null spots
		int index = -1;//index is set to -1
		for(int i = 0;i<SIZE; i++){
			if(list[i] == null){//is the spot is set to null, we can add a book here
				index = i;//index is set to the null number
				break;
			}
			
		}
		return index;
	}
	public boolean addLibaryBook(libaryBook b){
		int index = indexOfNull();//caculates the first null postion and sets it as the index
		if(index == -1){//if the index is not -1, meaning its filled, the loop contimues
			return false;
		}
		list[index] = b;//if the index is null, the book gets set at the posotion
		return true;
	}
	
	private int indexOfIsbn(String isbn){
		for(int x = 0;x<SIZE;x++){//loops through list of books
			if(list[x] != null){//makes sure the posotipn in the list is not null
				if(isbn.equalsIgnoreCase(list[x].getIsbn()))//checks the isbn
					return x;
			}
		}
		return -1;	
	}
	
	public boolean removeLibaryBook(String isbn){//we input the isbn so this can look through the list
		int index = indexOfIsbn(isbn);
		if(index == -1)
			return false;//is the indes from the index of isbn is -1, this means the book is not found
		list[index] = null;//finds the posption and sets it to null
		return true;
	}


}
 class libaryBook {
	private String author;
	private String title;
	private String isbn;
	private String callNumber;
	private int floor;
	private String firstThree;
	private int isbnLast;
	String mgs = "here is your book info: ";
	
	public void caculateFloor(){
		int min = 1;
		int max = 99;
		Random random = new Random();
		int floor =  random.nextInt(max + min) + min;
	}
	public void firstThree(){
		String yeah = author.substring(0,3);
		firstThree = yeah;
	}

	public String printCall(){
		
		int min = 1;
		int max = 99;
		Random random = new Random();
		int floor =  random.nextInt(max + min) + min;
		String floorSTR = floor+""; 
		//creates the floor number and converts it into a string
	
		
		String yeah = author.substring(0,3);
		firstThree = yeah;
		//prints get the first three of the authors last name
		
		String lastThree = isbn.substring(isbn.length()-3,isbn.length());
		
		return floorSTR + firstThree + lastThree;
	}


	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String toString(){
		
		int min = 1;
		int max = 99;
		Random random = new Random();
		int floor =  random.nextInt(max + min) + min;
		String floorSTR = floor+""; 
		//creates the floor number and converts it into a string
	
		
		String yeah = author.substring(0,3);
		firstThree = yeah;
		//prints get the first three of the authors last name
		
		String lastThree = isbn.substring(isbn.length()-3,isbn.length());
		return mgs + isbn + " - " + title + " by " + author + " " + floorSTR + firstThree + lastThree;
	}

	

}
	
		
	
