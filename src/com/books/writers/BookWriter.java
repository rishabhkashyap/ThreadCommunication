package com.books.writers;

import com.books.model.Book;

//
//This class will notify thread(in case of notify) which is waiting on book object. 
//It will not give away lock as soon as notify is called, it first complete its synchronized block.
//So in this example, BookWriter will complete the book and notify it to BookReaders.

public class BookWriter implements Runnable {

	private Book book;

	public BookWriter(Book book) {
		super();
		this.book = book;
	}

	@Override
	public void run() {
		System.out.println("Author is starting book :" + book.getTitle());
		synchronized (book) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			book.setCompleted(true);
			System.out.println("Book has been completed now ");
			//book.notifyAll();
			book.notify();
			System.out.println("Notify one reader");

		}
	}

}
