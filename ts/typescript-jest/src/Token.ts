export class Token {


    private position: number;

    constructor(position: number = 1) {
        this.position = position; 
    }

    getPosition(): number {
        return this.position;
    }

    private moveAllowed(spaces: number): boolean {
        return this.position + spaces <= 100;
    }

    move(spaces: number): void {
        if (!this.moveAllowed(spaces)) {
            return;
        }
        this.position += spaces;
    }
	
    hasWon(): boolean {
        return this.position === 100;
    }

}
  