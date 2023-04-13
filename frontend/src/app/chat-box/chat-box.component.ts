import { Component, OnInit } from '@angular/core';
import {Message} from '../models/message';
import {MessageService} from '../services/message.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-chat-box',
  templateUrl: './chat-box.component.html',
  styleUrls: ['./chat-box.component.css']
})
export class ChatBoxComponent implements OnInit {

  message: Message;
  response: Message[];
  history: Message[][];

  constructor(private route: ActivatedRoute, private router: Router, private messageService: MessageService) { 
    this.history = [];
  }

  ngOnInit() {
    let mensajeInicial = new Message();
    mensajeInicial.text = "Hola";
    this.messageService.sendMessage(mensajeInicial).subscribe(result => {
      this.response = result;
      this.response.map(x => x.owner = "Watson")
      this.history.push(this.response);
    });
  }

}
