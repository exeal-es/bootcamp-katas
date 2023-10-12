import { Token } from './Token';

export interface Figure {
  connects(start: number, end: number): boolean;
  applyEffect(token: Token): void;
}