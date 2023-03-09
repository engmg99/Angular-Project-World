import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BookserviceService } from 'src/app/services/bookservice/bookservice.service';
import { Book } from '../../domain/books';

@Component({
  selector: 'app-book-store',
  templateUrl: './book-store.component.html',
  styleUrls: ['./book-store.component.css']
})
export class BookStoreComponent implements OnInit {
  public books: Book[] = [];
  public editBook!: Book;
  public deleteBook!: Book;
  getBooksError:boolean =false;
  constructor(private bookService: BookserviceService) { }

  ngOnInit(): void {
    this.getAllBooks();
  }

  public getAllBooks(): void {
    this.bookService.getBooks().subscribe(
      (res: any) => {
        console.log("AllBooks ", res);
        this.books = res;
      },
      (err: HttpErrorResponse) => {
        console.log(err.message);
        console.log(err.status);
        this.getBooksError=true;
      });
  }

  public editModal(data: Book): void {
    this.editBook = data;
  }

  public deleteModal(data: Book): void {
    this.deleteBook = data;
  }
  public saveEditModalChanegs(formData: NgForm): void {
    this.bookService.updateBook(formData.value).subscribe((res: Book) => {
      console.log(res);
      this.getAllBooks();
    }), (err: HttpErrorResponse) => {
      console.log(err.message);
    };
  }

  public deleteBookModal(bookId: any): void {
    this.bookService.deleteBook(bookId).subscribe((res: string) => {
      console.log(res);
      this.getAllBooks();
    }, (err: HttpErrorResponse) => {
      console.log(err.message);
    })
  }

  public saveBookModal(form: NgForm) {
    console.log(form.value);
    this.bookService.addBook(form.value).subscribe((res: string) => {
      console.log(res);
      this.getAllBooks();
      form.reset();
    }, (err: HttpErrorResponse) => {
      console.log(err.message);
      form.reset();
    })
  }
}
