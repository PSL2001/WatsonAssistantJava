import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Message } from '../models/message';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private readonly botUrl: string = 'http://localhost:8080/send';

  constructor(private http: HttpClient) { }

  sendMessage(message: Message): Observable<Message[]> {
    const queryString = `?message=${encodeURIComponent(message.text)}`;
    return this.http.get<Message[]>(`${this.botUrl}${queryString}`);
  }
}
