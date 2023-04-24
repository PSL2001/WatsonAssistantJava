import { Component, OnInit } from '@angular/core';
import { Message, DEFAULT_MESSAGE } from '../models/message';
import { MessageService } from '../services/message.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-chat-box',
  templateUrl: './chat-box.component.html',
  styleUrls: ['./chat-box.component.css']
})
export class ChatBoxComponent implements OnInit {

  message: Message = { ...DEFAULT_MESSAGE }; // Inicializa el objeto de mensaje con el valor predeterminado
  response: Message[] = [];
  history: Message[][] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private messageService: MessageService
  ) { }

  /**
   * Inicializa el componente
   * Esta función se ejecuta cuando se inicia el componente
   * Lo unico que hace es simular como si el usuario hubiera escrito "Hola" en el chat
   * y envia el mensaje a Watson, para que este nos responda y se guarde en el historial
   * ademas de mostrarlo en el chat
   * @param void
   * @returns void
   */
  ngOnInit() {
    // Creamos un mensaje inicial para que Watson nos responda
    // Este mensaje es solo para simular que el usuario ha escrito "Hola" en el chat y que Watson nos responda
    const initialMessage: Message = {
      ...DEFAULT_MESSAGE,
      text: 'Hola'
    };
    // Enviamos el mensaje a Watson, via el servicio de mensajes
    this.messageService.sendMessage(initialMessage).subscribe((result: Message[]) => {
      // Recibimos la respuesta de Watson y la guardamos en la variable result
      // Comprobamos si result es un array, si lo es, lo guardamos en la variable messages
      const messages = Array.isArray(result) ? result : [result];
      // Recorremos el array de mensajes
      messages.forEach((item: Message) => {
        // Comprobamos si el mensaje tiene un output y si este output tiene un generic y si este generic tiene un length mayor que 0
        if (item.output && item.output.generic && item.output.generic.length > 0) {
          // Si se cumple la condición anterior, creamos un nuevo mensaje con el texto de la respuesta de Watson
          // Como sabemos que siempre se recibe 1 mensaje de watson de esta forma, podemos acceder directamente a la posición 0 del array
          const message: Message = {
            ...DEFAULT_MESSAGE,
            text: item.output.generic[0].text,
            owner: 'Watson: ',
            response_type: item.output.generic[0].response_type,
            source: item.output.generic[0].source || '',
            title: item.output.generic[0].title || '',
            options: item.output.generic[0].options || []
          };
          //Mandamos el mensaje al historial
          this.history.push([message]);
        }
      });
    });
  }

  /**
   * Función que se ejecuta cuando se pulsa el botón de enviar
   * Toma el valor del input y lo envia a la función onSubmit
   * @param query1 
   */
  submitMessage(query1: string) {
    this.onSubmit(query1);
  }

  /**
   * Función que se ejecuta cuando el usuario manda un mensaje cualquiera a Watson
   * Esto nos devuelve una respuesta de watson, la cual puede ser un texto, una imagen o un conjunto de botones para elegir
   * @param res 
   */
  onSubmit(res: Message | string) {
    // Comprobamos si res es un string, si lo es, lo guardamos en la variable query, hacemos esto ya a veces nos llegan strings y otras veces objetos
    const query = typeof res === 'string' ? res : res.options?.values || res.text || '';
    // Como a veces nos llegan objetos, simplemente forzamos a que query sea un string
    this.message = {
      ...DEFAULT_MESSAGE,
      response_type: 'text',
      text: query as string,
      owner: 'Usuario: '
    };

    // Mandamos el mensaje al historial
    this.history.push([this.message]);

    // Enviamos el mensaje a Watson, via el servicio de mensajes
    this.messageService.sendMessage(this.message).subscribe((result: Message[]) => {
      // Recibimos la respuesta de Watson y la guardamos en la variable result
      // Comprobamos si result es un array, si lo es, lo guardamos en la variable messages
      const messages = Array.isArray(result) ? result : [result];
      console.log(messages);
      // Recorremos el array de mensajes
      messages.forEach((item: Message) => {
        if (item.output && item.output.generic && item.output.generic.length > 0) {
          console.log(item.output.generic)
          const message: Message = {
            ...DEFAULT_MESSAGE,
            text: item.output.generic[0].text,
            owner: 'Watson: ',
            response_type: item.output.generic[0].response_type,
            source: item.output.generic[0].source || '',
            title: item.output.generic[0].title || '',
            options: item.output.generic[0].options || []
          };
          //Comprobamos si existe un segundo output y si este es de tipo option
          if (existeOutputOption(item.output.generic.length, item.output.generic)) {
            //Si existe, creamos un nuevo mensaje con el segundo output
            const optionMessage: Message = {
              ...DEFAULT_MESSAGE,
              response_type: item.output.generic[1].response_type,
              title: item.output.generic[1].title,
              options: item.output.generic[1].options,
            }
            //Comprobamos si el mensaje ya existe en el historial
            if (noExisteEnHistorial([message, optionMessage], this.history, item.output.generic[1].response_type)) {
              this.history.push([message, optionMessage]);
              return;
            }
          }
          //Comprobamos si el mensaje es una imagen
          if (message.response_type === 'image') {
            //Comprueba primero si la imagen le falta un elemento source. No debería de pasar, pero en caso de que la imagen original dejara de existir, se le asigna una imagen por defecto
            if (message.source === '') {
              message.source = 'https://placehold.it/300x300';
            }
            //Las imagenes siempre vienen con un mensaje de texto, por lo que creamos un nuevo mensaje con el texto de la imagen
            const textMessage: Message = {
              ...DEFAULT_MESSAGE,
              text: item.output.generic[1].text,
              owner: 'Watson: ',
              response_type: 'text'
            };
            //Comprobamos si el mensaje ya existe en el historial
            if (noExisteEnHistorial([message, textMessage], this.history, message.response_type)) {
              this.history.push([message, textMessage]);
            }
          } else {
            //Guardamos el mensaje en el historial, este else solo pasa cuando no es una imagen o un option
            this.history.push([message]);
          }
        }
      });
    });

  }

  /**
   * Función que se ejecuta cuando el usuario pulsa un botón
   * Simplemente manda el valor del botón a la función onSubmit
   * @param option 
   * @returns el valor del botón o un string vacío si no existe
   */
  getButtonValue(option: any): string {
    if (option.value && option.value.input && option.value.input.text) {
      return option.value.input.text;
    } else {
      return '';
    }
  }
  
  /**
   * Funcion de debug, imprime el historial en la consola
   */
  printHistory() {
    console.log(this.history);
  }

}
/**
 * Función que comprueba si existe un segundo output y si este es de tipo option
 * 
 * @param length 
 * @param generic 
 * @returns  true si existe un segundo output y este es de tipo option, false en caso contrario
 */
function existeOutputOption(length: number, generic: any) {
  if (length > 1) {
    if (generic[1].response_type === 'option') {
      return true;
    }
  }
  return false;
}

/**
 * Función que comprueba si un mensaje ya existe en el historial
 * @param messages 
 * @param history 
 * @param response_type 
 * @returns true si el mensaje no existe en el historial, false en caso contrario o -1 si ha habido un error
 */
function noExisteEnHistorial(messages: Message[], history: Message[][], response_type: string) {
  //Comprobamos el tipo de respuesta que recibimos
  if (response_type === 'option') {
    //Si es de tipo option, comprobamos que el titulo y el tipo de respuesta sean iguales
    return !history.some(arr => arr.some(m => m.title === messages[1].title && m.response_type === messages[1].response_type));
  }
  if (response_type === 'image') {
    //Si es de tipo image, comprobamos que el source y el tipo de respuesta sean iguales
    return !history.some(arr => arr.some(m => m.source === messages[0].source && m.response_type === messages[0].response_type));
  }
  //Si no es de tipo option ni de tipo image, entonces es de tipo text o ha habido un error
  return -1;
}
