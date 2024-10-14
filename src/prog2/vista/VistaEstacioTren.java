package prog2.vista;
import java.util.Scanner;
import prog2.model.EstacioTren;

/**
 * Aquesta classe és responsable de la interacció amb l’usuari.
 * @author Yasmina Dermouh y Katerina Lothe
 */

public class VistaEstacioTren {
    
    // Instancia de EstacioTren
    private EstacioTren estacioTren;

    // Enumeración para las opciones del menú principal
    static private enum OpcionsMenuPrincipal {
        MENU_OPCIO1, MENU_OPCIO2, MENU_OPCIO3, MENU_OPCIO4, MENU_OPCIO5, MENU_OPCIO6, 
        MENU_OPCIO7_SUBMENU, MENU_OPCIO8, MENU_OPCIO9, MENU_OPCIO10, MENU_OPCIO11, MENU_OPCIO12, MENU_SORTIR
    }

    // Enumeración para las opciones del submenú
    static private enum OpcionsSubmenu {
        SUB_MENU_OPCIO1, SUB_MENU_OPCIO2, SUB_MENU_OPCIO3, SUB_MENU_SORTIR
    }
    
    // Descripciones de las opciones del menú principal
    static private String[] descMenuPrincipal = {
        "Llistar la informació de totes les vies",
        "Llistar la informació de les vies obertes",
        "Llistar la informació de les vies tancades",
        "Llistar la informació dels accessos oberts",
        "Llistar la informació dels accessos tancats",
        "Llistar la informació de les incidències actuals",
        "Afegir una incidència",
        "Eliminar una incidència",
        "Calcular i mostrar el número total d’accessos que proporcionen accessibilitat",
        "Calcular i mostrar el número total de metres de longitud d’accessos de nivell",
        "Guardar estació",
        "Recuperar estació",
        "Sortir de l’aplicació"
    };
    
    // Descripciones de las opciones del submenú
    static private String[] descMenu2 = {
        "Reparacio",
        "Objecte",
        "Tancament",
        "Sortir sense reportar incidència"
    };

    // Constructor
    public VistaEstacioTren(String nomEstacio) {
        this.estacioTren = new EstacioTren();
        try {
            this.estacioTren.inicialitzaDadesEstacioTren();
        } catch(ExcepcioEstacio e) {
            System.err.println(e.getMessage());
        }
    }
    
    // Método para gestionar el submenú
    public void gestioSubmenu() throws ExcepcioEstacio {
        Scanner sc = new Scanner(System.in);
        try{
            estacioTren.getLlistaIncidencies().llistarIncidencies();
        } catch (ExcepcioEstacio e) {
            System.out.println(e.getMessage());
        }

        Menu<OpcionsSubmenu> menu = new Menu<>("Introduïu el tipus d'incidència que voleu afegir: ", OpcionsSubmenu.values());
        menu.setDescripcions(descMenu2);
        menu.mostrarMenu();

        OpcionsSubmenu opcio = menu.getOpcio(sc);
        if (opcio == OpcionsSubmenu.SUB_MENU_SORTIR) {
            System.out.println("No s'hi ha afegit cap incidència.");
            return;
        }

        System.out.println("Heu triat l'opció " + (opcio.ordinal() + 1) + ".");
        System.out.print("Introdueix el número identificador de la incidència: ");
        int incidenciaId = sc.nextInt();
        System.out.print("Introdueix el nom de la via: ");
        String nomVia = sc.next();
        System.out.println("Introdueix la data de la incidència: ");
        String data = sc.next();

        String tipusIncidencia;
        switch (opcio) {
            case SUB_MENU_OPCIO1:
                tipusIncidencia = "REPARACIO";
                break;
            case SUB_MENU_OPCIO2:
                tipusIncidencia = "OBJECTE";
                break;
            case SUB_MENU_OPCIO3:
                tipusIncidencia = "TANCAMENT";
                break;
            default:
                tipusIncidencia = "";
        }

        estacioTren.afegirIncidencia(incidenciaId, tipusIncidencia, nomVia, data);
        System.out.println("Incidència per " + tipusIncidencia.toLowerCase() + " afegit correctament.");
    }
      
    // Método para gestionar la estación de tren
    public void gestioEstacioTren() {
        Scanner sc = new Scanner(System.in);

        Menu<OpcionsMenuPrincipal> menu = new Menu<>("Serveis del programa: ", OpcionsMenuPrincipal.values());
        menu.setDescripcions(descMenuPrincipal);

        OpcionsMenuPrincipal opcio = null;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);
            
            try {
                switch(opcio) {
                    case MENU_OPCIO1:
                        System.out.println(estacioTren.getLlistaVies().llistarVies("obert o tancat"));
                        break;
                        
                    case MENU_OPCIO2:
                        System.out.println(estacioTren.getLlistaVies().llistarVies("obert"));
                        break;
                        
                    case MENU_OPCIO3:
                        System.out.println(estacioTren.getLlistaVies().llistarVies("tancat"));
                        break;
                        
                    case MENU_OPCIO4:
                        System.out.println(estacioTren.getLlistaAccessos().llistarAccessos(true));
                        break;
                        
                    case MENU_OPCIO5:
                        System.out.println(estacioTren.getLlistaAccessos().llistarAccessos(false));
                        break;
                        
                    case MENU_OPCIO6:
                        System.out.println(estacioTren.getLlistaIncidencies().llistarIncidencies());
                        break;
                        
                    case MENU_OPCIO7_SUBMENU:
                        gestioSubmenu();
                        break;
                        
                    case MENU_OPCIO8:
                        int incidenciaId;
                        estacioTren.getLlistaIncidencies().llistarIncidencies();
                        System.out.println("Introduïu el número d'incidència que voleu suprimir: ");
                        incidenciaId = sc.nextInt();
                        estacioTren.eliminarIncidencia(incidenciaId);
                        System.out.println("Eliminació realitzada correctament. ");
                        break;
                        
                    case MENU_OPCIO9:
                        System.out.println("El nombre total d'accessos accessibles és: " + estacioTren.getLlistaAccessos().calculaAccessosAccessibles() + ".");
                        break;
                        
                    case MENU_OPCIO10:
                        System.out.println("La longitud total dels accessos de nivell és: " + estacioTren.getLlistaAccessos().calculaLongitudAccessosNivell() + " metres.");
                        break;
                        
                    case MENU_OPCIO11:
                        estacioTren.guardar("EstacioTren.dat");
                        System.out.println("Guardat amb èxit.");
                        break;
                        
                    case MENU_OPCIO12:
                        estacioTren = EstacioTren.carregar("EstacioTren.dat");
                        System.out.println("Recuperat amb èxit.");
                        break;
                        
                    case MENU_SORTIR:
                        System.out.println("Fins aviat!");
                        break;
                }
            } catch(ExcepcioEstacio e) {
                System.err.println(e.getMessage());
            }
            
        } while(opcio != OpcionsMenuPrincipal.MENU_SORTIR);
    }
}
