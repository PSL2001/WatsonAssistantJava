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

  onSubmit(query: string) {
    this.message = {
      ...DEFAULT_MESSAGE,
      response_type: 'text',
      text: query,
      owner: 'Usuario: '
    };

    this.history.push([this.message]);

    this.messageService.sendMessage(this.message).subscribe((result: Message[]) => {
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

          if (message.response_type === 'image') {
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

interface Option {
  label: string;
  value: string;
  'input.text': string; // especificamos el tipo de la propiedad 'input.text'
}


