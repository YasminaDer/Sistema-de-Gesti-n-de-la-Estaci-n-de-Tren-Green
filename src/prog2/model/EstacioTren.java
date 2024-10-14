package prog2.model;
import prog2.vista.ExcepcioEstacio;
import java.io.*;

/**
 * Aquesta classe és responsable de mantenir tota la informació relativa a una estació de tren.
 * La classe VistaEstacioTren utilitza aquesta informació per mostrar-la a l'usuari i permetre-li canviar l'estat de l'estació si és necessari.
 * @author Yasmina Dermouh y Katerina Lothe.
 */


public class EstacioTren implements Serializable {
    
    private LlistaVies llistaVies; // Llista de vies disponibles a l'estació
    private LlistaIncidencies llistaIncidencies; // Llista d'incidències registrades a l'estació
    private LlistaAccessos llistaAccessos; // Llista d'accés a l'estació
    
    /**
     * Constructor per defecte que inicialitza les llistes de vies, incidències i accessos.
     */
    
    public EstacioTren(){
        this.llistaVies = new LlistaVies();
        this.llistaIncidencies = new LlistaIncidencies();
        this.llistaAccessos = new LlistaAccessos();
    }
    
    public LlistaAccessos getLlistaAccessos(){
        return llistaAccessos;
    }
    
    public LlistaIncidencies getLlistaIncidencies(){
        return llistaIncidencies;
    }
    
    public LlistaVies getLlistaVies(){
        return llistaVies;
    }
    
    /**
     * Mètode per afegir una nova incidència a una via específica.
     * @param num Número de la incidència
     * @param tipus Tipus de la incidència
     * @param nomVia Nom de la via on es produeix la incidència
     * @param data Data en què es va produir la incidència
     * @throws ExcepcioEstacio Si hi ha un error
     */
    public void afegirIncidencia (int num, String tipus, String nomVia, String data) throws ExcepcioEstacio {
        Via via = llistaVies.getVia(nomVia);
        llistaIncidencies.afegirIncidencia(num, tipus, via, data);  
        llistaAccessos.actualitzaEstatAccessos();
    }
    
    /**
     * Mètode per eliminar una incidència específica.
     * @param num Número de la incidència a eliminar
     * @throws ExcepcioEstacio Si hi ha un error
     */
    public void eliminarIncidencia(int num) throws ExcepcioEstacio {
        Incidencia incidencia = llistaIncidencies.getIncidencia(num);
        llistaIncidencies.eliminarIncidencia(incidencia);
        llistaAccessos.actualitzaEstatAccessos();   
    }
    
    /**
    * Mètode per desar l'estat de l'estació en un fitxer.
    *
    * @param camiDesti La ruta del fitxer on es desa l'estat de l'estació.
     * @throws ExcepcioEstacio Si hi ha algun error durant el procés de desament.
     */
    public void guardar(String camiDesti) throws ExcepcioEstacio {
        File fitxer = null;
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        
        try {
            // Crear l'objecte File amb la ruta especificada
            fitxer = new File(camiDesti);
            // Crear un flux de sortida per escriure a un fitxer
            fout = new FileOutputStream(fitxer);
            // Crear un objecte ObjectOutputStream per escriure objectes a un flux de sortida
            oos = new ObjectOutputStream(fout);
            
            EstacioTren estacioTren2 = new EstacioTren();
            estacioTren2.llistaAccessos = this.llistaAccessos;
            estacioTren2.llistaIncidencies = this.llistaIncidencies;
            estacioTren2.llistaVies = this.llistaVies;
            
            // Escriure l'estacioTren al fitxer
            oos.writeObject(estacioTren2);
        } catch (IOException e) {
            // Llançar una excepció personalitzada si hi ha un error en desar les dades
            throw new ExcepcioEstacio("Error: No s'ha pogut desar correctament.");
        } finally {
            try {
                // Tancar els recursos oberts (ObjectOutputStream i FileOutputStream)
                if (oos != null) {
                    oos.close();
                }
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException e) {
                // Llançar una excepció si hi ha un error en tancar els recursos
                throw new ExcepcioEstacio("Error en tancar el flux de sortida.");
            }
        }
    }
    
