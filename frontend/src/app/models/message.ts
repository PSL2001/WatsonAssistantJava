export class Message {
    response_type!: string;
    source!: string;
    text!: string;
    owner!: string;
    title!: string;
    options!: [];
    output!: {
      entities: any[],
      generic: any[],
      intents: any[]
    }
}

