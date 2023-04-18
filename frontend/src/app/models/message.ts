export interface Message {
  response_type: string;
  source?: string;
  text: string;
  owner: string;
  title?: string;
  options?: { label: string, value: string }[];
  output?: DialogNodeOutput;
}

export interface DialogNodeOutput {
  entities: any[];
  generic: any[];
  intents: any[];
}

export const DEFAULT_MESSAGE: Message = {
  response_type: '',
  text: '',
  owner: '',
  options: [],
  output: { entities: [], generic: [], intents: [] }
};