    /**
     * Carrega una instància d'EstacioTren des d'un fitxer.
     * 
     * @param camiOrigen La ruta del fitxer des d'on es carregarà l'EstacioTren.
     * @return Una instància d'EstacioTren carregada des del fitxer.
     * @throws ExcepcioEstacio Si hi ha algun error durant el procés de càrrega.
     */
    public static EstacioTren carregar(String camiOrigen) throws ExcepcioEstacio {
        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try {
            // Creem un flux d'entrada per llegir del fitxer
            fin = new FileInputStream(camiOrigen);
            // Creem un ObjectInputStream per llegir objectes del flux d'entrada
            ois = new ObjectInputStream(fin);

            // Llegim l'estació de tren.
            EstacioTren estacioTren = (EstacioTren) ois.readObject();
            // Retornem una nova instància d'EstacioTren amb les llistes carregades
            return estacioTren;

        } catch (FileNotFoundException e) {
            // Si el fitxer no existeix, llencem una excepció personalitzada
            throw new ExcepcioEstacio("No heu guardat una estació prèviament.");
        } catch (IOException | ClassNotFoundException e) {
            // Llencem una excepció personalitzada si hi ha algun error en carregar les dades
            throw new ExcepcioEstacio("Error: No s'ha pogut recuperar.");
        } finally {
            try {
                // Tanquem els recursos oberts (ObjectInputStream i FileInputStream)
                if (ois != null) {
                    ois.close();
                }
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException e) {
                // Llencem una excepció si hi ha un error en tancar els recursos
                throw new ExcepcioEstacio("Error en tancar el flux d'entrada.");
            }
        }
    }
    
    
    public void inicialitzaDadesEstacioTren() throws ExcepcioEstacio {
    
        llistaAccessos.buidar();
        
        float desnivell = 9;
        
        float pes = 200;
        Acces Acc1 = new Ascensor(pes, desnivell, "A1", true);      
        llistaAccessos.afegirAcces(Acc1);
        
        
        String marca = "Schindler";
       
        Acces  Acc2 = new EscalaMecanica(marca, desnivell, "A2", true);     
          
        llistaAccessos.afegirAcces(Acc2);
        
        float longitud = 30;
        Acces Acc3 = new Passadis(longitud, "A3", true); 
        llistaAccessos.afegirAcces(Acc3);
        
        
        float vel = 0.3f;  
        Acces  Acc4 = new CintaTransportadora(vel, longitud, "A4", true);     
        llistaAccessos.afegirAcces(Acc4);
        
        desnivell = 7;
        pes = 300;
        Acces Acc5 = new Ascensor(pes, desnivell, "A5", true);    
        llistaAccessos.afegirAcces(Acc5);
        
        Acces Acc6 = new Escala(desnivell, "A6", true);    
        llistaAccessos.afegirAcces(Acc6);
        
        desnivell = 8.5f;
        pes = 250;
        Acces  Acc7 = new Ascensor(pes, desnivell, "A7", true);      
        llistaAccessos.afegirAcces(Acc7);
        
        Acces Acc8 = new Escala(desnivell, "A8", true);       
        llistaAccessos.afegirAcces(Acc8);
        
        longitud = 25;
        Acces Acc9 = new Passadis(longitud, "A9", true);   
        llistaAccessos.afegirAcces(Acc9);
        
        vel = 0.4f; 
        Acces Acc10 = new CintaTransportadora(vel, longitud, "A10", true);       
        llistaAccessos.afegirAcces(Acc10);
        
        desnivell = 8;
        marca = "Otis";
        Acces Acc11 = new EscalaMecanica(marca, desnivell, "A11", true);   
        llistaAccessos.afegirAcces(Acc11);
        
        longitud = 20;
        Acces Acc12 = new Passadis(longitud, "A12", true); 
        llistaAccessos.afegirAcces(Acc12);
        
        desnivell = 20;
        Acces Acc13 = new Escala(desnivell, "A13", true);       
        llistaAccessos.afegirAcces(Acc13);
        
        pes = 350;
        Acces Acc14 = new Ascensor(pes, desnivell, "A14", true);       
        llistaAccessos.afegirAcces(Acc14);
        
        /* Pistes */
        llistaVies.buidar();
        Via V1  = new Via("V1",  "Iberica", 2, true, "100%"); llistaVies.afegirVia(V1);
        Via V2  = new Via("V2",  "Iberica", 2, true, "100%"); llistaVies.afegirVia(V2);
        Via V3  = new Via("V3",  "Internacional", 2, true, "100%");  llistaVies.afegirVia(V3);
        Via V4  = new Via("V4", "Iberica", 1, true, "100%"); llistaVies.afegirVia(V4);
        Via V5  = new Via("V5", "Iberica", 1, true, "100%");  llistaVies.afegirVia(V5);
        Via V6  = new Via("V6",  "Estreta", 1, true, "100%");  llistaVies.afegirVia(V6);
        Via V7  = new Via("V7",  "Estreta", 1, true, "100%");  llistaVies.afegirVia(V7);
         
        /* Accés */
        Acc1.afegirVia(V1);
        Acc2.afegirVia(V1); 
        Acc3.afegirVia(V2);
        Acc4.afegirVia(V2);
        Acc5.afegirVia(V3);
        Acc6.afegirVia(V3);
        Acc7.afegirVia(V4); Acc7.afegirVia(V6);
        Acc8.afegirVia(V4); Acc8.afegirVia(V6);
        Acc9.afegirVia(V5); Acc9.afegirVia(V7);
        Acc10.afegirVia(V5); Acc10.afegirVia(V7);
        Acc11.afegirVia(V6);
        Acc12.afegirVia(V6);
        Acc13.afegirVia(V7);
        Acc14.afegirVia(V7);
        
    }
}

