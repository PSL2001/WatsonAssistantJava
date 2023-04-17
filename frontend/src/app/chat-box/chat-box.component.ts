import { Component, OnInit } from '@angular/core';
import { Message } from '../models/message';
import { MessageService } from '../services/message.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-chat-box',
  templateUrl: './chat-box.component.html',
  styleUrls: ['./chat-box.component.css']
})
export class ChatBoxComponent implements OnInit {

  message!: Message;
  response!: Message[];
  history: Message[][];

  constructor(private route: ActivatedRoute, private router: Router, private messageService: MessageService) {
    this.history = [];
  }

  ngOnInit() {
    let mensajeInicial = new Message();
    mensajeInicial.text = "Hola";
    this.response = [];
  
    this.messageService.sendMessage(mensajeInicial).subscribe(result => {
      let messages = Array.isArray(result) ? result : [result];
      messages.forEach(item => {
        if (item.output && item.output.generic && item.output.generic.length > 0) {
          const message = new Message();
          message.text = item.output.generic[0].text;
          message.owner = "Watson: ";
          message.response_type = item.output.generic[0].response_type;
          if (message.response_type === "image") {
            message.source = item.output.generic[0].source;
          } else if (message.response_type === "option") {
            message.title = item.output.generic[0].title;
            message.options = item.output.generic[0].options;
          }
          this.history.push([message]);
        }
      });
    });
  }
  

  onSubmit(query: string) {
    this.message = new Message();
    this.message.response_type = "text";
    this.message.text = query;
    this.message.owner = "Usuario: ";

    this.history.push([this.message]);

    this.messageService.sendMessage(this.message).subscribe(result => {
      let messages = Array.isArray(result) ? result : [result];
      let uniqueMessages: Message[] = [];

      messages.forEach(item => {
        if (item.output && item.output.generic && item.output.generic.length > 0) {
          const message = new Message();
          message.text = item.output.generic[0].text;
          message.owner = "Watson: ";
          message.response_type = item.output.generic[0].response_type;
          
          if (message.response_type === "image") {
            message.source = item.output.generic[0].source;
          } else if (message.response_type === "option") {
            message.title = item.output.generic[0].title;
            message.options = item.output.generic[0].options;
          }

          if (!uniqueMessages.some(m => m.text === message.text && m.response_type === message.response_type)) {
            uniqueMessages.push(message);
          }
        }
      });

      this.history.push(uniqueMessages);
    });
}


  printHistory() {
    console.log(this.history);
  }
  


}
