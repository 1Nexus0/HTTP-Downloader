/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;
/**
 *
 * @author MistyukovE
 */



public class OutputRedir extends OutputStream {
    private final JTextArea textOut;

    public OutputRedir( JTextArea control ) {
        textOut = control;
    }

    @Override
    public void write( int b ) throws IOException {
        // append the data as characters to the JTextArea control
        textOut.append(String.valueOf(( char )b ));
    }  
}