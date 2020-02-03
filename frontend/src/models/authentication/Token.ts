export default class Token {
    constructor(
        accessToken: string,
        tokenType: string
    ) { 
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }
    
    accessToken: string;
    tokenType: string;
};