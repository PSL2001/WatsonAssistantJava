import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Message } from '../models/message';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private http: HttpClient) { }

  sendMessage(message: Message): Observable<Message[]> {
    const url = `http://localhost:8080/send/${message.response_type}`;
    const queryString = `?message=${encodeURIComponent(message.text)}`;
    return this.http.get<Message[]>(url + queryString);
  }
}
