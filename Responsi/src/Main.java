/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        ViewFilm view = new ViewFilm();
        ModelFilm model = new ModelFilm();
        new ControllerFilm(model, view);
    }
    
}
