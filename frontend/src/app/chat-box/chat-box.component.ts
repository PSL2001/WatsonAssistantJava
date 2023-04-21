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

  ngOnInit() {
    const initialMessage: Message = {
      ...DEFAULT_MESSAGE,
      text: 'Hola'
    };

    this.messageService.sendMessage(initialMessage).subscribe((result: Message[]) => {
      const messages = Array.isArray(result) ? result : [result];
      messages.forEach((item: Message) => {
        if (item.output && item.output.generic && item.output.generic.length > 0) {
          const message: Message = {
            ...DEFAULT_MESSAGE,
            text: item.output.generic[0].text,
            owner: 'Watson: ',
            response_type: item.output.generic[0].response_type,
            source: item.output.generic[0].source || '',
            title: item.output.generic[0].title || '',
            options: item.output.generic[0].options || []
          };
          this.history.push([message]);
        }
      });
    });
  }

  submitMessage(query1: string) {
    this.onSubmit(query1);
  }


  onSubmit(res: Message | string) {
    const query = typeof res === 'string' ? res : res.options?.values || res.text || '';

    this.message = {
      ...DEFAULT_MESSAGE,
      response_type: 'text',
      text: query as string,
      owner: 'Usuario: '
    };


    this.history.push([this.message]);

    this.messageService.sendMessage(this.message).subscribe((result: Message[]) => {
      const messages = Array.isArray(result) ? result : [result];
      console.log(messages);
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
          //Comprobamos si existe un segundo output
          if (item.output.generic.length > 1) {
            //Comprobamos si este output es un option
            if (item.output.generic[1].response_type === 'option') {
              //Sabemos que esto es un option, creamos el mensaje correspondiente
              const optionMessage: Message = {
                ...DEFAULT_MESSAGE,
                title: item.output.generic[1].title,
                options: item.output.generic[1].options,
              }
              //Comprobamos si el mensaje ya existe en el historial
              if (!this.history.some(arr => arr.some(m => m.title === optionMessage.title && m.response_type === optionMessage.response_type))) {
                //Si no existe, lo añadimos, con el mensaje de texto correspondiente
                this.history.push([message, optionMessage]);
              }
            }
          }
          console.log(message);
          
          if (message.response_type === 'image') {
            //Comprueba primero si la imagen le falta un elemento source
            if (message.source === '') {
              message.source = 'https://placehold.it/300x300';
            }

            const textMessage: Message = {
              ...DEFAULT_MESSAGE,
              text: item.output.generic[1].text,
              owner: 'Watson: ',
              response_type: 'text'
            };
            if (!this.history.some(arr => arr.some(m => m.source === message.source && m.response_type === message.response_type))) {
              this.history.push([message, textMessage]);
            }
          } else {
            console.log('This is a text response');
            this.history.push([message]);
          }
        }
      });
    });

  }

  printHistory() {
    console.log(this.history);
  }

  trackByFn(index: number, item: Message[]) {
    return index;
  }
}