import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Message } from '../models/message';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
/**
 * Message service
 * @param http: HttpClient
 * @returns Observable<Message[]>
 */
export class MessageService {
  /**
   * Message service
   * @param http: HttpClient
   */
  constructor(private http: HttpClient) { }
  /**
   * Send message
   * @param message
   * @returns Observable<Message[]>
   */
  sendMessage(message: Message): Observable<Message[]> {
    /**
     * La url del backend. En este caso esta apuntando al backend de Gitpod.
     * Puedes cambiarlo por el backend de tu preferencia. Siempre y cuando
     * el backend este disponible y este apuntando a la ruta correcta (en este caso /send).
     */
    const url = `https://8080-psl2001-watsonassistant-05s6p4q5lgj.ws-eu98.gitpod.io/send/`;
    /**
     * La query string que se va a enviar al backend.
     * En mi caso, el backend espera un query string con el parametro message.
     * Ejemplo: ?message=Hola
     * Si tu backend espera otro query string, puedes cambiarlo aqui.
     */
    const queryString = `?message=${encodeURIComponent(message.text)}`;
    /**
     * Retorna un observable con el resultado de la peticion.
     * En este caso, el backend retorna un arreglo de mensajes.
     * Y estos se retornan por GET.
     * Si tu backend retorna algo diferente o lo hace por POST, puedes cambiarlo aqui.
     */
    return this.http.get<Message[]>(url + queryString);
  }
}
