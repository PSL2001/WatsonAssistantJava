import { Component, Input, OnInit } from '@angular/core';
import { Message } from '../models/message';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
/**
 * Message component
 * @param message: Message
 * @returns void
 * @example <app-message [message]="message"></app-message>
 * @example <app-message message="message"></app-message>
 * @implements OnInit
 */
export class MessageComponent implements OnInit {
  /**
   * Message component
   * @param message: Message
   */
  @Input() message!: Message;
  constructor() {}
  /**
   * On init
   * @returns void
   */
  ngOnInit(): void {
  }

}


