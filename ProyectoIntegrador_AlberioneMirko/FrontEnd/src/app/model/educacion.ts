export class Educacion {
    /*Aca se ponen las variables como estan en la Entidad */
    id? : number;
    nombreE : string;
    descripcionE : string;
    
    constructor(nombreE: string, descripcionE: string) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
}
