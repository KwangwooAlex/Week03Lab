package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.Note;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author 818396
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            // to read files
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            
            String str;
            ArrayList line = new ArrayList();
            boolean loop = true;
            while(loop) {
                if((str = br.readLine()) != null){
                    line.add(str);
                }else{
                    loop = false;
                }
            }
            br.close();
            
            Note note = new Note(line.get(0).toString(), line.get(1).toString());
            
            request.setAttribute("note", note);
            // getParameter("modify") -> href ="note?modify"  (using url)        
            
            if(request.getParameter("modify")==null){
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            }else{
           getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        
        Note note = new Note(title, contents);
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
        
        
        pw.write(title + "\n");
        pw.write(contents);
        pw.close();
        
        request.setAttribute("note", note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}