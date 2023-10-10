export class Token {


    private position: number; 

    constructor() {
        this.position = 1; 
    }

    getPosition(): number {
        return this.position;
    }

    move(spaces: number): void {
        this.position += spaces;
    }

}
  