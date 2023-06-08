/**
 * Message model
 * @param response_type: string
 * @param source: string
 * @param text: string
 * @param owner: string
 * @param title: string
 * @param options: { label: string, value: string }[]
 * @param output: DialogNodeOutput
 * @returns Message
 */
export interface Message {
  response_type: string;
  source?: string;
  text: string;
  owner: string;
  title?: string;
  options?: { label: string, value: string }[];
  output?: DialogNodeOutput;
}
/**
 * DialogNodeOutput model
 * @param entities: any[]
 * @param generic: any[]
 * @param intents: any[]
 */
export interface DialogNodeOutput {
  entities: any[];
  generic: any[];
  intents: any[];
}
/**
 * Default message
 * @param response_type: ''
 * @param text: ''
 * @param owner: ''
 * @param options: []
 * @param output: { entities: [], generic: [], intents: [] }
 * @returns Message
 */
export const DEFAULT_MESSAGE: Message = {
  response_type: '',
  text: '',
  owner: '',
  options: [],
  output: { entities: [], generic: [], intents: [] }
};
