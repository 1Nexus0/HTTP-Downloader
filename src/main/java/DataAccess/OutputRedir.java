/*
 * Copyright (C) 2017
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package DataAccess;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;


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