import {HttpClient, HttpResponse} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Book} from 'src/app/domain/books';
import {environment} from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class BookserviceService {
  private apiServerUrl = environment.apiBaseUrl + '/bookstore';

  constructor(private http: HttpClient) {}

  public getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.apiServerUrl}/getBooks`);
  }

  public addBook(bookData: Book): Observable<string> {
    return this.http.post(`${this.apiServerUrl}/addBook`, bookData, {responseType: 'text'});
  }

  public updateBook(book: Book): Observable<Book> {
    return this.http.put<Book>(`${this.apiServerUrl}/updateBook`, book);
  }

  public deleteBook(bookId: any): Observable<string> {
    return this.http.delete(`${this.apiServerUrl}/deleteBook/${bookId}`, {responseType: 'text'});
  }
}
