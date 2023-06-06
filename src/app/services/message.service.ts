import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Message } from '../models/message';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private http: HttpClient) { }

  sendMessage(message: Message): Observable<Message[]> {
    const url = `https://8080-psl2001-watsonassistant-05s6p4q5lgj.ws-eu98.gitpod.io/send/`;
    const queryString = `?message=${encodeURIComponent(message.text)}`;
    return this.http.get<Message[]>(url + queryString);
  }
}
