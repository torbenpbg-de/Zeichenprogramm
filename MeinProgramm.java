import sum.kern.*;
/**
 * GIMP für Arme
 * Torben Piepenburg
 * 1.0.2 
 */
public class MeinProgramm
{
    // Objekte
    Bildschirm derBildschirm;
    Buntstift meinStift;
    Maus dieMaus;
    Tastatur dieTastatur;
    // Konstruktor
    public MeinProgramm()
    {
        derBildschirm = new Bildschirm(1280,720);
        meinStift = new Buntstift();
        dieMaus = new Maus();
        dieTastatur = new Tastatur();
    }

    // Dienste
    public void fuehreAus()
    {

        do
        {
                
                if (dieMaus.istGedrueckt())
                {//Solage Maus gedrückt füre folgendes aus
                    //Folge der Maus und male
                    
                    meinStift.bewegeBis(dieMaus.hPosition(), dieMaus.vPosition());
                    meinStift.runter();

                }else
                {
                    meinStift.bewegeBis(dieMaus.hPosition(), dieMaus.vPosition());
                    meinStift.hoch();
                
                
                }
                if (dieTastatur.wurdeGedrueckt())
                {
                    switch (dieTastatur.zeichen())
                    {
                        //Farbe
                        case 'r': case 'R': meinStift.setzeFarbe(Farbe.ROT); break;
                        case 'g': case 'G': meinStift.setzeFarbe(Farbe.GRUEN); break;
                        case 'b': case 'B': meinStift.setzeFarbe(Farbe.BLAU); break;
                        default: meinStift.setzeFarbe(Farbe.SCHWARZ); break;
                        
                        //Linienbreite
                        case '1': meinStift.setzeLinienBreite(1); break;
                        case '2': meinStift.setzeLinienBreite(2); break;
                        case '3': meinStift.setzeLinienBreite(3); break;
                        case '4': meinStift.setzeLinienBreite(4); break;
                        case '5': meinStift.setzeLinienBreite(5); break;
                        case '6': meinStift.setzeLinienBreite(6); break;
                        case '7': meinStift.setzeLinienBreite(7); break;
                        case '8': meinStift.setzeLinienBreite(8); break;
                        case '9': meinStift.setzeLinienBreite(15); break;
                        
                        //Malen
                        case 'm': case 'M': meinStift.normal(); break;
                        
                        //Entfernen
                        case 'e': case 'E': meinStift.radiere(); break;
                        
                        //Leeren
                        case 'l': case 'L': derBildschirm.loescheAlles(); break;
                    }
                    dieTastatur.weiter();
                }
            
                                
        } while(!dieMaus.doppelKlick());

        // Aufraeumen
        meinStift.gibFrei();
        derBildschirm.gibFrei();
        dieMaus.gibFrei();
        dieTastatur.gibFrei();
    }
}

