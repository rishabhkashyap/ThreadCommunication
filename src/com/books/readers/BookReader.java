package com.books.readers;

import com.books.model.Book;

//This thread will wait until other thread call notify method, then after it will complete its processing. 
//It will first take a lock on book object and will be called from synchronized block .
//It will wait for BookWriter to complete the book.

public class BookReader implements Runnable {
	
	private Book book;
	

	
	//Constrctor
	public BookReader(Book book) {
		super();
		this.book = book;
	}
	
	@Override
	public void run() {
	synchronized(book){
		System.out.println(Thread.currentThread().getName()+" is waiting for the book to be completed: "+book.getTitle());  
		try{
			book.wait();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" : Book has been completed now !! You can read it .. ");
	}

	}



	

}
